package mp09.spring.core.service;

import mp09.spring.core.entity.Category;
import mp09.spring.core.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    CategoryRepository categoryRepository;
    
    @Override
    public Category save(Category category) {
        categoryRepository.save(category);
        return category;
    }

    @Override
    public List<Category> getAll() {
        return (List<Category>) categoryRepository.findAll();
    }

    @Override
    public Category getById(Integer id) throws Throwable {
        Optional<Category> result = categoryRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        throw new Throwable("Could not find any categories with id : " + id);
    }

    @Override
    public Category update(Category category) {
        return null;
    }

    @Override
    public void delete(Integer id) throws Throwable {
        Long count = categoryRepository.countById(id);
        if (count == null || count == 0) {
            throw new Throwable("Could not find any categories with id : " + id);
        }
        categoryRepository.deleteById(id);
    }

    @Override
    public Page<Category> findPaginated(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return categoryRepository.findAll(pageable);
    }
}
