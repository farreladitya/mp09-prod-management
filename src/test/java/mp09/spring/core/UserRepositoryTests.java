package mp09.spring.core;

import mp09.spring.core.entity.User;
import mp09.spring.core.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void testAddNew(){
        User user = new User();
        user.setEmail("dennito@gmail.com");
        user.setName("Dennito");
        user.setPassword("passworddennito");

        User savedUser = userRepository.save(user);

        Assertions.assertThat(savedUser).isNotNull();
        Assertions.assertThat(savedUser.getId()).isGreaterThan(0);
    }

    @Test
    public void testListAll(){
        Iterable<User> users = userRepository.findAll();
        Assertions.assertThat(users).hasSizeGreaterThan(0);

        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testUpdate(){
        Integer userId = 1;
        Optional<User> optionalUser = userRepository.findById(userId);
        User user = optionalUser.get();
        user.setPassword("admin123");
        userRepository.save(user);

        User updatedUser = userRepository.findById(userId).get();
        Assertions.assertThat(updatedUser.getPassword()).isEqualTo("admin123");
    }

    @Test
    public void testGet(){
        Integer userId = 1;
        Optional<User> optionalUser = userRepository.findById(userId);
        Assertions.assertThat(optionalUser).isPresent();
        System.out.println(optionalUser.get());
    }

    @Test
    public void testDelete(){
        Integer userId = 1;
        userRepository.deleteById(userId);

        Optional<User> optionalUser = userRepository.findById(userId);
        Assertions.assertThat(optionalUser).isNotPresent();
    }
}
