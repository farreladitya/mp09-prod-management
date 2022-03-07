package mp09.spring.core.controller;

import mp09.spring.core.entity.Product;
import mp09.spring.core.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductServiceImpl productService;

    @GetMapping("")
    public String showProducts(Model model) {
        List<Product> products = productService.getAll();
        model.addAttribute("products", products);

        return "product-list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("pageTitle", "Add New Product");

        return "add-product";
    }

    @PostMapping("/save")
    public String saveProduct(Product product, RedirectAttributes attributes) {
        productService.save(product);
        attributes.addFlashAttribute("message", "Product " + product.getProductname() + " successfully Added.");

        return "redirect:/products";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes attributes) {
        try {
            Product product = productService.getById(id);
            model.addAttribute("product", product);
            model.addAttribute("pageTitle", "Edit Product (ID: " + id + ")");

            return "edit-product";
        } catch (Throwable e) {
            attributes.addFlashAttribute("message", e.getMessage());

            return "redirect:/products";
        }
    }

    @PostMapping("/update")
    public String updateProduct(Product product, RedirectAttributes attributes) {
        productService.save(product);
        attributes.addFlashAttribute("message", "Product successfully updated.");

        return "redirect:/products";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") Integer id, RedirectAttributes attributes) {
        try {
            productService.delete(id);
            attributes.addFlashAttribute("message", "Product successfully deleted.");
        } catch (Throwable e) {
            attributes.addFlashAttribute("message", e.getMessage());
        }

        return "redirect:/products";
    }
}
