package com.calculator;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static junit.framework.TestCase.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class MockitoTest {
    Calculator calc = Mockito.mock(Calculator.class);
    CalculatorImpl calcImpl = new CalculatorImpl();

    @Test
    public void addTest() {
        Mockito.when(calc.add(12.0,13.5)).thenReturn(25.5);
        double num = calc.add(12.0,13.5);
        Assert.assertEquals(calcImpl.add(12.0,13.5), num, 0);
    }

    @Test
    public void subtractTest() {
        Mockito.when(calc.subtract(13.5,12.5)).thenReturn(1.0);
        double num = calc.subtract(13.5,12.5);
        Assert.assertEquals(calcImpl.subtract(13.5,12.5), num, 0);
    }

    @Test
    public void multiplyTest() {
        Mockito.when(calc.multiply(2.0,5.0)).thenReturn(10.0);
        double num = calc.multiply(2.0,5.0);
        Assert.assertEquals(calcImpl.multiply(2.0,5.0), num, 0);
    }

    @Test
    public void divideTest(){
        try {
            Mockito.when(calc.divide(10.0,2.0)).thenReturn(5.0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        double num = 0;
        try {
            num = calc.divide(10.0,2.0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Assert.assertEquals(calcImpl.divide(10.0,2.0), num, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
