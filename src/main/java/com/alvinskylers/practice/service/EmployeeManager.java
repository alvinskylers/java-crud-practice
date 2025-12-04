package com.alvinskylers.practice.service;

import com.alvinskylers.practice.entity.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeManager {

    private List<Employee> employees;
    private final EmployeeData employeeData;

    public EmployeeManager() {
        employees = new ArrayList<>();
        employeeData = new EmployeeData();
    }

    public void updateList() {
        this.employees = employeeData.getEmployees();
    }

    public void addEmployee(Employee employee) {
        employeeData.addEmployee(employee);
        updateList();
    }

    public void addEmployees(List<Employee> employees) {
        employeeData.addEmployees(employees);
        updateList();
    }

    public void deleteEmployee(int id) {
        employeeData.deleteEmployee(id);
        updateList();
    }

    public void updateEmployee(int id, String name, String email, int dept, double salary) {
        employeeData.updateEmployee(id, name, email, dept, salary);
        updateList();
    }

    public Employee getEmployee(int id) {
        return employees.stream()
                .filter(employee -> employee.getId() == id)
                .findFirst().orElse(null);
    }

    public List<Employee> getEmployees() {
        updateList();
        return employees;
    }

    public int getTotalEmployees() {
        updateList();
        return employeeData.getEmployees().size();
    }


}
