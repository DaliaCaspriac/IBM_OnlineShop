package com.ibm.internship.onlineshop.services;

import com.ibm.internship.onlineshop.model.Product;
import com.ibm.internship.onlineshop.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    /**
     * Get all products
     * @return list of products
     */
    public List<Product> getAllProducts() throws IllegalAccessException{
        return productRepository.getAllProducts();
    }
}
