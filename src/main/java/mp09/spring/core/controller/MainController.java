package mp09.spring.core.controller;

import mp09.spring.core.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MainController {

    @GetMapping("")
    public String showHomePage() {
        System.out.println("main controller");
        return "index";
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }
}
