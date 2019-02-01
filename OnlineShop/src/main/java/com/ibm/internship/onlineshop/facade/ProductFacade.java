package com.ibm.internship.onlineshop.facade;

import com.ibm.internship.onlineshop.facade.convertor.ProductConvertor;
import com.ibm.internship.onlineshop.facade.dtos.ProductDTO;
import com.ibm.internship.onlineshop.model.Product;
import com.ibm.internship.onlineshop.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductFacade {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductConvertor convertor;

    public List<Product> getAllProducts() throws IllegalAccessException, ClassNotFoundException, SQLException {
//        return productService.getAllProducts().stream()
////                .map(p -> convertor.convert(p))
////                .collect(Collectors.toList());
        return productService.getAllProducts();
    }
}