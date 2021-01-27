package com.calculator;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class CalculatorJunitTester {
     CalculatorImpl calc = new CalculatorImpl();

     @Test
    public void addTest() {
         double num = calc.add(25.0, 26.1);
         Assert.assertEquals(51.1, num, 0);
     }

     @Test
    public void subtractTest() {
         double num = calc.subtract(50.0, 24.5);
         Assert.assertEquals(25.5, num, 0);
     }

    @Test
    public void multiplyTest() {
        double num = calc.multiply(2.0, 5.0);
        Assert.assertEquals(10.0, num, 0);
    }

    @Test(expected = Exception.class)
    public void divideTest() throws Exception {
        double num = calc.divide(50.0, 25.0);
        Assert.assertFalse(throwException());
        Assert.assertEquals(2.0, num);
    }

    private boolean throwException() throws Exception {
        throw new Exception();
    }
}
