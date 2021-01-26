package com.au2021.service;

import com.au2021.Exception.DivideByZeroException;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    public int calculate(String num1, String num2, String operation) throws DivideByZeroException {
        int n1 = Integer.parseInt(num1);
        int n2 = Integer.parseInt(num2);
        if (n2 == 0) throw new DivideByZeroException();

        if(operation.equals("Add")) {
            return n1 + n2;
        }
        if(operation.equals("Subtract")) {
            return n1 - n2;
        }
        if(operation.equals("Multiply")) {
            return n1 * n2;
        }
        if(operation.equals("Divide")) {
            return n1 / n2;
        }

        return -1;
    }
}
