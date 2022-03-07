package mp09.spring.core.repository;

import mp09.spring.core.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    public Long countById(Integer id);
}
