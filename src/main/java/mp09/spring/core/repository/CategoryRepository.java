package mp09.spring.core.repository;

import mp09.spring.core.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    public Long countById(Integer id);
}
