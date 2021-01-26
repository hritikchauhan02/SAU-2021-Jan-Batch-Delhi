package com.au2021.Exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class LargeNumberException extends Exception{

    public LargeNumberException(){
        super("Result is greater than 1000");
    }

    @ExceptionHandler(value = LargeNumberException.class)
    public String handleLargeNumber() {
        return "large_number_error";
    }
}
