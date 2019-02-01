package com.ibm.internship.onlineshop.controllers;

import com.ibm.internship.onlineshop.facade.ProductFacade;
import com.ibm.internship.onlineshop.facade.dtos.ProductDTO;
import com.ibm.internship.onlineshop.model.Product;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping(path = "")
public class ProductController {

    @Autowired
    private ProductFacade productFacade;

    private Logger logger = Logger.getLogger(ProductController.class);

    @RequestMapping(path = "/products", method = RequestMethod.GET)
    public String getAllProducts(ModelMap modelMap) throws IllegalAccessException, ClassNotFoundException, SQLException {
        List<Product> products = null;
        logger.debug("Before productFacade.getAllProducts");
        products = productFacade.getAllProducts();
        logger.debug("Receive " + products.size() + " products.");
        modelMap.addAttribute("products", products);
        logger.debug("Added list of products to the model");
        return "allProductsView";
    }
}
