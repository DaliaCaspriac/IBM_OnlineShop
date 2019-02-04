package com.ibm.internship.onlineshop.services;

import com.ibm.internship.onlineshop.model.Product;
import com.ibm.internship.onlineshop.persistance.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    /**
     * Get product by code
     * @param productCode
     * @return Product object
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     */
    public Product getProductByCode(int productCode) throws ClassNotFoundException, IllegalAccessException {
        return productRepository.getProductByCode(productCode);
    }
}
