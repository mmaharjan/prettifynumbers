package com.mcg.takehome.prettifier;

import com.mcg.takehome.constants.PrettifyMarkers;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MillionPrettifier implements NumberPrettifier {
    static BigDecimal MILLION = new BigDecimal("1000000");

    private NumberPrettifier nextPrettifier;

    public MillionPrettifier() {
        nextPrettifier = new BillionPrettifier();
    }

    @Override
    public String callNextPrettifier(BigDecimal number) {
        return this.nextPrettifier.prettify(number);
    }

    @Override
    public String prettify(BigDecimal number) {
        String returnValue = "";
        int value = number.compareTo(MILLION);

        if(value == -1) {
            // No prettifier is necessary if value is less than MILLION, return the number as is
            returnValue = number.toString();
            assert returnValue.equals(number.toString());

        } else {
            BigDecimal num = number.divide(MILLION, 1, RoundingMode.HALF_UP);

            // if num results in 1-999 range, it's a number in millions range, if not possibly billions or trillions
            if(num.compareTo(new BigDecimal("999")) == 1) {
                returnValue = callNextPrettifier(num);
            } else {
                returnValue = num.stripTrailingZeros().toPlainString() + PrettifyMarkers.MILLION.getMarker();
            }
        }

        return returnValue;
    }
}
