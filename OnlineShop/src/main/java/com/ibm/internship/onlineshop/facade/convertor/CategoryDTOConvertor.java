package com.ibm.internship.onlineshop.facade.convertor;

import com.ibm.internship.onlineshop.facade.dtos.CategoryDTO;
import com.ibm.internship.onlineshop.model.Category;
import org.modelmapper.ModelMapper;

public class CategoryDTOConvertor implements Convertor<CategoryDTO, Category> {
    @Override
    public Category convert(CategoryDTO item) {
        return new ModelMapper().map(item, Category.class);
    }
}
