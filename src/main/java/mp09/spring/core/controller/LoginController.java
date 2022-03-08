package mp09.spring.core.controller;

import mp09.spring.core.entity.User;
import mp09.spring.core.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    @Autowired
    private UserRepository repo;

    @GetMapping("")
    public String viewHomePage(){
        return "login";
    }
    @GetMapping("/register")
    public String showSignUpForm(Model model){
        model.addAttribute("user", new User());
        return "signup-form";
    }
    @PostMapping("/process_register")
    public String processRegistration(User user){
        repo.save(user);

        return "register_success";
    }
}
