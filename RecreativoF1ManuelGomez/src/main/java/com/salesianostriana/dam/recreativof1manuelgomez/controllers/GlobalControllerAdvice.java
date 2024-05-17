package com.salesianostriana.dam.recreativof1manuelgomez.controllers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.salesianostriana.dam.recreativof1manuelgomez.exception.ProductoNoEncontradoException;

@ControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler(ProductoNoEncontradoException.class)
    public ModelAndView handleProductoNotFoundException(ProductoNoEncontradoException ex) {
        ModelAndView modelView = new ModelAndView();
        modelView.addObject("message", ex.getMessage());
        modelView.setViewName("emptyList");
        return modelView;
    }
    
    
}
