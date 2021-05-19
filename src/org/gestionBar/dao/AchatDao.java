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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.gestionBar.connection.Connect;
import org.gestionBar.model.Achat;

/**
 *
 * @author talhi
 */
public class AchatDao {
    
    
     public static void createAchat( Achat a) throws ClassNotFoundException, SQLException {
        try {
            Connection con=Connect.connexion();
            String sql="INSERT INTO ACHAT( ID_PERSONNE,SER_ID_PERSONNE,DATE_ACHAT,MONTANT) VALUES (?,?,?,?)";
            PreparedStatement stat;
            stat=con.prepareStatement(sql);
            
            stat.setInt(1,GerandDao.getByNom(a.getGerand().getNomP()).getIdPersonne());
            stat.setInt(2,ServeurDao.getByNom(a.getServeur().getNomP()).getIdPersonne());
            stat.setDate(3,Date.valueOf(a.getDate_achat()));
            stat.setDouble(4,a.getMontant()); 
           
              stat.executeUpdate();
        } catch (SQLException ex) {       
            System.out.println(ex);
          }       
    }
     
     
      public static List getByDate(LocalDate date) throws ClassNotFoundException {
        Connection con=Connect.connexion();
    List list=new ArrayList();
        String sql="select * from  Achat where date_achat= ?";
          PreparedStatement stat=null;
        try {
             stat=con.prepareStatement(sql);
        } catch (SQLException ex) {
            Logger.getLogger(AchatDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            stat.setDate(1,Date.valueOf(date));
        } catch (SQLException ex) {
            Logger.getLogger(AchatDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        ResultSet rs=null;
        try {
            rs=stat.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(AchatDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while(rs.next())
            {
          list.add(new Achat (rs.getInt(1), rs.getDate(4).toLocalDate(),GerandDao.getById(rs.getInt(2)),rs.getDouble(5),ServeurDao.getById(rs.getInt(3))) ); 
            }
       
        } catch (SQLException ex) {
           System.out.println("Achat non trouvé");
        }
        
        return list;
  }
}
