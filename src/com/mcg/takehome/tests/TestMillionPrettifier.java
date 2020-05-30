package com.mcg.takehome.tests;

import com.mcg.takehome.prettifier.MillionPrettifier;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;


public class TestMillionPrettifier {

    @Test
    public void testSetup() {
    }

    @Test
    public void numbers_not_prettified_if_less_than_1000000() {
        MillionPrettifier millionPrettifier = new MillionPrettifier();

        assertEquals("-100", millionPrettifier.prettify(new BigDecimal("-100")));
        assertEquals("1000", millionPrettifier.prettify(new BigDecimal("1000")));
        assertEquals("10000.98", millionPrettifier.prettify(new BigDecimal("10000.98")));
        assertEquals("100000", millionPrettifier.prettify(new BigDecimal("100000")));
        assertEquals("0.001", millionPrettifier.prettify(new BigDecimal("0.001")));
    }

    @Test
    public void numbers_are_properly_prettified_in_millions_range() {
        MillionPrettifier millionPrettifier = new MillionPrettifier();

        assertEquals("1M", millionPrettifier.prettify(new BigDecimal("1000000")));
        assertEquals("12.3M", millionPrettifier.prettify(new BigDecimal("12345678.001")));

        // test to ensure that numbers are properly rounded up
        assertEquals("12.5M", millionPrettifier.prettify(new BigDecimal("12485678.001")));

        assertEquals("512.3M", millionPrettifier.prettify(new BigDecimal("512345678.001")));
    }

    @Test
    public void numbers_in_billions_and_trillions_are_properly_prettified() {
        MillionPrettifier millionPrettifier = new MillionPrettifier();

        assertEquals("1T", millionPrettifier.prettify(new BigDecimal("1000000000000.256")));
        assertEquals("548.5B", millionPrettifier.prettify(new BigDecimal("548480000000")));
    }
}
