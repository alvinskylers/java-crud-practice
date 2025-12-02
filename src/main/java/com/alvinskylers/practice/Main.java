package com.alvinskylers.practice;

import com.alvinskylers.practice.config.Database;
import com.alvinskylers.practice.entity.Department;

public class Main {
    public static void main(String[] args) {
        Department dept = Department.getDeptByCode(4);
       System.out.println(dept);
    }
}