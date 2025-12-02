package com.alvinskylers.practice.service;

import com.alvinskylers.practice.config.Database;
import com.alvinskylers.practice.entity.Employee;
import org.junit.jupiter.api.*;

public class EmployeeDataTest {

    EmployeeData employeeData = new EmployeeData();

    @BeforeEach
    public void initializeDatabase() {
        Database.createTableEmployee();
    }

    @Test
    @DisplayName("")
    public void getEmployeeFromDatabase() {
        Employee employee1 = new Employee("Alvin", "alvin@mail.com", 5, 1000.000);
        employeeData.addEmployee(employee1);
        Employee employeeResult =  employeeData.getEmployee(1);
    }

    @Test
    @DisplayName("")
    public void addEmployeeToDatabase() {
        Employee employee = new Employee("Alvin", "alvin@mail.com", 5, 1000.000);
        employeeData.addEmployee(employee);
        Employee employeeResult =  employeeData.getEmployee(1);
    }

    @Test
    @DisplayName("")
    public void updateEmployeeToDatabase() {
        Employee employee1 = new Employee("Alvin", "alvin@mail.com", 5, 1000.000);
        Employee employee2 = new Employee("Alvin", "alvin@mail.com", 5, 1000.000);
        employeeData.addEmployee(employee1);
        employeeData.updateEmployee(1, "Aulia", "aulia@mail.com", 2, 900.000);
        Employee employeeResult =  employeeData.getEmployee(1);
        Assertions.assertNotEquals(employee2, employeeResult);
    }

    @Test
    @DisplayName("")
    public void deleteEmployeeToDatabase() {
        Employee employee1 = new Employee("Alvin", "alvin@mail.com", 5, 1000.000);
        employeeData.addEmployee(employee1);
        employeeData.deleteEmployee(1);
        Employee employeeResult =  employeeData.getEmployee(1);
        Assertions.assertNotEquals(employee1, employeeResult);
    }


    @AfterEach
    public void finalizeDatabase() {
        Database.dropTableEmployee();
    }

}
