package com.ibm.internship.onlineshop.controllers;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path = "")
public class HelloController {
    private static final Logger logger = Logger.getLogger(HelloController.class);

    @RequestMapping(path = "/hello",method = RequestMethod.GET)
    public String printHello(ModelMap modelMap){
        modelMap.addAttribute("message","ABC");
        logger.debug("OK");
        return "hello";
    }
}
