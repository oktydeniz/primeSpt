package com.facility.primeSport.enums;

public enum WorkoutLevel {

    BEGINNER(101),
    INTERMEDIATE(102),
    ADVANCED(103),
    SPECIFIC(104);

    private final int value;
    WorkoutLevel(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }
}
