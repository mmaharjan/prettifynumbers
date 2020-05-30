package com.mcg.takehome;

import com.mcg.takehome.prettifier.MillionPrettifier;
import com.mcg.takehome.prettifier.NumberPrettifier;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<BigDecimal> numbers = new ArrayList();
        numbers.add(new BigDecimal("353"));
        numbers.add(new BigDecimal("145454"));
        numbers.add(new BigDecimal("3456798"));
        numbers.add(new BigDecimal("1000000"));
        numbers.add(new BigDecimal("2500000.34"));
        numbers.add(new BigDecimal("913456798"));
        numbers.add(new BigDecimal("13000000"));

        // billionth numbers
        numbers.add(new BigDecimal("5333456798"));
        numbers.add(new BigDecimal("50000000000"));
        numbers.add(new BigDecimal("548480000000"));

        // trillionth nunbers
        numbers.add(new BigDecimal("1000000000000.256"));
        numbers.add(new BigDecimal("9487634567534"));
        numbers.add(new BigDecimal("21721989898945.256"));
        numbers.add(new BigDecimal("921721989898945"));

        for(BigDecimal number : numbers) {
            NumberPrettifier numberPrettifier = new MillionPrettifier();
            System.out.println("number: " + numberPrettifier.prettify(number));
        }

    }
}
