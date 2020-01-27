package com.tchokoapps.apache.wicket.springbootwicketpro.services;

import com.tchokoapps.apache.wicket.springbootwicketpro.entities.Category;
import com.tchokoapps.apache.wicket.springbootwicketpro.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class CategoryService {

    CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Set<Category> getCategories() {
        Set<Category> categories = new HashSet<>();
        categoryRepository.findAll().forEach(categories::add);
        return categories;
    }

    public Category findById(Long id) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        if(!categoryOptional.isPresent()) {
            throw new RuntimeException(String.format("Category with id=%s not found"));
        }
        return categoryOptional.get();
    }

    @Transactional
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }
}
