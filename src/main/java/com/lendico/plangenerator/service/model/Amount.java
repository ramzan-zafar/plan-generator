package com.lendico.plangenerator.service.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public final class Amount {


    private final BigDecimal value;

    public Amount(BigDecimal value) {
        this.value = value;
    }

    public Amount(double value) {
        this(BigDecimal.valueOf(value));
    }

    public Amount() {
        this(BigDecimal.ZERO);
    }

    public Double doubleValueWithRounding() {
        return value.setScale(2, RoundingMode.HALF_EVEN).doubleValue();
    }
}