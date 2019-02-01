package com.ibm.internship.onlineshop.services;

import com.ibm.internship.onlineshop.model.Product;
import com.ibm.internship.onlineshop.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    /**
     * Get all products
     * @return list of products
     */
    public List<Product> getAllProducts() throws IllegalAccessException, ClassNotFoundException, SQLException {
        return productRepository.getAllProducts();
    }

    public List<Product> getProductsByCategory(int categoryCode) throws IllegalAccessException, ClassNotFoundException {
        return productRepository.getProductsByCategory(categoryCode);
    }
}
