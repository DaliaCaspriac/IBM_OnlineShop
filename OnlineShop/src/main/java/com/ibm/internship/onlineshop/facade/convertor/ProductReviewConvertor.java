package com.ibm.internship.onlineshop.facade.convertor;

import com.ibm.internship.onlineshop.facade.dtos.ProductReviewDTO;
import com.ibm.internship.onlineshop.model.ProductReview;
import org.modelmapper.ModelMapper;

public class ProductReviewConvertor implements Convertor<ProductReview, ProductReviewDTO> {
    @Override
    public ProductReviewDTO convert(ProductReview item) {
        return new ModelMapper().map(item, ProductReviewDTO.class);
    }
}
