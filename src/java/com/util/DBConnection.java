/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.util;

import java.sql.*;
/**
 *
 * @author nuha
 */
public class DBConnection {
    
    private static final String URL = "jdbc:mysql://localhost:3306/elatihan";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    
    private static Connection con;
    
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        try{
            Class.forName(DRIVER);
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e){
            e.getMessage();
        }
        return con;
    }
}