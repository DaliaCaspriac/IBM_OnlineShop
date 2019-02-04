package com.ibm.internship.onlineshop.facade.convertor;

import com.ibm.internship.onlineshop.facade.dtos.ProductReviewDTO;
import com.ibm.internship.onlineshop.model.ProductReview;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ProductReviewConvertor implements Convertor<ProductReview, ProductReviewDTO> {

    /**
     * Convert ProductReview to ProductReviewDTO
     *
     * @param item
     * @return
     */
    @Override
    public ProductReviewDTO convert(ProductReview item) {
        return new ModelMapper().map(item, ProductReviewDTO.class);
    }
}
