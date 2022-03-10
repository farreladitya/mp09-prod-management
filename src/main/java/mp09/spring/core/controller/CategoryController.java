package mp09.spring.core.controller;

import mp09.spring.core.entity.Category;
import mp09.spring.core.entity.Product;
import mp09.spring.core.repository.CategoryRepository;
import mp09.spring.core.service.CategoryServiceImpl;
import mp09.spring.core.utils.SearchData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    @Autowired private CategoryServiceImpl categoryService;
    @Autowired private CategoryRepository categoryRepository;

    @GetMapping("")
    public String showCategoryList(Model model) {
//        List<Category> categories = categoryService.getAll();
//        model.addAttribute("categories", categories);
//
//        return "product-category-list";
        return findPaginated(1, model);
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("category", new Category());
        model.addAttribute("pageTitle", "Add New Categories");

        return "add-product-category";
    }

    @PostMapping("/save")
    public String saveCategory(Category category, RedirectAttributes attributes) {
        categoryService.save(category);
        attributes.addFlashAttribute("message", "Category " + category.getName() + " successfully Added.");

        return "redirect:/categories";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes attributes) {
        try {
            Category category = categoryService.getById(id);
            model.addAttribute("category", category);
            model.addAttribute("pageTitle", "Edit Category (ID: " + id + ")");

            return "edit-product-category";
        } catch (Throwable e) {
            attributes.addFlashAttribute("message", e.getMessage());

            return "redirect:/categories";
        }
    }

    @PostMapping("/update")
    public String updateCategory(Category category, RedirectAttributes attributes) {
        categoryService.save(category);
        attributes.addFlashAttribute("message", "Category successfully updated.");

        return "redirect:/categories";
    }

    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable("id") Integer id, RedirectAttributes attributes) {
        try {
            categoryService.delete(id);
            attributes.addFlashAttribute("message", "Category successfully deleted.");
        } catch (Throwable e) {
            attributes.addFlashAttribute("message", e.getMessage());
        }

        return "redirect:/categories";
    }

    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo, Model model) {
        int pageSize = 5;

        Page<Category> page = categoryService.findPaginated(pageNo, pageSize);
        List<Category> categories = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("categories", categories);
        return "product-category-list";
    }

}
