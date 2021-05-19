/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gestionBar.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.gestionBar.connection.Connect;
import org.gestionBar.model.Gerand;

/**
 *
 * @author talhi
 */
public class GerandDao {
    
    
    public static void createGerand( Gerand g) throws ClassNotFoundException, SQLException {
        try {
            Connection con=Connect.connexion();
            String sql="INSERT INTO gerand(nomc,prenom,sexe,date_embaucheg ,Userg ,codeg,salaireg) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement stat;
            stat=con.prepareStatement(sql);
            
            stat.setString(1,g.getNomP());
            stat.setString(2,g.getPrenom());
            stat.setString(3,Character.toString(g.getSexe()));
            stat.setDate(4,Date.valueOf(g.getDateEmbauche()));
            stat.setString(5,g.getUser());
              stat.setString(6,g.getPass());
               stat.setDouble(7,g.getSalaire());
              
              
              
              stat.executeUpdate();
        } catch (SQLException ex) {       
            System.out.println(ex);
          }       
    }

     public static Gerand getByNom(String Nom) throws ClassNotFoundException{
            Connection con=Connect.connexion();
    Gerand g1=new Gerand();
        String sql="select * from  Gerand where nomc= ?";
          PreparedStatement stat=null;
        try {
             stat=con.prepareStatement(sql);
        } catch (SQLException ex) {
            Logger.getLogger(GerandDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            stat.setString(1, Nom);
        } catch (SQLException ex) {
            Logger.getLogger(GerandDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        ResultSet rs=null;
        try {
            rs=stat.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(GerandDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            rs.next();
            g1=new Gerand(rs.getInt(1),rs.getString(6),rs.getString(7),rs.getDate(5).toLocalDate(),rs.getDouble(8),rs.getString(2),rs.getString(3),rs.getString(4).charAt(0));
             
        
        } catch (SQLException ex) {
           System.out.println("gerand non trouvé");
           g1=null;
        }
        
        return g1;
         
            
        }
      public static Gerand getByLogin(String login) throws ClassNotFoundException{
            Connection con=Connect.connexion();
    Gerand g1=new Gerand();
        String sql="select * from  Gerand where Userg= ?";
          PreparedStatement stat=null;
        try {
             stat=con.prepareStatement(sql);
        } catch (SQLException ex) {
            Logger.getLogger(GerandDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            stat.setString(1, login);
        } catch (SQLException ex) {
            Logger.getLogger(GerandDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        ResultSet rs=null;
        try {
            rs=stat.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(GerandDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            rs.next();
            g1=new Gerand(rs.getInt(1),rs.getString(6),rs.getString(7),rs.getDate(5).toLocalDate(),rs.getDouble(8),rs.getString(2),rs.getString(3),rs.getString(4).charAt(0));
             
        
        } catch (SQLException ex) {
           System.out.println("gerand non trouvé");
           g1=null;
        }
        
        return g1;
         
            
        }
      public static Gerand  getByLog(String login,String password) throws ClassNotFoundException
  {
     Connection con=Connect.connexion();
        String sql="select * from Gerand where Userg=? and codeg=?";
          PreparedStatement stat=null;
        try {
             stat=con.prepareStatement(sql);
        } catch (SQLException ex) {
            Logger.getLogger(GerandDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            stat.setString(1, login);
            stat.setString(2, password);
        } catch (SQLException ex) {
            Logger.getLogger(GerandDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        ResultSet rs=null;
        try {
            rs=stat.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(GerandDao.class.getName()).log(Level.SEVERE, null, ex);
        }
          Gerand g1=null;
        try {
            rs.next();
            g1=new Gerand(rs.getInt(1),rs.getString(6),rs.getString(7),rs.getDate(5).toLocalDate(),rs.getDouble(8),rs.getString(2),rs.getString(3),rs.getString(4).charAt(0));
            
            
        } catch (SQLException ex) {
           System.out.println("Gerand non trouvé");
           g1=null;
        }
        
        return g1;
  }
     
   public static Gerand getById(int id) throws ClassNotFoundException{
            Connection con=Connect.connexion();
    Gerand g1=new Gerand();
        String sql="select * from  Gerand where id_Personne= ?";
          PreparedStatement stat=null;
        try {
             stat=con.prepareStatement(sql);
        } catch (SQLException ex) {
            Logger.getLogger(GerandDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            stat.setInt(1, id);
        } catch (SQLException ex) {
            Logger.getLogger(GerandDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        ResultSet rs=null;
        try {
            rs=stat.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(GerandDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            rs.next();
           
             g1=new Gerand(rs.getInt(1),rs.getString(6),rs.getString(7),rs.getDate(5).toLocalDate(),rs.getDouble(8),rs.getString(2),rs.getString(3),rs.getString(4).charAt(0));
        
        } catch (SQLException ex) {
           System.out.println("gerand non trouvé");
           g1=null;
        }
        
        return g1;
         
            
        }
    public static void update(int id, Gerand g ) throws ClassNotFoundException{
               Connection con=Connect.connexion();
               
            String sql="update Gerand set NOMC=?, PRENOM=?, SEXE =?, date_embaucheg =?, Userg =?, CODEG=?, SALAIREG=?  where Id_personne=?";
            PreparedStatement stat=null;
            try {
                stat=con.prepareStatement(sql);
            } catch (SQLException ex) {
                Logger.getLogger(GerandDao.class.getName()).log(Level.SEVERE, null, ex);
            }
           try {
               stat.setString(1, g.getNomP());
               stat.setString(2, g.getPrenom());
                stat.setString(3, Character.toString(g.getSexe()));
               stat.setDate(4,Date.valueOf(g.getDateEmbauche()));
                stat.setString(5,g.getUser());
                  stat.setString(6,g.getPass());
                  stat.setDouble(7,g.getSalaire());
                  stat.setInt(8,id);
           
          } catch (SQLException ex) {
               Logger.getLogger(GerandDao.class.getName()).log(Level.SEVERE, null, ex);
           }
           try {
               stat.executeUpdate();
           } catch (SQLException ex) {
               Logger.getLogger(GerandDao.class.getName()).log(Level.SEVERE, null, ex);
           }
     
      }
    
}
