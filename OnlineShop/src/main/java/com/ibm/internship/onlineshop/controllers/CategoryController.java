package com.ibm.internship.onlineshop.controllers;

import com.ibm.internship.onlineshop.facade.CategoryFacade;
import com.ibm.internship.onlineshop.facade.dtos.CategoryDTO;
import com.ibm.internship.onlineshop.services.CategoryService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(path = "")
public class CategoryController {

    private static Logger logger = Logger.getLogger(CategoryFacade.class);

    @Autowired
    private CategoryFacade categoryFacade;

    @RequestMapping(path = "/categories", method = RequestMethod.GET)
    public String getAllCategories(ModelMap modelMap) throws ClassNotFoundException, IllegalAccessException {
        List<CategoryDTO> categories = categoryFacade.getAllCategories();
        logger.debug("Get all categories and load ModelMap");
        modelMap.addAttribute("categories",categories);
        logger.debug("Display category list");
        return "showCategoryTable";
    }
}
