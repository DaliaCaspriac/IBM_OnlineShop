package com.ibm.internship.onlineshop.facade.convertor;

import com.ibm.internship.onlineshop.facade.dtos.ProductReviewDTO;
import com.ibm.internship.onlineshop.model.ProductReview;
import org.modelmapper.ModelMapper;

public class ProductReviewDTOConvertor implements Convertor<ProductReviewDTO, ProductReview> {
    @Override
    public ProductReview convert(ProductReviewDTO item) {
        return new ModelMapper().map(item, ProductReview.class);
    }
}
