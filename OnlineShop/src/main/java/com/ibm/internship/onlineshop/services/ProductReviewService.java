package com.ibm.internship.onlineshop.services;

import com.ibm.internship.onlineshop.model.ProductReview;
import com.ibm.internship.onlineshop.persistance.ProductReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductReviewService {

    @Autowired
    private ProductReviewRepository productReviewRepository;

    public List<ProductReview> getProductReviewsByProductCode(int productCode) throws ClassNotFoundException, IllegalAccessException {
        return productReviewRepository.getProductReviewsByProductCode(productCode);
    }
}
