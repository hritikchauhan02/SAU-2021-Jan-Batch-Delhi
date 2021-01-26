package com.au2021.controller;

import com.au2021.Exception.DivideByZeroException;
import com.au2021.Exception.LargeNumberException;
import com.au2021.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @Autowired
    CalculatorService service;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String loadCalc() {
        return "calculator";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String calculator(@RequestParam String num1, @RequestParam String num2, @RequestParam String operation, ModelMap modelMap) throws LargeNumberException, DivideByZeroException {
        if(Integer.parseInt(num2) == 0 && operation.equals("Divide")) {
            throw new DivideByZeroException();
        }
        int res = service.calculate(num1, num2, operation);
        if (res > 1000) throw new LargeNumberException();
        modelMap.put("result", res);
        return "result";
    }
}
