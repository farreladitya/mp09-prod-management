package mp09.spring.core.service;

import mp09.spring.core.entity.Category;
import mp09.spring.core.entity.Product;
import mp09.spring.core.repository.CategoryRepository;
import mp09.spring.core.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public Product save(Product product) {
        productRepository.save(product);
        return product;
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product getById(Integer id) throws Throwable {
        Optional<Product> result = productRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        throw new Throwable("Could not find any products with id : " + id);
    }

    @Override
    public Product update(Product product) {
        productRepository.save(product);
        return product;
    }

    @Override
    public void delete(Integer id) throws Throwable {
        Long count = productRepository.countById(id);
        if (count == null || count == 0) {
            throw new Throwable("Could not find any products with id : " + id);
        }
        productRepository.deleteById(id);
    }

    @Override
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }
}
