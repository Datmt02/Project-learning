package su22b1_it16304_sof3021.controller;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import su22b1_it16304_sof3021.beans.AccountModel;
import su22b1_it16304_sof3021.beans.LoginModel;
import su22b1_it16304_sof3021.beans.MailModel;
import su22b1_it16304_sof3021.beans.codeModel;
import su22b1_it16304_sof3021.entities.Account;
import su22b1_it16304_sof3021.repositories.AccountRepository;

@Controller
public class LoginController {
	@Autowired
	public AccountRepository accountRepo;
	@Autowired
	JavaMailSender javaMailSender;
	
	AccountModel _accountModel= null;
	//random code
	private static final String alpha = "abcdefghijklmnopqrstuvwxyz"; // a-z
    private static final String alphaUpperCase = alpha.toUpperCase(); // A-Z
    private static final String digits = "0123456789"; // 0-9
    private static final String ALPHA_NUMERIC = alpha + alphaUpperCase + digits;
    
    private static Random generator = new Random();
    
    /**
     * Random string with a-zA-Z0-9, not included special characters
     */
    public static int randomNumber(int min, int max) {
        return generator.nextInt((max - min) + 1) + min;
    }
    
    public String randomAlphaNumeric(int numberOfCharactor) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numberOfCharactor; i++) {
            int number = randomNumber(0, ALPHA_NUMERIC.length() - 1);
            char ch = ALPHA_NUMERIC.charAt(number);
            sb.append(ch);
        }
        return sb.toString();
    }
    int numberOfCharactor = 6;
    
    String code = "";
	 String _emaiReset;
    // end random
    
	@GetMapping("login")
	public String getlogin(
			Model model
	) {
		String view = "/views/login.jsp";
		model.addAttribute("views", view);
		return"/layout";
	}
	
	public void send(
			MailModel mail,
			String emailMD,
			HttpSession session
	) throws MessagingException {
		MimeMessage message = javaMailSender.createMimeMessage();
		
		code = randomAlphaNumeric(numberOfCharactor);
		
		// write mail
		MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
		helper.setFrom("tdmotoshop@gmail.com");
		helper.setTo(emailMD);
		helper.setSubject("Mã xác Nhận");
		helper.setText("Mã Xác Nhận Của Bạn Là:"+ code,true);
		helper.setReplyTo("tdmotoshop@gmail.com");
		for (String email : mail.getCc()) {
			helper.addCc(email);
		}
		for (String email : mail.getBcc()) {
			helper.addBcc(email);
		}
		for (File file : mail.getFiles()) {
			helper.addAttachment(file.getName(), file);
		}
		javaMailSender.send(message);
		System.out.println("send Mail success");
		try {
		    Thread.sleep(30000);
		} catch (InterruptedException ie) {
		    ie.printStackTrace();
		}
	}
	@PostMapping("resetPass")
	public String resetPass(
			@ModelAttribute("itemCode") codeModel codeModel,
			HttpSession session,
			Model model,
			MailModel mail
	) throws MessagingException {
		List<Account> accounts = accountRepo.findAll();
		
		if (codeModel.getEmail().isBlank()) {
			session.setAttribute("lgError", "Vui lòng nhập Email! ");
			
			String view = "/views/resetPass.jsp";
			model.addAttribute("views", view);
			return"/layout";
		}
		for (Account account : accounts) {
			if (account.getEmail().equals(codeModel.getEmail())) {
				_emaiReset = account.getEmail();
				send(mail, account.getEmail(), session);
				
				String view = "/views/resetPass.jsp";
				model.addAttribute("views", view);
				return"/layout";
			}
		}
		session.setAttribute("lgError", "Email này chưa có tài khoản! ");
		String view = "/views/resetPass.jsp";
		model.addAttribute("views", view);
		return "/layout";
	}
	@PostMapping("confirmReset")
	public String confirmReset(
			@ModelAttribute("itemCode") codeModel codeModel,
			Model model,
			HttpSession session
	) {
		if (codeModel.getCode().equals(code)) {
			String view = "/views/conFirmResetPass.jsp";
			model.addAttribute("views", view);
			return"/layout";
		}else {
			String view = "/views/resetPass.jsp";
			model.addAttribute("views", view);
			model.addAttribute("itemCode", codeModel);
			session.setAttribute("lgError", "Sai mã xác nhận !");
			return"/layout";
		}
		
	}
	@PostMapping("confirmResetPass")
	public String confirmResetPass(
			@ModelAttribute("itemCode") codeModel codeModel,
			HttpSession session,
			Model model
	) {
		Account account = accountRepo.findByEmailFPT(_emaiReset);
		if (codeModel.getNewPass().equals(codeModel.getReNewPass())) {
			account.setPassword(codeModel.getNewPass());
			accountRepo.save(account);
			
			session.setAttribute("lgSuccess", "Lấy lại mật khẩu thành công");
			
			String view = "/views/login.jsp";
			model.addAttribute("views", view);
			return "layout";
		}else if (codeModel.getNewPass().isBlank() || codeModel.getReNewPass().isBlank()) {
			session.setAttribute("lgError", "Không được bỏ trống mật khẩu !");
			String view = "/views/conFirmResetPass.jsp";
			model.addAttribute("views", view);
			return"/layout";
		}else {
			
			session.setAttribute("lgError", "Mật khẩu mới không trùng nhau !");
			String view = "/views/conFirmResetPass.jsp";
			model.addAttribute("views", view);
			return"/layout";
		}
		
	}
	@PostMapping("register")
	public String register(
			@Validated @ModelAttribute("item") AccountModel accModel,
			BindingResult bindingResult,
			codeModel codeModel,
			Account account,
			MailModel mail,
			HttpSession session,
			Model model
	) throws MessagingException {
		List<Account> accounts = accountRepo.findAll();
		if (bindingResult.hasErrors() == true ) {
			System.out.println(accModel);
			String view = "/views/Register.jsp";
			model.addAttribute("views", view);
			model.addAttribute("itemCode", codeModel);
			session.setAttribute("lgError", "Đăng ký không thành công !");
			return"/layout";
		}else {
			if (!accModel.getPassword().equals(accModel.getRePassword())) {
				String view = "/views/Register.jsp";
				model.addAttribute("views", view);
				model.addAttribute("itemCode", codeModel);
				session.setAttribute("lgError", "Mật khẩu không trùng nhau !");
				return"/layout";
			} 
			for (Account account2 : accounts) {
				if (account2.getEmail().equals(accModel.getEmail())) {
					String view = "/views/Register.jsp";
					model.addAttribute("views", view);
					model.addAttribute("itemCode", codeModel);
					session.setAttribute("lgError", "Email này đã đăng ký vui lòng chọn Email khác !");
					return"/layout";
				}
			}
			_accountModel = accModel;
			
			send(mail, accModel.getEmail(), session);
			
			String view = "/views/Register.jsp";
			model.addAttribute("views", view);
			return"/layout";
		}
	}
	
	@PostMapping("confirmCode")
	public String confirmCode(
			@ModelAttribute("itemCode") codeModel codeModel,
			Account account,
			AccountModel accountModel,
			Model model,
			HttpSession session
	) {
		if (codeModel.getCode().equals(code)) {
			account.setFullname(_accountModel.getFullname());
			account.setEmail(_accountModel.getEmail());
			account.setUsername(_accountModel.getUsername());
			account.setPassword(_accountModel.getPassword());
			account.setPhoto("/su22b1_it16304_sof3021/images/user/"+_accountModel.getPhoto());
			account.setAdmin(_accountModel.getAdmin());
			account.setActivated(0);
			
			this.accountRepo.save(account);
			
			session.setAttribute("lgSuccess", "Đăng ký Thành công !");
			return "redirect:/login";
		} else {
			String view = "/views/Register.jsp";
			model.addAttribute("views", view);
			model.addAttribute("item", accountModel);
			session.setAttribute("lgError", "Sai mã xác nhận !");
			return"/layout";
		}
		
	}
	@GetMapping("showResetPass")
	public String showResetPass(
			Model model,
			@ModelAttribute("itemCode") codeModel codeModel
	) {
		String view = "/views/resetPass.jsp";
		model.addAttribute("views", view);
		return"/layout";
	}
	
	@GetMapping("showFormRegister")
	public String showFormRegister(
			Model model,
			@ModelAttribute("item") AccountModel accountModel,
			@ModelAttribute("itemCode") codeModel codeModel
	) {
		String view = "/views/Register.jsp";
		model.addAttribute("views", view);
		return"/layout";
	}

	@PostMapping("dologin")
	public String login(
			@Validated @ModelAttribute("item") LoginModel loginModel,
			BindingResult bindingResult,
			Account account,
			HttpSession session,
			Model model
	) {
		if (bindingResult.hasErrors() == true) {
			String view = "/views/login.jsp";
			model.addAttribute("views", view);
			session.setAttribute("lgError", "Đăng nhập thất bại");
			return "/layout";
		}else {
			account = accountRepo.findByEmailFPT(loginModel.getEmail());
			if (account != null) {
				if (account.getPassword().equals(loginModel.getPassword()) ) {
					session.setAttribute("user", account);
					session.setAttribute("lgSuccess", "Đăng nhập thành công");
					return "redirect:/home";
				} else {
					String view = "/views/login.jsp";
					model.addAttribute("views", view);
					model.addAttribute("item", loginModel);
					session.setAttribute("lgError", "sai Mật khẩu!");
					return "/layout";
				}
			}else {
				String view = "/views/login.jsp";
				model.addAttribute("views", view);
				model.addAttribute("item", loginModel);
				session.setAttribute("lgError", "sai tên đăng Nhập!");
				return "/layout";
			}
		}
	}
	
}
