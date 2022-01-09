package com.company.service;

import com.company.dbConn.DBconn;
import com.company.model.ingredients;

import java.sql.*;
import java.util.List;

public class PizzaServiceImpl {

    private DBconn dbconn = new DBconn();

    public void addPizza(int pizzaid, String pName, int price, List<ingredients> pIngredients) {
        String sql = "INSERT INTO pizza(pizzaid,pName,price,pIngredients) VALUES(?,?,?,?)";

        try (Connection conn = dbconn.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, pizzaid);
            pstmt.setString(2, pName);
            pstmt.setInt(3, price);
            pstmt.setString(4, String.valueOf(pIngredients));
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public String selectName(int num){
        String sql = "SELECT pName FROM pizza WHERE pizzaid =" + "'" + num + "'";
        String result = null;

        try (Connection conn = dbconn.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                result = rs.getString("pName");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return result;
    }

    public int selectPrice(int num){
        String sql = "SELECT price FROM pizza WHERE pizzaid =" + "'" + num + "'";
        int result = 0;

        try (Connection conn = dbconn.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {

                result = rs.getInt("price");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return result;
    }

    public String selectIngredients(int num){
        String sql = "SELECT pIngredients FROM pizza WHERE pizzaid =" + "'" + num + "'";
        String result = null;

        try (Connection conn = dbconn.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                result = rs.getString("pIngredients");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return result;
    }

    public void selectAll() {
        String sql = "SELECT * FROM pizza";

        try (Connection conn = dbconn.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println(rs.getInt("pizzaid") +  "\t" +
                        rs.getString("pName") + "\t" +
                        rs.getInt("price") + "\t" +
                        rs.getString("pIngredients"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public int lastpizzaID(){

//        String sql = "SELECT pizzaid FROM pizza";
        String maxpizzaid = "SELECT pizzaid FROM pizza WHERE pizzaid = (SELECT MAX(pizzaid) FROM pizza)";
        int lastid = 0;

        try (Connection conn = dbconn.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(maxpizzaid)) {

            while (rs.next()) {
                lastid = rs.getInt("pizzaid");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        lastid++;

        return lastid;
    }
}
