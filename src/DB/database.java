/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author FAZLAN
 */
public class database {
    
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/sampath_food_city";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    
    public static Connection getConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(JDBC_URL,USERNAME,PASSWORD);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
    
    

