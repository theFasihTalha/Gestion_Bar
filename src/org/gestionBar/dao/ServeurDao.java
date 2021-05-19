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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.gestionBar.connection.Connect;
import org.gestionBar.model.Serveur;
import org.gestionBar.model.Serveur;

/**
 *
 * @author talhi
 */
public class ServeurDao {
    
      public static void createServeur( Serveur s) throws ClassNotFoundException, SQLException {
        try {
            Connection con=Connect.connexion();
            String sql="INSERT INTO serveur(nomc,prenom,sexe,salaire,date_embauche) VALUES (?,?,?,?,?)";
            PreparedStatement stat;
            stat=con.prepareStatement(sql);
            
            stat.setString(1,s.getNomP());
            stat.setString(2,s.getPrenom());
            stat.setString(3,Character.toString(s.getSexe()));
            stat.setDouble(4,s.getSalaire());
            stat.setDate(5,Date.valueOf(s.getDateEmbauche()));
              stat.executeUpdate();
        } catch (SQLException ex) {       
            System.out.println(ex);
          }       
    }

     public static Serveur getByNom(String Nom) throws ClassNotFoundException{
            Connection con=Connect.connexion();
    Serveur s1=new Serveur();
        String sql="select * from  Serveur where nomc= ?";
          PreparedStatement stat=null;
        try {
             stat=con.prepareStatement(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ServeurDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            stat.setString(1, Nom);
        } catch (SQLException ex) {
            Logger.getLogger(ServeurDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        ResultSet rs=null;
        try {
            rs=stat.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(ServeurDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            rs.next();
            s1=new Serveur(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4).charAt(0), rs.getDouble(5), rs.getDate(6).toLocalDate());
             
        
        } catch (SQLException ex) {
           System.out.println("serveur not found");
           s1=null;
            System.out.println(ex);
        }
        
        return s1;
         
            
        }
     
            public static List<Serveur> getAll() throws ClassNotFoundException
    {
         Connection con=Connect.connexion();
        List<Serveur> liste=new ArrayList<>();
        String sql="select * from Serveur";
          PreparedStatement stat=null;
        try {
             stat=con.prepareStatement(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ServeurDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        ResultSet rs=null;
        try {
            rs=stat.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(ServeurDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while(rs.next())
            {
          liste.add(new Serveur(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4).charAt(0), rs.getDouble(5), rs.getDate(6).toLocalDate()));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServeurDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return liste;
        
    }
     
   public static Serveur getById(int id) throws ClassNotFoundException{
            Connection con=Connect.connexion();
    Serveur s1=new Serveur();
        String sql="select * from  Serveur where id_Personne= ?";
          PreparedStatement stat=null;
        try {
             stat=con.prepareStatement(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ServeurDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            stat.setInt(1, id);
        } catch (SQLException ex) {
            Logger.getLogger(ServeurDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        ResultSet rs=null;
        try {
            rs=stat.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(ServeurDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
          rs.next();
           
        s1=new Serveur(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4).charAt(0), rs.getDouble(5), rs.getDate(6).toLocalDate());
        
        } catch (SQLException ex) {
           System.out.println("serveu0r non trouvé");
             System.out.println(ex);
           s1=null;
        }
        
        return s1;     
        }
   
   
    public static void update(int id, Serveur s ) throws ClassNotFoundException{
               Connection con=Connect.connexion();
               
            String sql="update Serveur set NOMC=?,PRENOM=? ,SEXE =?,SALAIRE=?,DATE_EMBAUCHE=? where ID_PERSONNE  =?";
            PreparedStatement stat=null;
            try {
                stat=con.prepareStatement(sql);
            } catch (SQLException ex) {
                Logger.getLogger(TableDao.class.getName()).log(Level.SEVERE, null, ex);
            }
           try {
                stat.setString(1, s.getNomP());
               stat.setString(2, s.getPrenom());
                stat.setString(3, Character.toString(s.getSexe()));
                  stat.setDouble(4,s.getSalaire());
                    stat.setDate(5,Date.valueOf(s.getDateEmbauche()) );
                     stat.setInt(6,id);

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
