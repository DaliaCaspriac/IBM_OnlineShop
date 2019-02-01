package com.ibm.internship.onlineshop.facade;

import com.ibm.internship.onlineshop.facade.convertor.ProductConvertor;
import com.ibm.internship.onlineshop.facade.dtos.ProductDTO;
import com.ibm.internship.onlineshop.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductFacade {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductConvertor convertor;

    /**
     * Get all products and parse them to ProductDTO
     *
     * @return list of ProductDTO
     * @throws IllegalAccessException
     * @throws ClassNotFoundException
     */
    public List<ProductDTO> getAllProducts() throws IllegalAccessException, ClassNotFoundException {
        return productService.getAllProducts().stream()
                .map(p -> convertor.convert(p))
                .collect(Collectors.toList());
    }

    /**
     * Get products by category and parse them to ProductDTO
     *
     * @param categoryCode
     * @return list of ProductDTO
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     */
    public List<ProductDTO> getProductsByCategory(int categoryCode) throws ClassNotFoundException, IllegalAccessException {
        return productService.getProductsByCategory(categoryCode).stream()
                .map(p -> convertor.convert(p))
                .collect(Collectors.toList());
    }
}