package su22b1_it16304_sof3021.controllers.admin;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import su22b1_it16304_sof3021.beans.AccountModel;
import su22b1_it16304_sof3021.entities.Account;
import su22b1_it16304_sof3021.repositories.AccountRepository;

@Controller
@RequestMapping("/admin/accounts")
public class AccountController {
	@Autowired
	private AccountRepository accountRepo;
	
	@PostMapping("store")
	public String store(
			@Validated @ModelAttribute("item") AccountModel accModel,
			BindingResult bindingResult,
			Account account,
			Model model,
			HttpSession session,
			@RequestParam(name="page", defaultValue="0") Integer page,
			@RequestParam(name="size", defaultValue="5") Integer size
	){
		if (bindingResult.hasErrors() == true) {
			String form ="/views/admin/accounts/_form.jsp";
			model.addAttribute("form", form);
			String view = "/views/admin/accounts/index.jsp";
			model.addAttribute("views", view);
			Pageable pageable = PageRequest.of(page, size, Sort.by("id"));
			Page<Account> data = this.accountRepo.findAll(pageable);
			model.addAttribute("data", data);
			model.addAttribute("item", accModel);
			
			session.setAttribute("lgError", "Thêm mới thất bại");
			return "/layout";
		} else {
		// Chuyển AccountModel -> entities.Account
		 
		account.setFullname(accModel.getFullname());
		account.setEmail(accModel.getEmail());
		account.setUsername(accModel.getUsername());
		account.setPassword(accModel.getPassword());
		account.setPhoto("/su22b1_it16304_sof3021/images/user/"+accModel.getPhoto());
		account.setAdmin(accModel.getAdmin());
		account.setActivated(0);
		this.accountRepo.save(account);
		session.setAttribute("lgSuccess", "Thêm mới Thành công !");
		return "redirect:/admin/accounts/index";

		}
	}
	
	@GetMapping("delete/{id}")
	public String delete(@PathVariable("id") Integer id,
			HttpSession session)
	{
		// Truy vấn theo id
		accountRepo.deleteById(id);
		session.setAttribute("lgSuccess", "Xóa Thành công !");
		return "redirect:/admin/accounts/index";
	}
	@PostMapping("update/{id}")
	public String update(@PathVariable("id") Account account, 
			AccountModel accModel,
			HttpSession session)
	{
		
		account.setFullname(accModel.getFullname());
		account.setEmail(accModel.getEmail());
		account.setUsername(accModel.getUsername());
		account.setPassword(accModel.getPassword());
		if (!accModel.getPhoto().isBlank()) {
			account.setPhoto("/su22b1_it16304_sof3021/images/user/"+accModel.getPhoto());
		}
		account.setAdmin(accModel.getAdmin());
		account.setActivated(0);
		this.accountRepo.save(account);
		session.setAttribute("lgSuccess", "Cập nhật Thành công !");
		return "redirect:/admin/accounts/index";
	}
	@GetMapping("edit/{id}")
	public String edit(
			Model model,
			@PathVariable("id") Integer id,
			@RequestParam(name="page", defaultValue="0") Integer page,
			@RequestParam(name="size", defaultValue="5") Integer size
	) {
		String form ="/views/admin/accounts/_formUpdate.jsp";
		model.addAttribute("form", form);
		String view = "/views/admin/accounts/index.jsp";
		model.addAttribute("views", view);
		Account item = this.accountRepo.findById(id).get();
		Pageable pageable = PageRequest.of(page, size);
		Page<Account> data = this.accountRepo.findAll(pageable);
		model.addAttribute("data", data);
		model.addAttribute("item", item);
		
		model.addAttribute("pass", item.getPassword());
		
		return "/layout";
	}
	
	@GetMapping("index")
	public String index(
			Model model,
			AccountModel item,
			@RequestParam(name="page", defaultValue="0") Integer page,
			@RequestParam(name="size", defaultValue="5") Integer size
	) {
		String form ="/views/admin/accounts/_form.jsp";
		model.addAttribute("form", form);
		String view = "/views/admin/accounts/index.jsp";
		model.addAttribute("views", view);
		Pageable pageable = PageRequest.of(page, size, Sort.by("id"));
		Page<Account> data = this.accountRepo.findAll(pageable);
		model.addAttribute("data", data);
		model.addAttribute("item", item);
		
		return "/layout";
	}
}
