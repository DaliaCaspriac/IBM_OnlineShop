package com.ibm.internship.onlineshop.facade.convertor;

import com.ibm.internship.onlineshop.facade.ProductReviewsFacade;
import com.ibm.internship.onlineshop.facade.dtos.ProductDTO;
import com.ibm.internship.onlineshop.facade.dtos.ProductReviewDTO;
import com.ibm.internship.onlineshop.model.Product;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductConvertor implements Convertor<Product, ProductDTO> {

    @Autowired
    ProductReviewsFacade facade;

    /**
     * Convert Product to ProductDTO
     *
     * @param item
     * @return
     */
    @Override
    public ProductDTO convert(Product item){
        ProductDTO productDTO = new ModelMapper().map(item, ProductDTO.class);
        try {
            final List<ProductReviewDTO> productReviews = facade.getProductReviewsByProductCode(item.getProductCode());
            productDTO.setProductReviews(productReviews);
            productDTO.setRating(productReviews.stream()
                    .mapToInt(ProductReviewDTO::getStarts)
                    .average().getAsDouble());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return  productDTO;
    }


}
