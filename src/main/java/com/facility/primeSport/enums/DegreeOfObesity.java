package com.facility.primeSport.enums;

public enum DegreeOfObesity {
    UNDERWEIGHT(0),
    NORMAL_WEIGHT(1),
    OVERWEIGHT(2),
    OBESITY_CLASS_1(3),
    OBESITY_CLASS_2(4),
    OBESITY_CLASS_3(5);
    private final int value;

    DegreeOfObesity(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

/*
Underweight
Normal weight
Overweight
Obesity: Class I
Obesity: Class II
Obesity: Class III
*/