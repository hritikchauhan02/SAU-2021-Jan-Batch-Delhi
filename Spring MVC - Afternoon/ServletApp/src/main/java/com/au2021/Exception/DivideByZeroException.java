package com.au2021.Exception;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class DivideByZeroException extends Exception {

    public DivideByZeroException() {
        super("Cannot divide a number by zero");
    }

    @ResponseBody
    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ExceptionHandler(value = DivideByZeroException.class)
    public Map<String, String> handleDivideByZero() {
        Map<String, String> mp = new HashMap<>();
        mp.put("Operation", "Divide");
        mp.put("Symbol", "/");
        mp.put("Message", "Divide By Zero is not allowed");
        return mp;
    }
}