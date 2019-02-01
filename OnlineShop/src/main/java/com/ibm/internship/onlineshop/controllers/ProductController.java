package com.ibm.internship.onlineshop.controllers;

import com.ibm.internship.onlineshop.facade.ProductFacade;
import com.ibm.internship.onlineshop.facade.dtos.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductFacade productFacade;

    @RequestMapping(path = "/products", method = RequestMethod.GET)
    public String getAllProducts(ModelMap modelMap) throws IllegalAccessException {
        List<ProductDTO> products = null;
        products = productFacade.getAllProducts();
        System.out.println("SIZE " + products.size());
        modelMap.addAttribute("products", products);
        return "allProductsView";
    }
}
