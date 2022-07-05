package su22b1_it16304_sof3021.controllers.admin;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Formatter;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

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

import su22b1_it16304_sof3021.beans.ProductModel;
import su22b1_it16304_sof3021.entities.Category;
import su22b1_it16304_sof3021.entities.Product;
import su22b1_it16304_sof3021.repositories.CategoryRepository;
import su22b1_it16304_sof3021.repositories.ProductRepository;

@Controller
@RequestMapping("/admin/products")
public class ProductController {
	@Autowired 
	public ProductRepository repository;
	
	@Autowired
	public CategoryRepository cateRepo;
	
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	@PostMapping("store")
	public String store(
			Product product,
			Model modelUI,
			HttpSession session,
			@Validated @ModelAttribute("item") ProductModel productModel,
			BindingResult bindResult,
			@RequestParam(name="page", defaultValue="0") Integer page,
			@RequestParam(name="size", defaultValue="5") Integer size
	) {
		System.out.println( bindResult.hasErrors() );
		if (bindResult.hasErrors() == true) {
			String form = "/views/admin/products/_form.jsp";
			String view = "/views/admin/products/index.jsp";
			modelUI.addAttribute("form", form);
			modelUI.addAttribute("views", view);
			
			LocalDate now = LocalDate.now();
			modelUI.addAttribute("nowDate", dtf.format(now));
			
			Pageable pageable = PageRequest.of(page, size, Sort.by("id"));
			Page<Product> data = this.repository.findAll(pageable);
			
			modelUI.addAttribute("data", data);
			modelUI.addAttribute("item", productModel);
			
			List<Category> calst = this.cateRepo.findAll();
			modelUI.addAttribute("calst", calst);
			
			session.setAttribute("lgError", "Thêm mới Thất bại");
			return "layout";
		} else {
			product.setCategory(productModel.getCategory());
			product.setAvailable(productModel.getAvailable());
			product.setName(productModel.getName());
			product.setImage("/su22b1_it16304_sof3021/images/products/"+ productModel.getImage());
			product.setPrice(productModel.getPrice());
			product.setCreatedDate(productModel.getCreatedDate());
			product.setMota(productModel.getMota());
			repository.save(product);
			session.setAttribute("lgSuccess", "Thêm mới Thành công");
			return "redirect:/admin/products/index";
		}

	}
	
	@PostMapping("update/{id}")
	public String update(
			ProductModel model,
			@PathVariable("id") Product product,
			HttpSession session
	) {
		
		product.setCategory(model.getCategory());
		product.setAvailable(model.getAvailable());
		product.setName(model.getName());
		if (!model.getImage().isBlank()) {
			product.setImage(model.getImage());
		}
		product.setPrice(model.getPrice());
		product.setCreatedDate(model.getCreatedDate());
		product.setMota(model.getMota());
		
		repository.save(product);
		session.setAttribute("lgSuccess", "Cập nhật Thành công");
		return "redirect:/admin/products/index";
	}
	
	@GetMapping("delete/{id}")
	public String delete(@PathVariable("id") Integer id,
			HttpSession session) {
		
		repository.deleteById(id);
		session.setAttribute("lgSuccess", "Xóa Thành công");
		return "redirect:/admin/products/index";
	}
	
	@GetMapping("edit/{id}")
	public String edit(
			@PathVariable("id") Product item,
			Model model,
			@RequestParam(name="page", defaultValue="0") Integer page,
			@RequestParam(name="size", defaultValue="5") Integer size
	) {
		String view = "/views/admin/products/index.jsp";
		String form = "/views/admin/products/_formUpdate.jsp";
		model.addAttribute("form", form);
		model.addAttribute("views", view);
		
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Pageable pageable = PageRequest.of(page, size);
		Page<Product> data = this.repository.findAll(pageable);
		model.addAttribute("data", data);
		model.addAttribute("item", item);
		
		List<Category> calst = this.cateRepo.findAll();
		model.addAttribute("calst", calst);
		
		Date oldDate = item.getCreatedDate();
		String newDate = format.format(oldDate);
		model.addAttribute("newDate", newDate);
		
		return "/layout";
	}
	@GetMapping("index")
	public String index(
		Model model,
		ProductModel item,
		@RequestParam(name="page", defaultValue="0") Integer page,
		@RequestParam(name="size", defaultValue="5") Integer size
	) {
		LocalDate now = LocalDate.now();
		String dateNow = dtf.format(now);
		model.addAttribute("nowDate", dateNow);
		
		String form = "/views/admin/products/_form.jsp";
		String view = "/views/admin/products/index.jsp";
		model.addAttribute("form", form);
		model.addAttribute("views", view);
		
		Pageable pageable = PageRequest.of(page, size, Sort.by("id"));
		Page<Product> data = this.repository.findAll(pageable);
		
		model.addAttribute("data", data);
		model.addAttribute("item", item);
		
		List<Category> calst = this.cateRepo.findAll();
		model.addAttribute("calst", calst);
		
		return "/layout";
	}
}
