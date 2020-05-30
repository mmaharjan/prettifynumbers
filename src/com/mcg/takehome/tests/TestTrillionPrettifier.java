package com.mcg.takehome.tests;

import com.mcg.takehome.prettifier.TrillionPrettifier;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.Assert.assertEquals;

public class TestTrillionPrettifier {
    private BigDecimal million;

    @Before
    public void setUp() {
        million = new BigDecimal("1000000");
    }

    @Test
    public void numbers_are_properly_prettified_in_trillions_range() {
        TrillionPrettifier trillionPrettifier = new TrillionPrettifier();

        BigDecimal trillion1 = new BigDecimal("1000000000000.256");
        assertEquals("1T", trillionPrettifier.prettify(trillion1.divide(million, 1, RoundingMode.HALF_UP)));

        BigDecimal trillion2 = new BigDecimal("21721989898945.256");
        assertEquals("21.7T", trillionPrettifier.prettify(trillion2.divide(million, 1, RoundingMode.HALF_UP)));

        // test to ensure that numbers are properly rounded up
        BigDecimal trillion3 = new BigDecimal("9487634567534");
        assertEquals("9.5T", trillionPrettifier.prettify(trillion3.divide(million, 1, RoundingMode.HALF_UP)));

        BigDecimal trillion4 = new BigDecimal("921721989898945");
        assertEquals("921.7T", trillionPrettifier.prettify(trillion4.divide(million, 1, RoundingMode.HALF_UP)));

        // after certain threshold, the trillions go up in thousands
        BigDecimal trillion5 = new BigDecimal("99921721989898945");
        assertEquals("99921.7T", trillionPrettifier.prettify(trillion5.divide(million, 1, RoundingMode.HALF_UP)));
    }
}
