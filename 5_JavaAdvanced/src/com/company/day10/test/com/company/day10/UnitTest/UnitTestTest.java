package com.company.day10.UnitTest;

import org.junit.Test;

import static org.junit.Assert.*;

public class UnitTestTest {

    @Test
    public void arithmeticMean() {
    }
    @Test
    public void arithmeticMeanOfFiveAndSevenResultsInSix(){
        UnitTest test = new UnitTest();
        test.add(()->5);
        test.add(()->7);
        int actualresult = test.arithmeticMean();
        assertEquals(6, actualresult);
    }

    @Test
    public void arithmeticMeanOfTenAndTwentyResultsInFifteen(){
        UnitTest test = new UnitTest();
        test.add(()->10);
        test.add(()->20);
        int actualresult = test.arithmeticMean();
        assertEquals(15, actualresult);
    }
}