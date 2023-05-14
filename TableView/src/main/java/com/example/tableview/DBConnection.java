package com.example.tableview;

import  java.sql.*;

public class DBConnection {


    public static Connection connector() {
        Connection connect = null;
        try {
            System.out.println("B class");
            Class.forName("org.sqlite.JDBC");
            System.out.println("A class");
            String url = "jdbc:sqlite:tableview.db";
            connect = DriverManager.getConnection(url);
            System.out.println("Connected");

        } catch (ClassNotFoundException | SQLException ex) {

            System.err.println("Error class not found"+ex.getClass().getName());

        }
        return connect;
    }


}
