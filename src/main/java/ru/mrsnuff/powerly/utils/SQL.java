package ru.mrsnuff.powerly.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SQL {
    private static Connection getConnection() {
        Connection connection;

        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection("jdbc:h2:file:./Powerly/PowerlyDB");
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void exec(String sql) {
        Connection connection = getConnection();
        Statement stmt;

        try {
            connection.setAutoCommit(false);
            stmt = connection.createStatement();
            stmt.execute(sql);
            stmt.close();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void init() {
        exec("CREATE TABLE IF NOT EXISTS computers (id INTEGER PRIMARY KEY AUTO_INCREMENT, name VARCHAR(255) NOT NULL, ip VARCHAR(255) NOT NULL, user VARCHAR(255) NOT NULL, password VARCHAR(255) NOT NULL)");
    }
}
