//package mp09.spring.core.service;
//
//import mp09.spring.core.entity.User;
//import mp09.spring.core.repository.UserRepository;
//import mp09.spring.core.security.CustomUserDetails;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//public class CustomUserDetailsService implements UserDetailsService {
//
//    @Autowired
//    private UserRepository userRepo;
//
//    @Override
//    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
//        User user = userRepo.findByName(name);
//        if (user == null) {
//            throw new UsernameNotFoundException("User not found");
//        }
//        return new CustomUserDetails(user);
//    }
//
//}
