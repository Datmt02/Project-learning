package su22b1_it16304_sof3021.controllers.admin;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
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

import su22b1_it16304_sof3021.beans.OrderModel;
import su22b1_it16304_sof3021.entities.Account;
import su22b1_it16304_sof3021.entities.Order;
import su22b1_it16304_sof3021.repositories.AccountRepository;
import su22b1_it16304_sof3021.repositories.OrderRepository;

@Controller
@RequestMapping("/admin/orders")
public class OrderController {
	@Autowired
	private OrderRepository orderRepo;
	
	@Autowired
	private AccountRepository accountRepo;
	
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	@PostMapping("store")
	public String store(
			Order order,
			Model model,
			HttpSession session,
			@Validated @ModelAttribute("item") OrderModel orderModel,
			BindingResult bindingResult,
			@RequestParam(name="page", defaultValue="0") Integer page,
			@RequestParam(name="size", defaultValue="5") Integer size
			
	) {
		System.out.println(bindingResult.hasErrors());
		if (bindingResult.hasErrors() == true) {
			String form = "/views/admin/orders/_form.jsp";
			String view = "/views/admin/orders/index.jsp";
			model.addAttribute("views", view);
			model.addAttribute("form", form);
			
			LocalDate now = LocalDate.now();
			model.addAttribute("nowDate", dtf.format(now));
			
			Pageable pageable = PageRequest.of(page, size, Sort.by("id"));
			Page<Order> data = this.orderRepo.findAll(pageable);
			
			model.addAttribute("data", data);
			model.addAttribute("item", orderModel);
			
			List<Account> accList = this.accountRepo.findAll();
			model.addAttribute("accList", accList);
			
			session.setAttribute("lgSuccess", "Thêm mới thất bại");
			return "layout";
		} else {
			
			order.setUser(orderModel.getUser());
			order.setCreatedDate(orderModel.getCreatedDate());
			order.setAddress(orderModel.getAddress());
			
			orderRepo.save(order);
			session.setAttribute("lgSuccess", "Thêm mới thành công");
			return "redirect:/admin/orders/index";
		}
		
	}
	
	@PostMapping("update/{id}")
	public String update(
			@PathVariable("id") Order order,
			OrderModel orderModel,
			HttpSession session
	) {
		System.out.println(orderModel);
		order.setUser(orderModel.getUser());
		order.setCreatedDate(orderModel.getCreatedDate());
		order.setAddress(orderModel.getAddress());
		
		orderRepo.save(order);
		session.setAttribute("lgSuccess", "Cập nhật thành công");
		return "redirect:/admin/orders/index";
	}
	
	@GetMapping("edit/{id}")
	public String edit(
			@PathVariable("id") Integer id,
			Model model,
			@RequestParam(name="page", defaultValue="0") Integer page,
			@RequestParam(name="size", defaultValue="5") Integer size
	) {
		String form = "/views/admin/orders/_formUpdate.jsp";
		model.addAttribute("form", form);
		String view = "/views/admin/orders/index.jsp";
		model.addAttribute("views", view);
		Order item = this.orderRepo.getById(id);
		Pageable pageable = PageRequest.of(page, size);
		Page<Order> data = this.orderRepo.findAll(pageable);
		
		List<Account> accList = this.accountRepo.findAll();
		model.addAttribute("accList", accList);
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date oldDate = item.getCreatedDate();
		String newDate = formatter.format(oldDate);
		
		model.addAttribute("newDate", newDate);
		model.addAttribute("data", data);
		model.addAttribute("item", item);
		return "/layout";
	}
	@GetMapping("delete/{id}")
	public String delete(
			@PathVariable("id") Integer id,
			HttpSession session
	) {
		orderRepo.deleteById(id);
		session.setAttribute("lgSuccess", "Xóa thành công");
		return "redirect:/admin/orders/index";
	}
	@GetMapping("index")
	public String index(
			Model model,
			OrderModel item,
			@RequestParam(name="page", defaultValue="0") Integer page,
			@RequestParam(name="size", defaultValue="5") Integer size
	){
		String form = "/views/admin/orders/_form.jsp";
		model.addAttribute("form", form);
		String view = "/views/admin/orders/index.jsp";
		model.addAttribute("views", view);
		Pageable pageable = PageRequest.of(page, size, Sort.by("id"));
		Page<Order> data = this.orderRepo.findAll(pageable);
		model.addAttribute("data", data);
		model.addAttribute("item", item);
		
		LocalDate now = LocalDate.now();
		model.addAttribute("nowDate", dtf.format(now));
		
		List<Account> accList = this.accountRepo.findAll();
		model.addAttribute("accList", accList);
		return "/layout";
	}
}
