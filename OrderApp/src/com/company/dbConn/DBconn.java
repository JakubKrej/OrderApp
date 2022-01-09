package com.company.dbConn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconn {

    public Connection connect() {

        String url = "jdbc:sqlite:C:/Users/Kuba/IdeaProjects/OrderApp/PizzaOrd.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
}
