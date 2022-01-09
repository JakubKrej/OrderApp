package com.company.dbConn;

import java.sql.*;

public class CreateTable {

    public static void CreateNewUserTable(){

        DBconn dbconn = new DBconn();

        String sql1 = "CREATE TABLE IF NOT EXISTS user (\n"
                + " userid integer PRIMARY KEY,\n"
                + " name text NOT NULL,\n"
                + " phoneNumber integer,\n"
                + " adressEmail text,\n"
                + " adress text\n"
                + ");";

        try{
            Connection conn = dbconn.connect();
            Statement stmt = conn.createStatement();
            stmt.execute(sql1);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


    }


    public static void CreateNewPizzaTable(){

        DBconn dbconn = new DBconn();

        String sql1 = "CREATE TABLE IF NOT EXISTS pizza (\n"
                + " pizzaid integer PRIMARY KEY,\n"
                + " pName text NOT NULL,\n"
                + " price integer,\n"
                + " pIngredients text\n"
                + ");";

        try{
            Connection conn = dbconn.connect();
            Statement stmt = conn.createStatement();
            stmt.execute(sql1);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


    }

    public static void CreateNewOrderTable(){

        DBconn dbconn = new DBconn();

        String sql1 = "CREATE TABLE IF NOT EXISTS orders (\n"
                + " orderid integer PRIMARY KEY,\n"
                + " pizzaid integer NOT NULL,\n"
                + " userid integer NOT NULL,\n"
                + " psize integer,\n"
                + " additionalsIngredients text,\n"
                + " subtractsIngredients text\n"
                + ");";

        try{
            Connection conn = dbconn.connect();
            Statement stmt = conn.createStatement();
            stmt.execute(sql1);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


    }

}
