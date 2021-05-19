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
import org.gestionBar.model.Marque;
import org.gestionBar.model.Marque;

/**
 *
 * @author talhi
 */
public class MarqueDao {
       public static void createMarque( Marque m) throws ClassNotFoundException {
        try {
            Connection con=Connect.connexion();
            String sql="INSERT INTO MARQUE(NOM_MARQUE) VALUES (?)";
            PreparedStatement stat=con.prepareStatement(sql);
            stat.setString(1,m.getNom());
              stat.executeUpdate();
        } catch (SQLException ex) {       
              Logger.getLogger(CasierDao.class.getName()).log(Level.SEVERE, null, ex);
          }       
    }
       
       
       ///////////////////////////////////////////////////////////////////////////////////////
     
       public static Marque getByNom(String Nom_marque) throws ClassNotFoundException{
            Connection con=Connect.connexion();
    Marque  m1=new Marque();
        String sql="select * from  Marque where Nom_Marque= ?";
          PreparedStatement stat=null;
        try {
             stat=con.prepareStatement(sql);
            stat.setString(1, Nom_marque);
        ResultSet rs=null;
       
            rs=stat.executeQuery();
                rs.next();
     m1=new Marque(rs.getInt(1),rs.getString(2));
        
        } catch (SQLException ex) {
           System.out.println("marque non trouvé");
           m1=null;
        }
        
        return m1;
         
            
        }
       ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
          public static Marque getById(int id) throws ClassNotFoundException{
            Connection con=Connect.connexion();
    Marque m1=new Marque();
        String sql="select * from  Marque where id_Marque= ?";
          PreparedStatement stat=null;
        try {
             stat=con.prepareStatement(sql);
        } catch (SQLException ex) {
            Logger.getLogger(MarqueDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            stat.setInt(1, id);
        } catch (SQLException ex) {
            Logger.getLogger(MarqueDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        ResultSet rs=null;
        try {
            rs=stat.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(MarqueDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            rs.next();
           
              m1=new Marque(rs.getInt(1),rs.getString(2));
        
        } catch (SQLException ex) {
           System.out.println("Marque non trouvé");
           m1=null;
        }
        
        return m1;
         
            
        }
          /////////////////////////////////////////////////////////////////////////
              public static List<Marque> getAll() throws ClassNotFoundException
    {
         Connection con=Connect.connexion();
        List<Marque> liste=new ArrayList<>();
        String sql="select * from Marque";
          PreparedStatement stat=null;
        try {
             stat=con.prepareStatement(sql);
        } catch (SQLException ex) {
            Logger.getLogger(MarqueDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        ResultSet rs=null;
        try {
            rs=stat.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(MarqueDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while(rs.next())
            {
          liste.add(new Marque(rs.getInt(1),rs.getString(2)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MarqueDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return liste;
}
              /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
         public static void Delete(int id) throws ClassNotFoundException{
        try {
            Connection con=Connect.connexion();
            String sql="delete from Marque where id_marque=?";
            PreparedStatement stat=null;
            try {
                stat=con.prepareStatement(sql);
            } catch (SQLException ex) {
                Logger.getLogger(MarqueDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {
                stat.setInt(1, id);
            } catch (SQLException ex) {
                Logger.getLogger(MarqueDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            stat.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MarqueDao.class.getName()).log(Level.SEVERE, null, ex);
        }
         }
       
   /////////////////////////////////////////////////////////////////////////////////////////////////////
         public static void update(int id, Marque marque ) throws ClassNotFoundException{
               Connection con=Connect.connexion();
               
            String sql="update Marque set Nom_Marque=?  where id_marque=?";
            PreparedStatement stat=null;
            try {
                stat=con.prepareStatement(sql);
            } catch (SQLException ex) {
                Logger.getLogger(MarqueDao.class.getName()).log(Level.SEVERE, null, ex);
            }
           try {
               stat.setString(1, marque.getNom());
               stat.setInt(2, id );
               
//            try {
//                stat.setString(1, nom);
//             
           } catch (SQLException ex) {
               Logger.getLogger(MarqueDao.class.getName()).log(Level.SEVERE, null, ex);
           }
           try {
               stat.executeUpdate();
           } catch (SQLException ex) {
               Logger.getLogger(MarqueDao.class.getName()).log(Level.SEVERE, null, ex);
           }
     
      }
         

}
