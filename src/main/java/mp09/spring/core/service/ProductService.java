package mp09.spring.core.service;

import mp09.spring.core.entity.Category;
import mp09.spring.core.entity.Product;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProductService {

    Product save(Product product);

    List<Product> getAll();

    Product getById(Integer id) throws Throwable;

    Product update(Product product);

    void delete(Integer id) throws Throwable;

    List<Category> getCategories();
}
