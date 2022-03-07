package mp09.spring.core.service;

import mp09.spring.core.entity.Category;
import mp09.spring.core.repository.category.CategoryRepository;
import mp09.spring.core.repository.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl {

    @Autowired
    CategoryRepository categoryRepository;

    public List<Category> listAll() {
        return (List<Category>) categoryRepository.findAll();
    }
}
