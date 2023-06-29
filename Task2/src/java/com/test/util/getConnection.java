/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.util;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

/**
 *
 * @author Ganesh
 */
public class getConnection {
    static Connection con=null;
    static String username= "root";
    static String password="Shankar@123";
    static String URL="jdbc:mysql://localhost:3306/task2?zeroDateTimeBehavior=convertToNull";
    static String driver="com.mysql.jdbc.Driver";
    
    
    static{
        try{
            Class.forName(driver);
            con=DriverManager.getConnection(URL, username, password);
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
    public static Connection getConnection(){
        return con;
    }
    
}
