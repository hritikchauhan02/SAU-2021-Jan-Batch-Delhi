package com.au2021.Exception;

import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import javax.servlet.http.HttpServletRequest;

public class ExceptionResolver extends SimpleMappingExceptionResolver {

    @Override
    public String buildLogMessage(Exception exception, HttpServletRequest request) {
        // System.out.println(exception.getMessage());
        return "Exception occurred : " + exception.getMessage();
    }
}