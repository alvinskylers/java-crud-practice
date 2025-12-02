package com.alvinskylers.practice.config;

import org.junit.jupiter.api.*;

public class DatabaseTest {

    @BeforeAll
    public static void setup() {
        Database.dropTableEmployee();
    }

    @Test
    @DisplayName("employee table uninitialized")
    public void employeeTableIsInitialized() {
        Assertions.assertFalse(Database.employeesTableExists());
    }

    @Test
    @DisplayName("employee table created")
    public void employeeTableCreated() {
        Database.createTableEmployee();
        Assertions.assertTrue(Database.employeesTableExists());
    }

    @Test
    @DisplayName("employee table dropped")
    public void employeeTableDropped() {
        Database.dropTableEmployee();
        Assertions.assertFalse(Database.employeesTableExists());
    }

    @AfterAll
    public static void teardown() {
        Database.dropTableEmployee();
    }

}
