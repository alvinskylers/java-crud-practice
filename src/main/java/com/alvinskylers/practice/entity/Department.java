package com.alvinskylers.practice.entity;

public enum Department {
    SALES(0), MARKETING(1), FINANCE(2), OPERATIONS(3), HUMAN_RESOURCE(4), INFORMATION_TECHNOLOGY(5);

    private final int departmentId;

    Department(final int id) {
        departmentId = id;
    }

    public int getValue() {
        return departmentId;
    }

    public static Department getDeptByCode(final int value) {
        switch (value) {
            case 0: return SALES;
            case 1: return MARKETING;
            case 2: return FINANCE;
            case 3: return OPERATIONS;
            case 4: return HUMAN_RESOURCE;
            case 5: return INFORMATION_TECHNOLOGY;
            default: return null;
        }
    }

}
