package ru.mrsnuff.powerly.utils;

import ru.mrsnuff.powerly.controllers.Main;
import ru.mrsnuff.powerly.model.Computer;

import java.sql.*;

public class H2DB {

    public static void addComputer(String name, String ip, String user, String password) {
        exec("INSERT INTO `computers` (`id`, `name`, `ip`, `user`, `password`) VALUES (NULL, '" + name + "', '" + ip + "', '" + user + "', '" + password + "')");
    }

    public static void removeComputer(String name) {
        exec("DELETE FROM `computers` WHERE 'name' = " + name);
    }

    public static void initDB() {
        exec("CREATE TABLE IF NOT EXISTS `computers` (`id` INTEGER PRIMARY KEY AUTO_INCREMENT, `name` VARCHAR(255) NOT NULL, `ip` VARCHAR(255) NOT NULL, `user` VARCHAR(255) NOT NULL, `password` VARCHAR(255) NOT NULL)");
    }

    public static void initTable() {
        Thread thread = new Thread(() -> {
           try (Connection con = DriverManager.getConnection("jdbc:h2:file:./Powerly/DataBase");
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM computers")) {
               while (rs.next()) {
                   Main.getInstance().getComputersData().add(new Computer(rs.getString("name"), rs.getString("ip"), rs.getString("user"), rs.getString("password")));
               }
           } catch (SQLException e) {
               e.printStackTrace();
           }
        });
        thread.start();
    }

    private static void exec(String sql) {
        Thread thread = new Thread(() -> {
            try (Connection con = DriverManager.getConnection("jdbc:h2:file:./Powerly/DataBase");
                 Statement st = con.createStatement()) {
                st.execute(sql);
                st.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
        thread.start();
    }
}
