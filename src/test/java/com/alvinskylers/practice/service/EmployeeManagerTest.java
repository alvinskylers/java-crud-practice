package com.alvinskylers.practice.service;

import com.alvinskylers.practice.config.Database;
import com.alvinskylers.practice.entity.Employee;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

public class EmployeeManagerTest {

    private EmployeeManager employeeManager;

    public Employee generateEmployee() {
        return new Employee(1,"johndoe", "johndoe@mail.com",2,100.00);
    }

    @BeforeEach
    public void setUp() {
        employeeManager = new EmployeeManager();
    }

    @BeforeEach
    public void startUp(){
        Database.createTableEmployee();
    }

    @Test
    @DisplayName("add employee to database")
    public void addEmployeeTest() {
        employeeManager.addEmployee(generateEmployee());
    }

    @Test
    @DisplayName("")
    public void addEmployeeBulk(){
        List<Employee> employees = new ArrayList<>();
        employees.add(generateEmployee());
        employees.add(generateEmployee());
        employees.add(generateEmployee());
        employeeManager.addEmployees(employees);
        Assertions.assertEquals(employees.size(), employeeManager.getTotalEmployees());
    }
    
    @Test
    @DisplayName("check employee added to database")
    public void employeeAddedTest() {
        employeeManager.addEmployee(generateEmployee());
        System.out.println(employeeManager.getTotalEmployees());
        Assertions.assertEquals(1, employeeManager.getTotalEmployees());
    }

    @Test
    @DisplayName("employee data unaltered")
    public void getEmployeeTest() {
        employeeManager.addEmployee(generateEmployee());
        Assertions.assertEquals(generateEmployee(), employeeManager.getEmployee(1));
    }

    @Test
    @DisplayName("retrieve all employees from database")
    public void getAllEmployees() {
        employeeManager.addEmployee(generateEmployee());
        employeeManager.addEmployee(generateEmployee());
        employeeManager.addEmployee(generateEmployee());
        List<Employee> list = employeeManager.getEmployees();
        Assertions.assertEquals(list.size(), employeeManager.getTotalEmployees());
    }

    @Test
    @DisplayName("")
    public void updateEmployee() {
        var person = generateEmployee();
        employeeManager.addEmployee(person);
        employeeManager.updateEmployee(1, "jane doe", "jane@mail.com", 2, 3.00);
        var employee = employeeManager.getEmployee(1);
        System.out.println(person);
        System.out.println(employee);
        Assertions.assertNotEquals(person, employee);
    }

    @Test
    @DisplayName("")
    public void deleteEmployee() {
        employeeManager.addEmployee(generateEmployee());
        employeeManager.deleteEmployee(1);
        Assertions.assertNull(employeeManager.getEmployee(1));
    }

    @AfterEach
    public void tear(){
        Database.dropTableEmployee();
    }

    @AfterAll
    public static void tearDown(){
        Database.dropTableEmployee();
    }

}
