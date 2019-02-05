package com.ibm.internship.onlineshop.services;

import com.ibm.internship.onlineshop.model.Category;
import com.ibm.internship.onlineshop.persistance.CategoryRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private static Logger logger = Logger.getLogger(CategoryService.class);


    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAllCategories() throws ClassNotFoundException, IllegalAccessException {
        logger.debug("Get all categories");
        return categoryRepository.getAllCategories();
    }
}
