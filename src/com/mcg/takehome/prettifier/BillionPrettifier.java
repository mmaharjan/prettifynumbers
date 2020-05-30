package com.mcg.takehome.prettifier;

import com.mcg.takehome.constants.PrettifyMarkers;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BillionPrettifier implements NumberPrettifier {
    private static BigDecimal LOWER_UNITS_RANGE = new BigDecimal("1000");
    private static BigDecimal UPPER_UNITS_RANGE = new BigDecimal("9999");
    private static BigDecimal UPPER_TENS_RANGE = new BigDecimal("99999");
    private static BigDecimal UPPER_HUNDREDS_RANGE = new BigDecimal("999999");

    private NumberPrettifier nextPrettifier;

    public BillionPrettifier() {
        this.nextPrettifier = new TrillionPrettifier();
    }

    @Override
    public String callNextPrettifier(BigDecimal number) {
        return this.nextPrettifier.prettify(number);
    }

    @Override
    public String prettify(BigDecimal number) {
        String returnValue = "";

        // if number results in 1000-999999 range, the number is in billions range else upwards in trillions range
        if(number.compareTo(UPPER_HUNDREDS_RANGE) == 1) {
            returnValue = callNextPrettifier(number);
        } else {
            returnValue = prettifyBillion(number);
        }

        return returnValue;
    }

    /**
     * Method to calculate the units, tens and hundreds value of a billion valued number.
     *
     * @param  number A number already divided by 1000000.
     * @return String Properly addressed number with billion marker.
     */
    private String prettifyBillion(BigDecimal number) {

        // the value is in billion units if number is in 1000 - 9999 range
        if(number.compareTo(UPPER_UNITS_RANGE) == -1) {
            number = number.divide(LOWER_UNITS_RANGE, 1, RoundingMode.HALF_UP);
        }
        // the value is in tens of billions if number is in 10000 - 99999 range
        else if (number.compareTo(UPPER_TENS_RANGE) == -1) {
           number = number.divide(LOWER_UNITS_RANGE, 1, BigDecimal.ROUND_HALF_UP);
        }
        // the value is in hundreds of billions if number is in 100000 - 1000000 range
        else {
            number = number.divide(LOWER_UNITS_RANGE, 1, BigDecimal.ROUND_HALF_UP);
        }

        return number.stripTrailingZeros().toPlainString() + PrettifyMarkers.BILLION.getMarker();
    }
}
