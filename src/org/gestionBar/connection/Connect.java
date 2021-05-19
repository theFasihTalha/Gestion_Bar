/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gestionBar.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author talhi
 */
public class Connect {
     static final String JDBC="com.mysql.jdbc.Driver";
    static final String database="jdbc:mysql://localhost:3306/gestion_bar";
    static final String user="root";
    static final String pwd="";
    static  Connection con;
     
    public static Connection connexion() throws ClassNotFoundException {
         try {
               
             Class.forName(JDBC);
        //   System.out.println("driver reussi");
             con=(Connection)DriverManager.getConnection(database,user,pwd);
        // System.out.println("connexion reussi");
         } catch (SQLException ex) {
             System.out.println("connexion echouer");
             Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
         }
         return con;
                }
        
    }

