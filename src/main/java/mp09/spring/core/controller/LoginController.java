//package mp09.spring.core.controller;
//
//import mp09.spring.core.entity.User;
//import mp09.spring.core.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//
//@Controller
//
//public class LoginController {
//    @Autowired
//    private UserRepository userRepo;
//
//    @GetMapping("")
//    public String viewHomePage() {
//        return "index";
//    }
//    @GetMapping("/register")
//    public String showSignUpForm(Model model){
//        model.addAttribute("user", new User());
//        return "signup-form";
//    }
//    @PostMapping("/process_register")
//    public String processRegister(User user) {
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        String encodedPassword = passwordEncoder.encode(user.getPassword());
//        user.setPassword(encodedPassword);
//
//        userRepo.save(user);
//
//        return "register_success";
//    }
//}//
