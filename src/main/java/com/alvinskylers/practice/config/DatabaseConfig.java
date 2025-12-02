package com.alvinskylers.practice.config;

import java.io.InputStream;
import java.util.Properties;

public class DatabaseConfig {
    private static final Properties properties = new Properties();

    static{
        try (InputStream config = DatabaseConfig.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (config == null) {
                System.out.println("config.properties file not found...");
                System.exit(1);
            }
            properties.load(config);

        } catch (Exception e) {
             e.printStackTrace();
        }

    }

    static String getDatabaseURL () {
        return properties.getProperty("config.url");
    }

    static String getUsername() {
        return properties.getProperty("config.username");
    }

    static String getPassword() {
        return properties.getProperty("config.password");
    }

}
