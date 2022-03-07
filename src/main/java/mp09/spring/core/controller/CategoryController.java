package mp09.spring.core.controller;

import mp09.spring.core.entity.Category;
import mp09.spring.core.service.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    @Autowired private CategoryServiceImpl categoryService;

    @GetMapping("")
    public String showCategoryList(Model model) {
        List<Category> categories = categoryService.getAll();
        model.addAttribute("categories", categories);

        return "product-category-list";
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
}
