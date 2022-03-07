package mp09.spring.core.service;

import mp09.spring.core.entity.Category;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CategoryService {

    Category addCategory(Category category);

    List<Category> getAllCategory();

    Category getById(int id);

    Category update(Category category);

    void delete(int id);

}
