package com.iqmsoft.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;

@Controller
@RequestMapping(path = "/")
public class HomeController {

   
    private static final Logger logger = LogManager.getLogger(HomeController.class);

    @GetMapping(path = { "/", "/{test}" })
    public String pageInitial(@PathVariable Optional<String> test, HttpServletRequest request, Model modelo) {
       
        logger.info("Solicitud GET: {}", request.getRequestURI());

       
        if (test.isPresent()) {
            
            modelo.addAttribute("test", test.get());

         
            return "home2";
        }

        return "home";
    }

}
