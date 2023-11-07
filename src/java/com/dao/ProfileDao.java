/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao;

import com.model.Profile;
import com.util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nuha
 */
public class ProfileDao {

    private static final String INSERT_SQL = "insert into profile (name, email, password, ic, gender, kpi, contact, staffid, grade, address) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String EDIT_SQL = "update profile set email=?, ic=?, address=?, grade=?, kpi=?, contact=? where id=?";
    private static final String DELETE_SQL = "delete from profile where id=?";
    private static final String SELECT_ID_SQL = "select id, name, email, password, ic, gender, kpi, contact, staffid, grade, address from profile where id=?";
    private static final String CHECK_EMAIL_SQL = "select count(*) from profile where email=?";
    private static final String LOGIN_SQL = "select * from profile where email=? and password=?";
    private static final String SELECT_EMAIL_SQL = "select * from profile where email=?";

    private final Connection con;

    public ProfileDao() throws SQLException, ClassNotFoundException {
        con = DBConnection.getConnection();
    }

    public void insert(Profile profile) throws SQLException {
        try ( PreparedStatement ps = con.prepareStatement(INSERT_SQL)) {
            ps.setString(1, profile.getName());
            ps.setString(2, profile.getEmail());
            ps.setString(3, profile.getPassword());
            ps.setString(4, profile.getIc());
            ps.setString(5, profile.getGender());
            ps.setString(6, profile.getKpi());
            ps.setString(7, profile.getContact());
            ps.setString(8, profile.getStaffid());
            ps.setString(9, profile.getGrade());
            ps.setString(10, profile.getAddress());
            ps.executeUpdate();
        }
    }

    public Profile selectById(int id) throws SQLException {
        Profile profile = new Profile();
        try ( PreparedStatement ps = con.prepareStatement(SELECT_ID_SQL)) {
            ps.setInt(1, id);
            try ( ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    profile.setName(rs.getString("name"));
                    profile.setEmail(rs.getString("email"));
                    profile.setPassword(rs.getString("password"));
                    profile.setIc(rs.getString("ic"));
                    profile.setGender(rs.getString("gender"));
                    profile.setKpi(rs.getString("kpi"));
                    profile.setContact(rs.getString("contact"));
                    profile.setStaffid(rs.getString("staffid"));
                    profile.setGrade(rs.getString("grade"));
                    profile.setAddress(rs.getString("address"));
                    //profile = new Profile (name, email, password, id, gender, kpi, contact, staffid, grade, address);
                }
            }
        }
        return profile;
    }

   public void update(Profile profile) throws SQLException {
    PreparedStatement ps = null;

    try {
        ps = con.prepareStatement(EDIT_SQL);
        ps.setString(1, profile.getEmail());
        ps.setString(2, profile.getIc());
        ps.setString(3, profile.getAddress());
        ps.setString(4, profile.getGrade());
        ps.setString(5, profile.getKpi());
        ps.setString(6, profile.getContact());
        ps.setInt(7, profile.getId());

        int rowsUpdated = ps.executeUpdate();

        if (rowsUpdated == 0) {
            throw new SQLException("Failed to update profile. No rows affected.");
        }
    } finally {
        // Close the statement and connection
        if (ps != null) {
            ps.close();
        }
        if (con != null) {
            con.close();
        }
    }
}


    public boolean delete(int id) throws SQLException {
        boolean rowDel;
        try ( PreparedStatement ps = con.prepareStatement(DELETE_SQL)) {
            ps.setInt(1, id);
            rowDel = ps.executeUpdate() > 0;
        }
        return rowDel;
    }

    // Check if the email already exists in the database
    public boolean emailExists(String email) throws SQLException {
        try ( PreparedStatement ps = con.prepareStatement(CHECK_EMAIL_SQL)) {
            ps.setString(1, email);
            try ( ResultSet resultSet = ps.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count > 0;
                }
            }
        }
        return false;
    }

   public boolean validateLogin(String email, String password) {
        try ( PreparedStatement ps = con.prepareStatement(LOGIN_SQL)) {
                // Execute the query
                ps.setString(1, email);
                ps.setString(2, password);
                ResultSet resultSet = ps.executeQuery();

                // Check if the result set has any rows
                if (resultSet.next()) {
                    // User credentials are valid
                    return true;
                } else {
                    // User credentials are invalid
                    resultSet.close(); 
                    return false;
                }
           // }
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Return false in case of an exception
        }
    }

    public Profile getUserByEmail(String email) throws SQLException {
        Profile profile = null;

        try ( PreparedStatement ps = con.prepareStatement(SELECT_EMAIL_SQL)) {
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                // Retrieve the user's information from the result set
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String ic = rs.getString("ic");
                String gender = rs.getString("gender");
                String kpi = rs.getString("kpi");
                String contact = rs.getString("contact");
                String staffid = rs.getString("staffid");
                String grade = rs.getString("grade");
                String address = rs.getString("address");

                // Create a User object with the retrieved information
                profile = new Profile(id, name, email, ic, gender, kpi, contact, staffid, grade, address);
                // Set other fields of the User object

                // You can retrieve additional information from related tables if needed
            }
        } catch (SQLException e) {
            throw e;
        }
        return profile;
    }

    public void closeConnection() throws SQLException {
        con.close();
    }

}
