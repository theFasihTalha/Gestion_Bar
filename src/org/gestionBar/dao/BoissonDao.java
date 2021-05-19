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
import org.gestionBar.model.Boisson;

/**
 *
 * @author talhi
 */
public class BoissonDao {
    
     
    public static void createBoisson( Boisson b) throws ClassNotFoundException {
        try {
            Connection con=Connect.connexion();
            String sql="INSERT INTO BOISSON(ID_MARQUE,ID_CASIER,NOMB,QTE,TYPE,PRIX) VALUES (?,?,?,?,?,?)";
            PreparedStatement stat;
            stat=con.prepareStatement(sql);
            
            stat.setInt(1,MarqueDao.getByNom(b.getMarque().getNom()).getIdMarque());
            stat.setInt(2,CasierDao.getByNumCasier(b.getCasier().getNumCasier()).getIdCasier());
            stat.setString(3,b.getNom());
            stat.setInt(4,b.getQuantité());
            stat.setString(5,b.getType());
            stat.setDouble(6,b.getPrix());
            
            stat.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BoissonDao.class.getName()).log(Level.SEVERE, null, ex);
        }          
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
     public static List<Boisson> getAll() throws ClassNotFoundException
    {
         Connection con=Connect.connexion();
        List<Boisson> liste=new ArrayList<>();
        String sql="select * from Boisson";
          PreparedStatement stat=null;
        try {
             stat=con.prepareStatement(sql);
        } catch (SQLException ex) {
            Logger.getLogger(BoissonDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        ResultSet rs=null;
        try {
            rs=stat.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(BoissonDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while(rs.next())
            {
          liste.add(new Boisson(rs.getString(4),rs.getString(6),rs.getDouble(7),rs.getInt(1),CasierDao.getById(rs.getInt(3)),MarqueDao.getById(rs.getInt(2)),rs.getInt(5))); 
            }
        } catch (SQLException ex) {
            Logger.getLogger(BoissonDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return liste;
        
    }
     
     
       public static Boisson getByNom(String Nom) throws ClassNotFoundException{
            Connection con=Connect.connexion();
    Boisson b1=new Boisson();
        String sql="select * from  Boisson where nomb= ?";
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
           
              b1=new Boisson(rs.getString(4),rs.getString(6),rs.getDouble(7),rs.getInt(1),CasierDao.getById(rs.getInt(3)),MarqueDao.getById(rs.getInt(2)),rs.getInt(5)) ;
        
        
        } catch (SQLException ex) {
       //    System.out.println("boisson non trouvé");
           b1=null;
        }
        
        return b1;
         
            
        }
     /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
           public static void Delete(String nom) throws ClassNotFoundException{
        try {
            Connection con=Connect.connexion();
            String sql="delete from Boisson where NomB=?";
            PreparedStatement stat=null;
            try {
                stat=con.prepareStatement(sql);
            } catch (SQLException ex) {
                Logger.getLogger(BoissonDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {
                stat.setString(1, nom);
            } catch (SQLException ex) {
                Logger.getLogger(BoissonDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            stat.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BoissonDao.class.getName()).log(Level.SEVERE, null, ex);
        }
         }
    
     public static void update(int id, Boisson b) throws ClassNotFoundException{
               Connection con=Connect.connexion();
               
            String sql="update Boisson set id_marque=?, id_casier=?, nomb=?, qte=?, type=?, prix=? where id_boisson=?";
            PreparedStatement stat=null;
            try {
                stat=con.prepareStatement(sql);
            } catch (SQLException ex) {
                Logger.getLogger(FournisseurDao.class.getName()).log(Level.SEVERE, null, ex);
            }
           try {
               stat.setInt(1, b.getMarque().getIdMarque());
                stat.setInt(2, b.getCasier().getIdCasier());
                stat.setString(3, b.getNom());
               stat.setInt(4, b.getQuantité());
               stat.setString(5,b.getType());
               stat.setDouble(6,b.getPrix());
               stat.setInt(7,id);
               
            
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
