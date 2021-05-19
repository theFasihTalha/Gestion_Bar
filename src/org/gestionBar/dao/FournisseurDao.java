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
import org.gestionBar.model.Fournisseur;
import org.gestionBar.model.Fournisseur;
import org.gestionBar.model.Fournisseur;

/**
 *
 * @author talhi
 */
public class FournisseurDao {
      public static void createFournisseur( Fournisseur f) throws ClassNotFoundException {
        try {
            Connection con=Connect.connexion();
            String sql="INSERT INTO FOURNISSEUR( RAISON_SOCIALE,ADRESSE,TEL) VALUES (?,?,?)";
            PreparedStatement stat;
            stat=con.prepareStatement(sql);
            
            stat.setString(1,f.getRaisonSocial());
            stat.setString(2,f.getAdresse());
            stat.setInt(3,f.getNumerotel());
        
            stat.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BoissonDao.class.getName()).log(Level.SEVERE, null, ex);
            
        } 
       
       
    }
       public static Fournisseur getById(int id) throws ClassNotFoundException{
            Connection con=Connect.connexion();
    Fournisseur f1=new Fournisseur();
        String sql="select * from  Fournisseur where id_Fournisseur= ?";
          PreparedStatement stat=null;
        try {
             stat=con.prepareStatement(sql);
        } catch (SQLException ex) {
            Logger.getLogger(FournisseurDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            stat.setInt(1, id);
        } catch (SQLException ex) {
            Logger.getLogger(FournisseurDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        ResultSet rs=null;
        try {
            rs=stat.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(FournisseurDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            rs.next();
           
              f1=new Fournisseur(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4));
        
        } catch (SQLException ex) {
           System.out.println("fournisseur non trouvé");
           f1=null;
        }
        
        return f1;
         
            
        }
       public static Fournisseur getByNom(String Nom) throws ClassNotFoundException{
            Connection con=Connect.connexion();
    Fournisseur f1=new Fournisseur();
        String sql="select * from  Fournisseur where Raison_Sociale= ?";
          PreparedStatement stat=null;
        try {
             stat=con.prepareStatement(sql);
        } catch (SQLException ex) {
            Logger.getLogger(FournisseurDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            stat.setString(1, Nom);
        } catch (SQLException ex) {
            Logger.getLogger(FournisseurDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        ResultSet rs=null;
        try {
            rs=stat.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(FournisseurDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            rs.next();
           
              f1=new Fournisseur(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4));
        
        } catch (SQLException ex) {
           System.out.println("fournnisseur non trouvé");
           f1=null;
        }
        
        return f1;
         
            
        }
       /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
       
           public static List<Fournisseur> getAll() throws ClassNotFoundException
    {
         Connection con=Connect.connexion();
        List<Fournisseur> liste=new ArrayList<>();
        String sql="select * from Fournisseur";
          PreparedStatement stat=null;
        try {
             stat=con.prepareStatement(sql);
        } catch (SQLException ex) {
            Logger.getLogger(FournisseurDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        ResultSet rs=null;
        try {
            rs=stat.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(FournisseurDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while(rs.next())
            {
          liste.add(new Fournisseur(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(FournisseurDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return liste;
        
    }
             public static void Delete(int id) throws ClassNotFoundException{
        try {
            Connection con=Connect.connexion();
            String sql="delete from Fournisseur where id_fournisseur=?";
            PreparedStatement stat=null;
            try {
                stat=con.prepareStatement(sql);
            } catch (SQLException ex) {
                Logger.getLogger(FournisseurDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {
                stat.setInt(1, id);
            } catch (SQLException ex) {
                Logger.getLogger(FournisseurDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            stat.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FournisseurDao.class.getName()).log(Level.SEVERE, null, ex);
        }
         }
             
             
             
              public static void update(int id, Fournisseur f ) throws ClassNotFoundException{
               Connection con=Connect.connexion();
               
            String sql="update Fournisseur set Raison_Sociale=?, ADRESSE=?, TEL=?   where id_fournisseur=?";
            PreparedStatement stat=null;
            try {
                stat=con.prepareStatement(sql);
            } catch (SQLException ex) {
                Logger.getLogger(FournisseurDao.class.getName()).log(Level.SEVERE, null, ex);
            }
           try {
               stat.setString(1, f.getRaisonSocial());
                stat.setString(2, f.getAdresse());
                stat.setInt(3, f.getNumerotel() );
               stat.setInt(4, id );
               
            
           } catch (SQLException ex) {
               Logger.getLogger(FournisseurDao.class.getName()).log(Level.SEVERE, null, ex);
           }
           try {
               stat.executeUpdate();
           } catch (SQLException ex) {
               Logger.getLogger(FournisseurDao.class.getName()).log(Level.SEVERE, null, ex);
           }
     
      }
}
