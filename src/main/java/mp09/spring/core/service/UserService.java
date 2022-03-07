package mp09.spring.core.service;

import mp09.spring.core.entity.Product;
import mp09.spring.core.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserService {

    User save(User user);

    List<User> getAll();

    User getById(Integer id) throws Throwable;

    User update(User user);

    void delete(Integer id) throws Throwable;
}
