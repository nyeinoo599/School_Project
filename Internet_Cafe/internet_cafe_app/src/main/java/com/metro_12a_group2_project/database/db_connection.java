/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.metro_12a_group2_project.database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author xenon
 */
public class db_connection {
    public Connection getConnection() throws ClassNotFoundException{
        
        Connection con = null;
        String username = "batch-12";
        String password = "12345";
        String url = "jdbc:mysql://localhost:3306/pos";
         Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Load Driver......");
        try{
                      
            con = DriverManager.getConnection(url,username,password);
            System.out.println("connected....");
        }catch(SQLException ex){
            System.out.println("not connect");
        }
        return con;
        
        
    }
    
}
