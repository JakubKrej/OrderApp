package com.company.service;

import com.company.dbConn.DBconn;
import com.company.model.Order;

import java.sql.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class OrderServiceImpl {

    private DBconn dbconn = new DBconn();

    public void NewOrder(Order order){

        String sql = "INSERT INTO orders(orderid,pizzaid,userid,additionalsIngredients,subtractsIngredients) VALUES(?,?,?,?,?)";

        try (Connection conn = dbconn.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, order.getOrderid());
            pstmt.setString(2, String.valueOf(order.getPizzaid()));
            pstmt.setInt(3, order.getUserid());
            pstmt.setString(4, String.valueOf(order.getAdditionalsIngredients()));
            pstmt.setString(5,String.valueOf(order.getSubtractsIngredients()));


            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Integer> selectPizzaId(int num){

        String sql = "SELECT pizzaid FROM orders WHERE orderid =" + "'" + num + "'";
        List<Integer> result = new LinkedList<>();

        try (Connection conn = dbconn.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql))

        {
            while (rs.next()) {
                int res;
                res = rs.getInt("pizzaid");
                result.add(res);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return result;
    }

    public List<String> selectOrdersub(int num){
        String sql = "SELECT subtractsIngredients FROM orders WHERE orderid =" + "'" + num + "'";
        List<String> result = new LinkedList<>();

        try (Connection conn = dbconn.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String res = rs.getString("subtractsIngredients");
                result.add(res);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return result;
    }

    public List<String> selectOrderadd(int num){
        String sql = "SELECT additionalsIngredients FROM orders WHERE orderid =" + "'" + num + "'";
        List<String> result = new LinkedList<>();

        try (Connection conn = dbconn.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String res = rs.getString("additionalsIngredients");
                result.add(res);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return result;
    }

    public int lastOrderID(){

//      String sql = "SELECT pizzaid FROM pizza";
        String maxorderid = "SELECT orderid FROM orders WHERE orderid = (SELECT MAX(orderid) FROM orders)";
        int lastid = 0;

        try (Connection conn = dbconn.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(maxorderid)) {

            while (rs.next()) {
                lastid = rs.getInt("orderid");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        lastid++;

        return lastid;
    }
}
