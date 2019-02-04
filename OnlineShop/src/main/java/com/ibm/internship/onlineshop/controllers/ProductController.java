package com.ibm.internship.onlineshop.controllers;

import com.ibm.internship.onlineshop.facade.ProductFacade;
import com.ibm.internship.onlineshop.facade.dtos.ProductDTO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(path = "")
public class ProductController {

    @Autowired
    private ProductFacade productFacade;

    private Logger logger = Logger.getLogger(ProductController.class);

    @RequestMapping(path = "/products", method = RequestMethod.GET)
    public String getAllProducts(ModelMap modelMap) throws IllegalAccessException, ClassNotFoundException {
        List<ProductDTO> products = productFacade.getAllProducts();
        logger.debug("Receive " + products.size() + " products.");
        modelMap.addAttribute("products", products);
        logger.debug("Added list of products to the model");
        return "showProductTable";
    }

    @RequestMapping(path = "/category/{categoryCode}", method=RequestMethod.GET)
    public String getProductsByCategory(ModelMap modelMap, @PathVariable("categoryCode") int categoryCode) throws IllegalAccessException, ClassNotFoundException {
        logger.debug("categoryCode = " + categoryCode);

        List<ProductDTO> products = productFacade.getProductsByCategory(categoryCode);
        modelMap.addAttribute("products", products);
        return "showProductTable";
    }

    @RequestMapping(path="/product/{productCode}", method = RequestMethod.GET)
    public String getProductByCode(ModelMap modelMap, @PathVariable("productCode") int productCode) throws ClassNotFoundException, IllegalAccessException {
        logger.debug("Get product with code " + productCode);
        ProductDTO product = productFacade.getProductByCode( productCode);
        modelMap.addAttribute("product",product);
        return "showProductDetails";
    }
}
