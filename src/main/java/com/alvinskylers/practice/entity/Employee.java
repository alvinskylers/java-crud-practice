package com.alvinskylers.practice.entity;

import java.util.Objects;

public class Employee implements Comparable<Employee> {
    private int id;
    private String name;
    private String email;
    private Department dept;
    private double salary;


    public Employee(String name, String email, int deptID, double salary) {
        this.name = name;
        this.email = email;
        this.dept = Department.getDeptByCode(deptID);
        this.salary = salary;
    }

    public Employee(int id, String name, String email, int deptID, double salary) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dept = Department.getDeptByCode(deptID);
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Department getDept() {
        return dept;
    }

    public void setDept(Department dept) {
        this.dept = dept;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", dept=" + dept +
                ", salary=" + salary +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id &&
                Double.compare(salary, employee.salary) == 0 &&
                Objects.equals(name, employee.name) &&
                Objects.equals(email, employee.email) &&
                dept == employee.dept;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, dept, salary);
    }

    @Override
    public int compareTo(Employee o) {
        return this.name.compareTo(o.name);
    }
}
