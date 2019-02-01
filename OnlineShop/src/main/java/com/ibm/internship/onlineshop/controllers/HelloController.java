package com.ibm.internship.onlineshop;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path = "")
public class HelloController {

    @RequestMapping(path = "/hello",method = RequestMethod.GET)
    public String printHello(ModelMap modelMap){
        modelMap.addAttribute("message","ABC");
        return "hello";
    }
}
