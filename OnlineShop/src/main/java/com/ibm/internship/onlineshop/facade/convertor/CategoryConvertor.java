package com.ibm.internship.onlineshop.facade.convertor;

import com.ibm.internship.onlineshop.facade.dtos.CategoryDTO;
import com.ibm.internship.onlineshop.model.Category;
import org.modelmapper.ModelMapper;

public class CategoryConvertor implements Convertor<Category, CategoryDTO> {
    @Override
    public CategoryDTO convert(Category item) {
        return new ModelMapper().map(item, CategoryDTO.class);
    }
}
