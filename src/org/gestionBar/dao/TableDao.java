/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gestionBar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.gestionBar.connection.Connect;
import org.gestionBar.model.Table;

/**
 *
 * @author talhi
 */
public class TableDao {
    
    public static void createTable( Table t) throws ClassNotFoundException, SQLException {
        try {
            Connection con=Connect.connexion();
            String sql="INSERT INTO Tb(NumTable,NB_PLACE,OCCUPE) VALUES (?,?,?)";
            PreparedStatement stat=con.prepareStatement(sql);
            stat.setInt(1,t.getNumTable());
            stat.setInt(2,t.getNbPlace());
            stat.setBoolean(3,t.isStatut());
              stat.executeUpdate();
        } catch (SQLException ex) {       
              Logger.getLogger(CasierDao.class.getName()).log(Level.SEVERE, null, ex);
          }       
    }
    public static List<Table> getAll() throws ClassNotFoundException
    {
         Connection con=Connect.connexion();
        List<Table> liste=new ArrayList<>();
        String sql="select * from tb";
          PreparedStatement stat=null;
        try {
             stat=con.prepareStatement(sql);
        } catch (SQLException ex) {
            Logger.getLogger(TableDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        ResultSet rs=null;
        try {
            rs=stat.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(TableDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while(rs.next())
            {
          liste.add(new Table(rs.getInt(1),rs.getInt(2),rs.getBoolean(4),rs.getInt(3)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TableDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return liste;
}
              /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
         public static void Delete(int t) throws ClassNotFoundException{
        try {
            Connection con=Connect.connexion();
            String sql="delete from tb where NumTable =?";
            PreparedStatement stat=null;
            try {
                stat=con.prepareStatement(sql);
            } catch (SQLException ex) {
                Logger.getLogger(TableDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {
                stat.setInt(1, t);
            } catch (SQLException ex) {
                Logger.getLogger(TableDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            stat.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TableDao.class.getName()).log(Level.SEVERE, null, ex);
        }
         }
       
   /////////////////////////////////////////////////////////////////////////////////////////////////////
         
         public static void update(int num, Table tb ) throws ClassNotFoundException{
               Connection con=Connect.connexion();
               
            String sql="update tb set OCCUPE=?  where NumTable =?";
            PreparedStatement stat=null;
            try {
                stat=con.prepareStatement(sql);
            } catch (SQLException ex) {
                Logger.getLogger(TableDao.class.getName()).log(Level.SEVERE, null, ex);
            }
           try {
               stat.setBoolean(1, tb.isStatut());
               stat.setInt(2, num );
               
          
           } catch (SQLException ex) {
               Logger.getLogger(TableDao.class.getName()).log(Level.SEVERE, null, ex);
           }
           try {
               stat.executeUpdate();
           } catch (SQLException ex) {
               Logger.getLogger(TableDao.class.getName()).log(Level.SEVERE, null, ex);
           }
     
      }
}
