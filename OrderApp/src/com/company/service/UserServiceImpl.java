package com.company.service;

import com.company.dbConn.DBconn;
import com.company.model.User;

import java.sql.*;

public class UserServiceImpl {


    private DBconn dbconn = new DBconn();


    public void addUser(User user) {
        String sql = "INSERT INTO user(userid,name,phoneNumber,adressEmail,adress) VALUES(?,?,?,?,?)";

        try (Connection conn = dbconn.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, user.getUserid());
            pstmt.setString(2, user.getName());
            pstmt.setInt(3, user.getPhoneNumber());
            pstmt.setString(4, user.getAdressEmail());
            pstmt.setString(5, user.getAdress());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

//    public void addUser(int userid, String name, int phoneNumber, String adressEmail, String adress) {
//        String sql = "INSERT INTO user(userid,name,phoneNumber,adressEmail,adress) VALUES(?,?,?,?,?)";
//
//        try (Connection conn = dbconn.connect();
//             PreparedStatement pstmt = conn.prepareStatement(sql)) {
//            pstmt.setInt(1, userid);
//            pstmt.setString(2, name);
//            pstmt.setInt(3, phoneNumber);
//            pstmt.setString(4, adressEmail);
//            pstmt.setString(5,adress);
//
//            pstmt.executeUpdate();
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//    }

    public void selectAll() {
        String sql = "SELECT * FROM user";

        try (Connection conn = dbconn.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println(rs.getInt("userid") +  "\t" +
                        rs.getString("name") + "\t" +
                        rs.getInt("phoneNumber") + "\t" +
                        rs.getString("adressEmail")+ "\t" +
                        rs.getString("adress"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public int lastUserID(){

        String sql = "SELECT userid FROM user";
        String maxuserid = "SELECT userid FROM user WHERE userid = (SELECT MAX(userid) FROM user)";
        int lastid = 1;

        try (Connection conn = dbconn.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(maxuserid)) {

            while (rs.next()) {
                lastid = rs.getInt("userid");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        if(lastid == 0){
            lastid = 1;
        }
        lastid++;

        return lastid;
    }
}
