package su22b1_it16304_sof3021.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import su22b1_it16304_sof3021.beans.BuyModel;
import su22b1_it16304_sof3021.beans.CartModel;
import su22b1_it16304_sof3021.beans.CategoryModel;
import su22b1_it16304_sof3021.beans.ProductModel;
import su22b1_it16304_sof3021.beans.updatePassModel;
import su22b1_it16304_sof3021.entities.Account;
import su22b1_it16304_sof3021.entities.Cart;
import su22b1_it16304_sof3021.entities.Category;
import su22b1_it16304_sof3021.entities.Order;
import su22b1_it16304_sof3021.entities.OrderDetail;
import su22b1_it16304_sof3021.entities.Product;
import su22b1_it16304_sof3021.repositories.AccountRepository;
import su22b1_it16304_sof3021.repositories.CartRepository;
import su22b1_it16304_sof3021.repositories.CategoryRepository;
import su22b1_it16304_sof3021.repositories.OrderDetailRepository;
import su22b1_it16304_sof3021.repositories.OrderRepository;
import su22b1_it16304_sof3021.repositories.ProductRepository;



@Controller
public class HelloController {
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	public ProductRepository repository;
	@Autowired
	public CategoryRepository categoryRepo;
	@Autowired
	public AccountRepository accountRepository;
	@Autowired
	public OrderDetailRepository orderDetailRepository;
	@Autowired
	public OrderRepository orderRepository;
	@Autowired
	public CartRepository cartRepository;
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	int id = 0;
	
	@GetMapping("home")
	public String index(
			Model model
	) {
		List<Cart> carts = cartRepository.findAll();
		model.addAttribute("cartValue", carts);
		model.addAttribute("carts", carts.size());
		
		String view = "/views/home.jsp";
		model.addAttribute("views", view);
		return "/layout";
	}
	@PostMapping("findpro")
	public String findpro(
			Model model,
			@ModelAttribute("item") ProductModel productModel
	) {
		Category category = productModel.getCategory();

		List<Cart> carts = cartRepository.findAll();
		model.addAttribute("cartValue", carts);
		model.addAttribute("carts", carts.size());
		
		String view = "/views/products.jsp";
		model.addAttribute("views", view);
		
		List<Category> cateLst = this.categoryRepo.findAll();
		model.addAttribute("cateLst", cateLst);
		if (category == null) {
			List<Product> items = this.repository.findAll();
			model.addAttribute("items", items);
		} else {
			List<Product> items = this.repository.findProductByCate_id(category.getId());
			model.addAttribute("items", items);
		}
		
		
		return"/layout";
	}
	
	@GetMapping("products")
	public String products(
			Model model,
			@ModelAttribute("carts") CartModel cartModel
	) {
		List<Cart> carts = cartRepository.findAll();
		model.addAttribute("cartValue", carts);
		model.addAttribute("carts", carts.size());
		
		List<Product> items = this.repository.findAll();
		List<Category> cateLst = this.categoryRepo.findAll();
		
		String view = "/views/products.jsp";
		model.addAttribute("views", view);
		model.addAttribute("items", items);
		model.addAttribute("cateLst", cateLst);
		return "/layout";
	}
	@PostMapping("/admin/updatePass")
	public String updatePass(
			HttpSession session,
			@Validated @ModelAttribute("updatePass") updatePassModel passModel,
			BindingResult bindingResult,
			Model model
	) { 
		Account account = (Account) session.getAttribute("user");
		if (bindingResult.hasErrors() == true) {
			String view = "/views/updatePass.jsp";
			model.addAttribute("views", view);
			model.addAttribute("updatePass", passModel);
			session.setAttribute("lgError", "Đổi mật khẩu thất bại");
			return "layout";
		} else {
			if (!account.getPassword().equals(passModel.getOldPass())) {
				String view = "/views/updatePass.jsp";
				model.addAttribute("views", view);
				model.addAttribute("updatePass", passModel);
				session.setAttribute("lgError", "Bạn nhập sai mật khẩu cũ");
				return "layout";
			}else if (!passModel.getNewPass().equals(passModel.getReNewPass())) {
				String view = "/views/updatePass.jsp";
				model.addAttribute("views", view);
				model.addAttribute("updatePass", passModel);
				session.setAttribute("lgError", "Mật khẩu mới không khớp !");
				return "layout";
			}
			account.setPassword(passModel.getNewPass());
			accountRepository.save(account);
			model.addAttribute("updatePass", passModel);
			session.setAttribute("lgSuccess", "Đổi mật khẩu thành công !");
			session.removeAttribute("user");
			return "redirect:/login";
		}
	}
	
	@GetMapping("/admin/showUpPass")
	public String showUpdate(
			Model model,
			updatePassModel updatePassModel
	) {
		String view = "/views/updatePass.jsp";
		model.addAttribute("views", view);
		model.addAttribute("updatePass", updatePassModel);
		return "layout";
	}
	
	@GetMapping("logout")
	public String logout(
			Model model,
			HttpSession session
	) {
		session.removeAttribute("user");
		session.setAttribute("lgSuccess", "Đăng xuất thành công");
		
		return "redirect:/home";
	}
	@GetMapping("action/buy/{id}")
	public String buy(
			@PathVariable("id") Integer integer,
			Model model,
			BuyModel buyModel,
			Product product,
			ProductModel productModel,
			HttpSession session
	) {
		List<Cart> carts = cartRepository.findAll();
		model.addAttribute("cartValue", carts);
		model.addAttribute("carts", carts.size());
		
		model.addAttribute("item", buyModel);
		String path="/views/formBuy.jsp";
		model.addAttribute("views", path);
		product = productRepository.findById(integer).get();
		id = product.getId();
		model.addAttribute("product", product);
		
		LocalDate now = LocalDate.now();
		model.addAttribute("nowDate", dtf.format(now));

		return "/layout";
	}
	@PostMapping("confirm")
	public String confimBuy(
			@Validated @ModelAttribute("item") BuyModel buyModel,
			BindingResult bindingResult,
			Product product,
			Model model,
			HttpSession session,
			Account account,
			OrderDetail detail,
			Order order
	) throws ParseException {
		if (bindingResult.hasErrors() == true) {
			session.setAttribute("lgError", "Đặt hàng không thành công");
			model.addAttribute("item", buyModel);
			String path="/views/formBuy.jsp";
			model.addAttribute("views", path);
			product = productRepository.getById(id);
			model.addAttribute("product", product);
			
			LocalDate now = LocalDate.now();
			model.addAttribute("nowDate", dtf.format(now));
			
			return "layout";
		} else {
			account = (Account) session.getAttribute("user");
			
			// add order
			order.setUser(account);
			order.setCreatedDate(buyModel.getCreatedDate());
			order.setAddress(buyModel.getAddress());
			
			orderRepository.save(order);
			// add orderDetails
			detail.setOrder(order);
			product = productRepository.getById(id);
			detail.setProduct(product);
			detail.setPrice(buyModel.getAvailable() * product.getPrice());
			detail.setQuantity(buyModel.getAvailable());
			
			product.setAvailable(product.getAvailable() - buyModel.getAvailable());
			productRepository.save(product);
			orderDetailRepository.save(detail);
			session.setAttribute("lgSuccess", "Đặt Hàng thành công");
			return"redirect:/products";
		}
		
	}
	@GetMapping("action/addToCart/{id}")
	public String addToCart(
			@PathVariable("id") Product product,
			HttpSession session,
			Cart cart
	) {
		Account user = (Account) session.getAttribute("user");
		List<Cart> carts = cartRepository.findAll();
		
		for (Cart cart2 : carts) {
			if (product.getId() == cart2.getProduct().getId()) {
				cart2.setAvailable(cart2.getAvailable() + 1);
				cartRepository.save(cart2);
				session.setAttribute("lgSuccess", "Thêm vào giỏ Hàng thành công");
				return "redirect:/products";
			}
		}
		
		cart.setUser(user);
		cart.setProduct(product);
		cart.setAvailable(1);
		cartRepository.save(cart);
		
		session.setAttribute("lgSuccess", "Thêm vào giỏ Hàng thành công");
		return "redirect:/products";
	}
	
}