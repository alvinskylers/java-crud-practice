package com.alvinskylers.practice.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class EmployeeTest {

    @Test
    @DisplayName("create employee object")
    public void createEmployeeObject() {
        Employee employee = new Employee("Jane Doe", "janedoe@mail.corp", 3, 800.000);
        Assertions.assertNotNull(employee);
    }

    @Test
    @DisplayName("modify employee object")
    public void modifyEmployeeObject() {
        Employee employee = new Employee("Jane Doe", "janedoe@mail.corp", 3, 800.000);
        employee.setName("John Doe");
        Assertions.assertNotEquals("Jane Doe", employee.getName());
    }

    @Test
    @DisplayName("compare employee object less than")
    public void compareEmployeeObjectOne() {
        Employee employee1 = new Employee("Jane Doe", "janedoe@mail.corp", 3, 800.000);
        Employee employee2 = new Employee("John Doe", "janedoe@mail.corp", 3, 800.000);
        int value = employee1.compareTo(employee2);
        Assertions.assertEquals( true, value < 0 );
    }

    @Test
    @DisplayName("compare employee object more than")
    public void compareEmployeeObjectTwo() {
        Employee employee1 = new Employee("Jane Doe", "janedoe@mail.corp", 3, 800.000);
        Employee employee2 = new Employee("John Doe", "janedoe@mail.corp", 3, 800.000);
        int value = employee2.compareTo(employee1);
        Assertions.assertEquals( true, value > 0 );
    }

    @Test
    @DisplayName("compare employee object equal")
    public void compareEmployeeObjectThree() {
        Employee employee1 = new Employee("Jane Doe", "janedoe@mail.corp", 3, 800.000);
        Employee employee2 = new Employee("Jane Doe", "janedoe@mail.corp", 3, 800.000);
        int value = employee2.compareTo(employee1);
        Assertions.assertEquals( true, value == 0 );
    }
}
