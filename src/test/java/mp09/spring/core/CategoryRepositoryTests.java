package mp09.spring.core;

import mp09.spring.core.entity.Category;
import mp09.spring.core.repository.CategoryRepository;
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
public class CategoryRepositoryTests {

    @Autowired
    private CategoryRepository categoryRepository;

//    @Test
//    public void testAddNew(){
//        Category category = new Category();
//        category.setName("Category Test");
//
//        Category savedCategory = categoryRepository.save(category);
//
//        Assertions.assertThat(savedCategory).isNotNull();
//        Assertions.assertThat(savedCategory.getId()).isGreaterThan(0);
//    }
//
//    @Test
//    public void testListAll(){
//        Iterable<Category> categories = categoryRepository.findAll();
//        Assertions.assertThat(categories).hasSizeGreaterThan(0);
//
//        for (Category category : categories) {
//            System.out.println(category);
//        }
//    }
//
//    @Test
//    public void testUpdate(){
//        Integer categoryId = 1;
//        Optional<Category> optionalCategory = categoryRepository.findById(categoryId);
//        Category category = optionalCategory.get();
//        category.setName("This category has been updated");
//        categoryRepository.save(category);
//
//        Category updatedCategory = categoryRepository.findById(categoryId).get();
//        Assertions.assertThat(updatedCategory.getName()).isEqualTo("This category has been updated");
//    }
//
//    @Test
//    public void testGet(){
//        Integer categoryId = 1;
//        Optional<Category> optionalCategory = categoryRepository.findById(categoryId);
//        Assertions.assertThat(optionalCategory).isPresent();
//        System.out.println(optionalCategory.get());
//    }
//
//    @Test
//    public void testDelete(){
//        Integer categoryId = 2;
//        categoryRepository.deleteById(categoryId);
//
//        Optional<Category> optionalUser = categoryRepository.findById(categoryId);
//        Assertions.assertThat(optionalUser).isNotPresent();
//    }
}
