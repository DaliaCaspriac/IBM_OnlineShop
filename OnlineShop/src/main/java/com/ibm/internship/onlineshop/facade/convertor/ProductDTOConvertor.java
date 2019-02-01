package com.ibm.internship.onlineshop.facade.convertor;

import com.ibm.internship.onlineshop.facade.dtos.ProductDTO;
import com.ibm.internship.onlineshop.model.Product;
import org.modelmapper.ModelMapper;

public class ProductDTOConvertor implements Convertor<ProductDTO, Product> {
    @Override
    public Product convert(ProductDTO item) {
        return new ModelMapper().map(item, Product.class);
    }
}
