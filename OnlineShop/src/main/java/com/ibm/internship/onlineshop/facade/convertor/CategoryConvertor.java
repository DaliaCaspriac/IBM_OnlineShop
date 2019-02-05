package com.ibm.internship.onlineshop.facade.convertor;

import com.ibm.internship.onlineshop.facade.dtos.CategoryDTO;
import com.ibm.internship.onlineshop.model.Category;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CategoryConvertor implements Convertor<Category, CategoryDTO> {

    /**
     * Convert Category to CategoryDTO
     *
     * @param item
     * @return
     */
    @Override
    public CategoryDTO convert(Category item) {
        return new ModelMapper().map(item, CategoryDTO.class);
    }
}
