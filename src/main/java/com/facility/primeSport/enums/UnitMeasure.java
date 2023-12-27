package com.facility.primeSport.enums;

public enum UnitMeasure {
    ABD_STANDARD(0),
    METRIC(1);
    private final int value;
    UnitMeasure(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }
}
