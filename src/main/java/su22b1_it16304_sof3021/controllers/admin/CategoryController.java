package su22b1_it16304_sof3021.controllers.admin;

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
import su22b1_it16304_sof3021.beans.CategoryModel;
import su22b1_it16304_sof3021.entities.Category;
import su22b1_it16304_sof3021.repositories.CategoryRepository;

@Controller
@RequestMapping("/admin/categories")
public class CategoryController {
	@Autowired
	private CategoryRepository categoryRepo;
//	
//	@Autowired
//	private Category category;
	
	@PostMapping("store")
	public String store(
			@Validated @ModelAttribute("item") CategoryModel categoryModel, 
			BindingResult bindingResult,
			Category category,
			HttpSession session,
			Model model,
			@RequestParam(name="page", defaultValue="0") Integer page,
			@RequestParam(name="size", defaultValue="5") Integer size
	){
		if (bindingResult.hasErrors() == true) {
			String view = "/views/admin/categories/index.jsp";
			model.addAttribute("views", view);
			String form = "/views/admin/categories/_form.jsp";
			model.addAttribute("form", form);
			
			Pageable pageable = PageRequest.of(page, size , Sort.by("id"));
			Page<Category> data = this.categoryRepo.findAll(pageable);
			model.addAttribute("data", data);
			model.addAttribute("item", categoryModel);
			session.setAttribute("lgError", "Thêm mới Thất bại !");
			return"/layout";
		} else {
			category.setName(categoryModel.getName());
			categoryRepo.save(category);
			session.setAttribute("lgSuccess", "Thêm mới Thành công !");
			return "redirect:/admin/categories/index";
		}
		
	}
	
	@PostMapping("update/{id}")
	public String update(
			@PathVariable("id") Category category,
			CategoryModel cateModel,
			HttpSession session
	) {
		category.setName(cateModel.getName());
		categoryRepo.save(category);
		session.setAttribute("lgSuccess", "Cập nhật Thành Công !");
		return "redirect:/admin/categories/index";
	}
	
	@GetMapping("edit/{id}")
	public String edit(
			@PathVariable("id") Integer id,
			Model model,
			@RequestParam(name="page", defaultValue="0") Integer page,
			@RequestParam(name="size", defaultValue="5") Integer size
	) {
		String form = "/views/admin/categories/_formUpdate.jsp";
		model.addAttribute("form", form);
		String view = "/views/admin/categories/index.jsp";
		model.addAttribute("views", view);
		
		Category item =  this.categoryRepo.getById(id);
		Pageable pageable = PageRequest.of(page, size);
		Page<Category> data = this.categoryRepo.findAll(pageable);
		model.addAttribute("data", data);
		model.addAttribute("item", item);
		
		return "/layout";
	}
	
	@GetMapping("delete/{id}")
	public String delete(@PathVariable("id") Integer id, HttpSession session)
	{
		// Truy vấn theo id
		categoryRepo.deleteById(id);
		session.setAttribute("lgSuccess", "Xóa Thành Công !");
		return "redirect:/admin/categories/index";
	}
	
	@GetMapping("index")
	public String index(
			Model model,
			@RequestParam(name="page",defaultValue = "0") Integer page,
			@RequestParam(name="size",defaultValue = "5") Integer size,
			CategoryModel item
	) {
		String view = "/views/admin/categories/index.jsp";
		model.addAttribute("views", view);
		String form = "/views/admin/categories/_form.jsp";
		model.addAttribute("form", form);
		
		Pageable pageable = PageRequest.of(page, size , Sort.by("id"));
		Page<Category> data = this.categoryRepo.findAll(pageable);
		model.addAttribute("data", data);
		model.addAttribute("item", item);
		return"/layout";
	}
	
}
