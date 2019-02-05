package com.ibm.internship.onlineshop.facade;

import com.ibm.internship.onlineshop.facade.convertor.CategoryConvertor;
import com.ibm.internship.onlineshop.facade.convertor.Convertor;
import com.ibm.internship.onlineshop.facade.dtos.CategoryDTO;
import com.ibm.internship.onlineshop.services.CategoryService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategoryFacade {

    private static Logger logger = Logger.getLogger(CategoryService.class);

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CategoryConvertor convertor;

    public List<CategoryDTO> getAllCategories() throws IllegalAccessException, ClassNotFoundException {
        logger.debug("Get all categories");
        return categoryService.getAllCategories().stream()
                .map(c -> convertor.convert(c))
                .collect(Collectors.toList());
    }
}
