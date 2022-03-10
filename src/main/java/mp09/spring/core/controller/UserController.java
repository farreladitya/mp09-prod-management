package mp09.spring.core.controller;

import mp09.spring.core.entity.Product;
import mp09.spring.core.entity.User;
import mp09.spring.core.service.ProductServiceImpl;
import mp09.spring.core.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("")
    public String showUsers(Model model) {
//        List<User> users = userService.getAll();
//        model.addAttribute("users", users);
//
//        return "user-list";
        return findPaginated(1, model);
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("pageTitle", "Add New User");

        return "add-user";
    }

    @PostMapping("/save")
    public String saveUser(User user, RedirectAttributes attributes) {
        userService.save(user);
        attributes.addFlashAttribute("message", "User " + user.getName() + " successfully Added.");

        return "redirect:/users";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes attributes) {
        try {
            User user = userService.getById(id);
            model.addAttribute("user", user);
            model.addAttribute("pageTitle", "Edit Product (ID: " + id + ")");

            return "edit-user";
        } catch (Throwable e) {
            attributes.addFlashAttribute("message", e.getMessage());

            return "redirect:/users";
        }
    }

    @PostMapping("/update")
    public String updateUser(User user, RedirectAttributes attributes) {
        userService.save(user);
        attributes.addFlashAttribute("message", "User successfully updated.");

        return "redirect:/users";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id, RedirectAttributes attributes) {
        try {
            userService.delete(id);
            attributes.addFlashAttribute("message", "User successfully deleted.");
        } catch (Throwable e) {
            attributes.addFlashAttribute("message", e.getMessage());
        }

        return "redirect:/users";
    }

    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo, Model model) {
        int pageSize = 5;

        Page<User> page = userService.findPaginated(pageNo, pageSize);
        List<User> users = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("users", users);
        return "user-list";
    }
}
