package com.mcg.takehome.tests;

import com.mcg.takehome.prettifier.BillionPrettifier;
import com.mcg.takehome.prettifier.MillionPrettifier;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.Assert.assertEquals;

public class TestBillionPrettifier {
    private BigDecimal million;

    @Before
    public void setUp() {
        million = new BigDecimal("1000000");
    }

    @Test
    public void numbers_are_properly_prettified_in_billions_range() {
        BillionPrettifier billionPrettifier = new BillionPrettifier();

        BigDecimal billion1 = new BigDecimal("5333456798");
        assertEquals("5.3B", billionPrettifier.prettify(billion1.divide(million, 1, RoundingMode.HALF_UP)));

        BigDecimal billion2 = new BigDecimal("50000000000");
        assertEquals("50B", billionPrettifier.prettify(billion2.divide(million, 1, RoundingMode.HALF_UP)));

        // test to ensure that numbers are properly rounded up
        BigDecimal billion3 = new BigDecimal("548480000000");
        assertEquals("548.5B", billionPrettifier.prettify(billion3.divide(million, 1, RoundingMode.HALF_UP)));
    }
}
