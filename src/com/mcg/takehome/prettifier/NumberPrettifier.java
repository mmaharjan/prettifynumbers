package com.mcg.takehome.prettifier;

import java.math.BigDecimal;

public interface NumberPrettifier {

    String callNextPrettifier(BigDecimal number);

    String prettify(BigDecimal number);
}
