package com.ibm.internship.onlineshop.facade.convertor;

import com.ibm.internship.onlineshop.facade.dtos.ProductDTO;
import com.ibm.internship.onlineshop.model.Product;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ProductConvertor implements Convertor<Product, ProductDTO> {
    @Override
    public ProductDTO convert(Product item) {
        return new ModelMapper().map(item, ProductDTO.class);
    }
}
