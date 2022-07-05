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

import su22b1_it16304_sof3021.beans.OrderDetailModel;
import su22b1_it16304_sof3021.entities.Category;
import su22b1_it16304_sof3021.entities.Order;
import su22b1_it16304_sof3021.entities.OrderDetail;
import su22b1_it16304_sof3021.entities.Product;
import su22b1_it16304_sof3021.repositories.OrderDetailRepository;
import su22b1_it16304_sof3021.repositories.OrderRepository;
import su22b1_it16304_sof3021.repositories.ProductRepository;

@Controller
@RequestMapping("/admin/orderDetails")
public class OrderDetailController {
	@Autowired
	private OrderDetailRepository detailRepo;
	
	@Autowired
	private OrderRepository orderRepo;
	
	@Autowired
	private ProductRepository productRepo;
	
	@PostMapping("store")
	public String store(
			OrderDetail detail,
			Model model,
			HttpSession session,
			@Validated @ModelAttribute("item") OrderDetailModel detailModel, 
			BindingResult bindingResult,
			@RequestParam(name="page", defaultValue="0") Integer page,
			@RequestParam(name="size", defaultValue="5") Integer size
	){
		if (bindingResult.hasErrors() == true) {
			String view = "/views/admin/orderDetails/index.jsp";
			String form = "/views/admin/orderDetails/_form.jsp";
			model.addAttribute("views", view);
			model.addAttribute("form", form);
			
			Pageable pageable = PageRequest.of(page, size , Sort.by("id"));
			Page<OrderDetail> data = this.detailRepo.findAll(pageable);
			
			List<Order> orderList = this.orderRepo.findAll();
			List<Product> productList = this.productRepo.findAll();
			
			model.addAttribute("orderList", orderList);
			model.addAttribute("productList", productList);
			
			model.addAttribute("data", data);
			model.addAttribute("item", detailModel);
			
			session.setAttribute("lgError", "Thêm mới thất bại");
			return"/layout";
		} else {
			detail.setOrder(detailModel.getOrder());
			detail.setProduct(detailModel.getProduct());
			detail.setPrice(detailModel.getPrice());
			detail.setQuantity(detailModel.getQuantity());
			
			detailRepo.save(detail);
			session.setAttribute("lgSuccess", "Thêm mới thành công");
			return "redirect:/admin/orderDetails/index";
		}
	}
	@PostMapping("update/{id}")
	public String update(
			OrderDetailModel detailModel, 
			HttpSession session,
			@PathVariable("id") OrderDetail detail)
	{
		detail.setOrder(detailModel.getOrder());
		detail.setProduct(detailModel.getProduct());
		detail.setPrice(detailModel.getPrice());
		detail.setQuantity(detailModel.getQuantity());
		
		detailRepo.save(detail);
		session.setAttribute("lgSuccess", "Cập nhật thành công");
		return "redirect:/admin/orderDetails/index";
	}
	@GetMapping("delete/{id}")
	public String delete(@PathVariable("id") Integer id,HttpSession session) {
		
		detailRepo.deleteById(id);
		session.setAttribute("lgSuccess", "Xóa thành công");
		return "redirect:/admin/orderDetails/index";
	}
	@GetMapping("edit/{id}")
	public String edit(
			@PathVariable("id") Integer id,
			Model model,
			@RequestParam(name="page", defaultValue="0") Integer page,
			@RequestParam(name="size", defaultValue="5") Integer size
	) {
		String view = "/views/admin/orderDetails/index.jsp";
		String form = "/views/admin/orderDetails/_formUpdate.jsp";
		model.addAttribute("views", view);
		model.addAttribute("form", form);
		
		OrderDetail item =  this.detailRepo.getById(id);
		Pageable pageable = PageRequest.of(page, size);
		Page<OrderDetail> data = this.detailRepo.findAll(pageable);
		
		List<Order> orderList = this.orderRepo.findAll();
		List<Product> productList = this.productRepo.findAll();
		
		model.addAttribute("orderList", orderList);
		model.addAttribute("productList", productList);
		
		model.addAttribute("data", data);
		model.addAttribute("item", item);
		
		return "/layout";
	}
	
	@GetMapping("index")
	public String index(
			Model model,
			OrderDetailModel item,
			@RequestParam(name="page", defaultValue="0") Integer page,
			@RequestParam(name="size", defaultValue="5") Integer size
	) {
		String view = "/views/admin/orderDetails/index.jsp";
		String form = "/views/admin/orderDetails/_form.jsp";
		model.addAttribute("views", view);
		model.addAttribute("form", form);
		
		Pageable pageable = PageRequest.of(page, size, Sort.by("id"));
		Page<OrderDetail> data = this.detailRepo.findAll(pageable);
		
		List<Order> orderList = this.orderRepo.findAll();
		List<Product> productList = this.productRepo.findAll();
		
		model.addAttribute("orderList", orderList);
		model.addAttribute("productList", productList);
		
		model.addAttribute("data", data);
		model.addAttribute("item", item);
		return"/layout";
	}
}
