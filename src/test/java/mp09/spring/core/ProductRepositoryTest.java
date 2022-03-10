package mp09.spring.core;

import mp09.spring.core.entity.Product;
import mp09.spring.core.repository.ProductRepository;
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
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

//    @Test
//    public void testAddNew(){
//        Product product = new Product();
//        product.setProductname("Product Name Test");
//        product.setQty(10);
//        product.setPrice(20000L);
//        product.setDescription("Description Test");
//
//        Product savedProduct = productRepository.save(product);
//
//        Assertions.assertThat(savedProduct).isNotNull();
//        Assertions.assertThat(savedProduct.getId()).isGreaterThan(0);
//    }
//
//    @Test
//    public void testListAll(){
//        Iterable<Product> products = productRepository.findAll();
//        Assertions.assertThat(products).hasSizeGreaterThan(0);
//
//        for (Product product : products) {
//            System.out.println(product);
//        }
//    }
//
//    @Test
//    public void testUpdate(){
//        Integer productId = 1;
//        Optional<Product> optionalCategory = productRepository.findById(productId);
//        Product category = optionalCategory.get();
//        category.setProductname("This category has been updated");
//        productRepository.save(category);
//
//        Product updatedProduct = productRepository.findById(productId).get();
//        Assertions.assertThat(updatedProduct.getProductname()).isEqualTo("This category has been updated");
//    }
//
//    @Test
//    public void testGet(){
//        Integer productId = 1;
//        Optional<Product> optionalCategory = productRepository.findById(productId);
//        Assertions.assertThat(optionalCategory).isPresent();
//        System.out.println(optionalCategory.get());
//    }
//
//    @Test
//    public void testDelete(){
//        Integer productId = 1;
//        productRepository.deleteById(productId);
//
//        Optional<Product> product = productRepository.findById(productId);
//        Assertions.assertThat(product).isNotPresent();
//    }
}
