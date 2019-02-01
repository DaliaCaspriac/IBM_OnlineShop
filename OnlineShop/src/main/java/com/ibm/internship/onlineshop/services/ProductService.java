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
     *
     * @return list of Product
     */
    public List<Product> getAllProducts() throws IllegalAccessException, ClassNotFoundException {
        return productRepository.getAllProducts();
    }

    /**
     * Get products by category
     *
     * @param categoryCode
     * @return list of Product
     * @throws IllegalAccessException
     * @throws ClassNotFoundException
     */
    public List<Product> getProductsByCategory(int categoryCode) throws IllegalAccessException, ClassNotFoundException {
        return productRepository.getProductsByCategory(categoryCode);
    }
}
