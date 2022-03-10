package mp09.spring.core.service;

import mp09.spring.core.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CategoryService {

    Category save(Category category);

    List<Category> getAll();

    Category getById(Integer id) throws Throwable;

    Category update(Category category);

    void delete(Integer id) throws Throwable;

    Page<Category> findPaginated(int pageNo, int pageSize);
}
