package com.ibm.internship.onlineshop.facade;

import com.ibm.internship.onlineshop.facade.convertor.ProductReviewConvertor;
import com.ibm.internship.onlineshop.facade.dtos.ProductReviewDTO;
import com.ibm.internship.onlineshop.services.ProductReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductReviewsFacade {
     @Autowired
    private ProductReviewService productReviewService;

     @Autowired
     private ProductReviewConvertor convertor;

     public List<ProductReviewDTO> getProductReviewsByProductCode(int produceCode) throws IllegalAccessException, ClassNotFoundException {
         return productReviewService.getProductReviewsByProductCode(produceCode).stream()
                 .map(r -> convertor.convert(r))
                 .collect(Collectors.toList());
     }
}
