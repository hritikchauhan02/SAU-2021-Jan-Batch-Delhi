package com.calculator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Logging {

    private static final Logger logger = LogManager.getLogger(Logging.class);

    private static CalculatorImpl calc = new CalculatorImpl();

    private static void basicLoggerMethods(){
        System.out.println("\nLogger Methods: ");
        logger.debug("Debug Message Logged !!!");
        logger.info("Info Message Logged !!!");
        logger.warn("Warning Message Logged !!!");
        logger.fatal("Fatal Message Logged !!!");
        logger.error("Error Message Logged !!!", new NullPointerException("NullError"));
    }

    private static void calculate(double num1, double num2) {

        logger.info("Addition of " + num1 + " and " + num2 + " is:" + calc.add(num1,num2));
        logger.info("Subtraction of " + num1 + " and " + num2 + " is: " + calc.subtract(num1,num2));
        logger.info("Multiplication of " + num1 + " and " + num2 + " is: " + calc.multiply(num1,num2));

        try {
            logger.info("Division of " + num1 + " and " + num2 + " is: " + calc.divide(num1,num2));
        } catch (Exception e) {
            logger.error(e);
        }
    }

    public static void main(String [] args) {

        basicLoggerMethods();

        calculate(10.0,2.5);
        calculate(10.0,0);
    }
}
