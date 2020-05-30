package com.mcg.takehome.prettifier;

import com.mcg.takehome.constants.PrettifyMarkers;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TrillionPrettifier implements NumberPrettifier {
    private static BigDecimal LOWER_UNIT_TRILLIONS = new BigDecimal("1000000");

    public TrillionPrettifier() {
    }

    @Override
    public String callNextPrettifier(BigDecimal number) {
        // Number prettifier ends at Trillion
        return null;
    }

    @Override
    public String prettify(BigDecimal number) {
        // if number results above 1000000 range, the number is in trillions range
        BigDecimal value = number.divide(LOWER_UNIT_TRILLIONS, 1, RoundingMode.HALF_UP);

        return value.stripTrailingZeros().toPlainString() + PrettifyMarkers.TRILLION.getMarker();
    }
}
