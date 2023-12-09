package com.example.demo.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    protected String jbbcUrl;
    protected String jdbcUserName;
    protected String jdbcPassword;
    public static  Database instance;

    public Database() {
        this.jbbcUrl = "jdbc:mysql://localhost:3306/demoTest?useSSL=false";
        this.jdbcUserName = "root";
        this.jdbcPassword = "123456";
    }
    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    public Connection connection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(jbbcUrl, jdbcUserName, jdbcPassword);
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "Error");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
