package mp09.spring.core.controller;

import mp09.spring.core.entity.Category;
import mp09.spring.core.service.CategoryService;
import mp09.spring.core.service.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CategoryController {

    @Autowired private CategoryServiceImpl categoryService;

    @GetMapping("/categories")
    public String showCategoryList(Model model) {
        List<Category> categories = categoryService.listAll();
        model.addAttribute("categories", categories);

        return "product-category-list";
    }
}
