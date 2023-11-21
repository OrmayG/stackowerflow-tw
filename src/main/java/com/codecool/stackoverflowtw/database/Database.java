package com.codecool.stackoverflowtw.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private final String userName;
    private final String password;
    private final String dbName;
    private final String URL;

    public Database() {
        this.userName = System.getenv("USERNAME");
        this.password = System.getenv("PASSWORD");
        this.dbName = "mockoverflow_db";
        this.URL = "jdbc:postgresql://localhost:5432/" + dbName;
    }


    public Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, userName, password);
        } catch (SQLException ex) {
            System.err.println("Could not create database connection.");
            throw new RuntimeException(ex);
        }
    }
}
