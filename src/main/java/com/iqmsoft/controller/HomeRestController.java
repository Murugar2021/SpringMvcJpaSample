package com.iqmsoft.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iqmsoft.model.RequestModel;

@RestController
@RequestMapping(path = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class HomeRestController {

   
    private static final Logger logger = LogManager.getLogger(HomeRestController.class);

    @GetMapping
    public ResponseEntity<RequestModel> method1(HttpServletRequest request) {
       
        logger.info("[API] Request GET: {}", request.getRequestURI());

        
        RequestModel respuesta = new RequestModel(HttpStatus.OK, "method1", "Greetings!");

       
        return ResponseEntity.status(HttpStatus.OK).body(respuesta);
    }

    @GetMapping(path = "/{test}")
    public ResponseEntity<RequestModel> testpersonal(@PathVariable String test, 
    		HttpServletRequest request) {
      
        logger.info("[API] Solicitud GET: {}", request.getRequestURI());

      
        RequestModel respuesta = new RequestModel(HttpStatus.OK, "testpersonal",
                "Hello, " + test + "!");

      
        return ResponseEntity.status(HttpStatus.OK).body(respuesta);
    }

}
