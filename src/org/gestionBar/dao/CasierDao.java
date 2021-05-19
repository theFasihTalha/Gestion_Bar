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
import org.gestionBar.model.Casier;
import org.gestionBar.model.Casier;
import org.gestionBar.model.Fournisseur;

/**
 *
 * @author talhi
 */
public class CasierDao {
    ///////////////////////////////////////////////////////////////////////////////////////////
      public static void createCasier( Casier c) throws ClassNotFoundException {
        try {
            Connection con=Connect.connexion();
            String sql="INSERT INTO CASIER(ID_FOURNISSEUR,NUM_CASIER,CAPACITE,DATE_LIVRAISON,PRIX_CASIER) VALUES (?,?,?,?,?)";
            PreparedStatement stat;
            stat=con.prepareStatement(sql);
            
            stat.setInt(1,FournisseurDao.getByNom(c.getFournisseur().getRaisonSocial()).getIdFournisseur());
            stat.setInt(2,c.getNumCasier());
            stat.setInt(3,c.getCapacité());
             stat.setDate(4, Date.valueOf(c.getDateLivraison()));
              stat.setDouble(5,c.getPrixCasier());
              stat.executeUpdate();
        } catch (SQLException ex) {       
              Logger.getLogger(CasierDao.class.getName()).log(Level.SEVERE, null, ex);
          }       
    }
   ////////////////////////////////////////////////////////////////////////////////////////////////////    
      public static Casier getByNumCasier(int numCasier) throws ClassNotFoundException {
        Connection con=Connect.connexion();
     Casier c1=new Casier();
        String sql="select * from  Casier where Num_Casier= ?";
          PreparedStatement stat=null;
        try {
             stat=con.prepareStatement(sql);
        } catch (SQLException ex) {
            Logger.getLogger(CasierDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            stat.setInt(1,numCasier);
        } catch (SQLException ex) {
            Logger.getLogger(CasierDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        ResultSet rs=null;
        try {
            rs=stat.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(CasierDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            rs.next();
           
               c1=new Casier (rs.getInt(1),FournisseurDao.getById(rs.getInt(2)),rs.getInt(3),rs.getInt(4),rs.getDate(5).toLocalDate(),rs.getDouble(6)); 
        
        } catch (SQLException ex) {
           System.out.println("Casier non trouvé");
           c1=null;
        }
        
        return c1;
  }
      /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        public static Casier getById(int id) throws ClassNotFoundException{
            Connection con=Connect.connexion();
    Casier c1=new Casier();
        String sql="select * from  Casier where id_Casier= ?";
          PreparedStatement stat=null;
        try {
             stat=con.prepareStatement(sql);
        } catch (SQLException ex) {
            Logger.getLogger(CasierDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            stat.setInt(1, id);
        } catch (SQLException ex) {
            Logger.getLogger(CasierDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        ResultSet rs=null;
        try {
            rs=stat.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(CasierDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            rs.next();
           
                c1=new Casier (rs.getInt(1),FournisseurDao.getById(rs.getInt(2)),rs.getInt(3),rs.getInt(4),rs.getDate(5).toLocalDate(),rs.getDouble(6)); 
        
        } catch (SQLException ex) {
           System.out.println("Casier non trouvé");
           c1=null;
        }
        
        return c1;
         
            
        }
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
           public static List<Casier> getAll() throws ClassNotFoundException
    {
         Connection con=Connect.connexion();
        List<Casier> liste=new ArrayList<>();
        String sql="select * from Casier";
          PreparedStatement stat=null;
        try {
             stat=con.prepareStatement(sql);
        } catch (SQLException ex) {
            Logger.getLogger(CasierDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        ResultSet rs=null;
        try {
            rs=stat.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(CasierDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while(rs.next())
            {
          liste.add(new Casier (rs.getInt(1),FournisseurDao.getById(rs.getInt(2)),rs.getInt(3),rs.getInt(4),rs.getDate(5).toLocalDate(),rs.getDouble(6))); 
            }
        } catch (SQLException ex) {
            Logger.getLogger(CasierDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return liste;
        
    }
           //////////////////////////////////////////////////////////////////////////////////////////////////////////////
            public static void Delete(int num) throws ClassNotFoundException{
        try {
            Connection con=Connect.connexion();
            String sql="delete from Casier where Num_Casier=?";
            PreparedStatement stat=null;
            try {
                stat=con.prepareStatement(sql);
            } catch (SQLException ex) {
                Logger.getLogger(CasierDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {
                stat.setInt(1, num);
            } catch (SQLException ex) {
                Logger.getLogger(CasierDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            stat.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CasierDao.class.getName()).log(Level.SEVERE, null, ex);
        }
         }
            
            
            
            
            public static void update(int id, Casier c) throws ClassNotFoundException{
               Connection con=Connect.connexion();
               
            String sql="update Casier set id_fournisseur=?, num_casier=?, capacite=?, date_livraison=?, prix_casier=?   where id_casier=?";
            PreparedStatement stat=null;
            try {
                stat=con.prepareStatement(sql);
            } catch (SQLException ex) {
                Logger.getLogger(FournisseurDao.class.getName()).log(Level.SEVERE, null, ex);
            }
           try {
               stat.setInt(1, c.getFournisseur().getIdFournisseur());
                stat.setInt(2, c.getNumCasier());
                stat.setInt(3, c.getCapacité());
               stat.setDate(4,Date.valueOf(c.getDateLivraison()));
               stat.setDouble(5,c.getPrixCasier());
               stat.setInt(6, id);
               
            
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
