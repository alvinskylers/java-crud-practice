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

    public static int getCodeByDept(String dept) {
        switch (dept.toUpperCase()) {
            case "SALES" : return 0;
            case "MARKETING": return 1;
            case "FINANCE": return 2;
            case "OPERATIONS": return 3;
            case "HUMAN_RESOURCE": return 4;
            case "INFORMATION_TECHNOLOGY": return 5;
            default: return -1;
        }
    }

}
