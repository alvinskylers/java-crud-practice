package com.alvinskylers.practice.service;

import com.alvinskylers.practice.config.Database;
import com.alvinskylers.practice.entity.Department;
import com.alvinskylers.practice.entity.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeData {

    public void addEmployee(Employee employee) {
        String query = "INSERT INTO employees(name, email, dept, salary) VALUES(?,?,?,?)";

        try (Connection connection = Database.connect();
                PreparedStatement preparedStatement = connection.prepareStatement(query,  PreparedStatement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getEmail());
            preparedStatement.setString(3, employee.getDept().toString().toLowerCase());
            preparedStatement.setDouble(4, employee.getSalary());
            int insertedRows = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addEmployees(List<Employee> employees) {
        String query = "INSERT INTO employees(name, email, dept, salary) VALUES(?,?,?,?)";

        try (Connection connection = Database.connect();
                PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            for (Employee employee : employees) {
                preparedStatement.setString(1, employee.getName());
                preparedStatement.setString(2, employee.getEmail());
                preparedStatement.setString(3, employee.getDept().toString().toLowerCase());
                preparedStatement.setDouble(4, employee.getSalary());
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Employee getEmployee(int id) {
        String query = "SELECT * FROM employees WHERE id = ?";

        try (Connection connection = Database.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Employee(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("email"),
                    Department.getCodeByDept(resultSet.getString("dept")),
                    resultSet.getDouble("salary")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Employee> getEmployees() {
        List<Employee> employees = new ArrayList<>();
        String query = "SELECT * FROM employees";

        try (Connection connection = Database.connect();
                PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                employees.add( new Employee(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("email"),
                    Department.getCodeByDept(resultSet.getString("dept")),
                    resultSet.getDouble("salary")
                ));
            }
            return employees;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    public void updateEmployee(int id, String name, String email, int dept, double salary) {
        String query = "SELECT  * FROM employees " +
                        "SET name = ?, email = ?, dept = ?, salary = ?" +
                        "WHERE id = ?";

        try (Connection connection = Database.connect();
                PreparedStatement preparedStatement = connection.prepareStatement(query)) {

                preparedStatement.setString(1, name);
                preparedStatement.setString(2, email);
                preparedStatement.setString(3, Department.getDeptByCode(dept).toString().toLowerCase());
                preparedStatement.setDouble(4, salary);
                preparedStatement.setInt(5, id);
                preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteEmployee(int id) {
        String query = "DELETE FROM employees WHERE id = ?";

        try (Connection connection = Database.connect();
                PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
