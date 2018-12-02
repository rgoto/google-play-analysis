package com.project.senac.bcc.googleplayanalysis.Modules.Batch.Service;

import com.project.senac.bcc.googleplayanalysis.Modules.Batch.Model.Category;
import com.project.senac.bcc.googleplayanalysis.Modules.Batch.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

@Service
public class CategoryService implements Serializable {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category findByName(String category) {
        return categoryRepository.findByName(category);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public Category saveAndReturn(Category category) {
        return categoryRepository.save(category);
    }

    public Iterable<Category> findAll() {
        return categoryRepository.findAll();
    }
}
