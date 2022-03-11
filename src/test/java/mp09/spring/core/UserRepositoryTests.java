package mp09.spring.core;

import static org.assertj.core.api.Assertions.assertThat;

import mp09.spring.core.entity.User;
import mp09.spring.core.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository repo;

    // test methods go below
    @Test
    public void testCreateUser() {
        User user = new User();
        user.setEmail("ravikumar@gmail.com");
        user.setPassword("ravi2020");
        user.setName("Ravi");


        User savedUser = repo.save(user);

        User existUser = entityManager.find(User.class, savedUser.getId());

        assertThat(user.getEmail()).isEqualTo(existUser.getEmail());

    }
}
//    @Test
//    public void testAddNew(){
//        User user = new User();
//        user.setEmail("dennito@gmail.com");
//        user.setName("Dennito");
//        user.setPassword("passworddennito");
//
//        User savedUser = userRepository.save(user);
//
//        Assertions.assertThat(savedUser).isNotNull();
//        Assertions.assertThat(savedUser.getId()).isGreaterThan(0);
//    }
//
//    @Test
//    public void testListAll(){
//        Iterable<User> users = userRepository.findAll();
//        Assertions.assertThat(users).hasSizeGreaterThan(0);
//
//        for (User user : users) {
//            System.out.println(user);
//        }
//    }
//
//    @Test
//    public void testUpdate(){
//        Integer userId = 1;
//        Optional<User> optionalUser = userRepository.findById(userId);
//        User user = optionalUser.get();
//        user.setPassword("admin123");
//        userRepository.save(user);
//
//        User updatedUser = userRepository.findById(userId).get();
//        Assertions.assertThat(updatedUser.getPassword()).isEqualTo("admin123");
//    }
//
//    @Test
//    public void testGet(){
//        Integer userId = 1;
//        Optional<User> optionalUser = userRepository.findById(userId);
//        Assertions.assertThat(optionalUser).isPresent();
//        System.out.println(optionalUser.get());
//    }
//
//    @Test
//    public void testDelete(){
//        Integer userId = 1;
//        userRepository.deleteById(userId);
//
//        Optional<User> optionalUser = userRepository.findById(userId);
//        Assertions.assertThat(optionalUser).isNotPresent();
//    }}

