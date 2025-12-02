package com.alvinskylers.practice.config;

import java.sql.*;

public class Database {

    public static Connection connect() {
        try {
            String url = DatabaseConfig.getDatabaseURL();
            String username = DatabaseConfig.getUsername();
            String password = DatabaseConfig.getPassword();
            return DriverManager.getConnection(url, username, password);

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void createTableEmployee() {
        String query = "CREATE TABLE employees (" +
                        "   id SERIAL PRIMARY KEY, " +
                        "   name VARCHAR(100) NOT NULL," +
                        "   department VARCHAR(50) NOT NULL," +
                        "   salary DECIMAL NOT NULL " +
                        ");";

        try (Connection connection = Database.connect()) {
             Statement statement = connection.createStatement();
             statement.execute(query);
             System.out.println("table \"employees\" has been initialized!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean employeesTableExists() {
        try (Connection connection = connect();
             PreparedStatement pstmt = connection.prepareStatement("SELECT to_regclass(?)")) {
            pstmt.setString(1, "employees");
            try (ResultSet rs = pstmt.executeQuery()) {
                return rs.next() && rs.getString(1) != null;
            }
        } catch (SQLException e) {
            return false;
        }
    }

    public static void dropTableEmployee() {
        String query = "DROP TABLE employees";

        try (Connection connection = Database.connect();
             Statement statement = connect().createStatement()) {
            statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
