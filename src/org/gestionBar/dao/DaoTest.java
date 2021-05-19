/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gestionBar.dao;

import java.sql.SQLException;
import java.time.LocalDate;
import org.gestionBar.model.Boisson;
import org.gestionBar.model.Casier;
import org.gestionBar.model.Fournisseur;
import org.gestionBar.model.Marque;
import org.gestionBar.model.Serveur;

/**
 *
 * @author talhi
 */
public class DaoTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
     Fournisseur fournisseur=new Fournisseur("crosby", "Zanguéra", 90387121);
//        FournisseurDao.createFournisseur(fournisseur);
       Casier casier= new Casier(fournisseur, 10, 24, LocalDate.of(10, 10, 10), 8500.0);
     //  CasierDao.createCasier(casier);
     Marque marque=new Marque("BB Lomé");
    //   MarqueDao.createMarque(marque);
        Boisson boisson=new Boisson("Beaufort", "Alcoolisé", 600, casier, marque, 12);
           Boisson boisson1=new Boisson("Castel", "Alcoolisé", 500, casier, marque, 13);
              Boisson boisson2=new Boisson("Eku", "Alcoolisé", 350, casier, marque, 18);
                 Boisson boisson3=new Boisson("Flag", "Alcoolisé", 400, casier, marque, 12);
                    Boisson boisson4=new Boisson("Guiness", "Alcoolisé", 800, casier, marque, 12);
                       Boisson boisson5=new Boisson("Lager", "Alcoolisé", 300, casier, marque, 12);
                          Boisson boisson6=new Boisson("Pils", "Alcoolisé", 500, casier, marque, 12);
                             Boisson boisson7=new Boisson("SportActif", "energisante", 300, casier, marque, 12);
                                Boisson boisson8=new Boisson("XXL", "energisante", 450, casier, marque, 12);
                                   Boisson boisson9=new Boisson("Coca", "Sucrerie", 450, casier, marque, 12);
                                      Boisson boisson10=new Boisson("Fanta", "Sucrerie", 300, casier, marque, 12);
                                      
//          BoissonDao.createBoisson(boisson);
//           BoissonDao.createBoisson(boisson1);
//            BoissonDao.createBoisson(boisson2);
//             BoissonDao.createBoisson(boisson3);
//              BoissonDao.createBoisson(boisson4);
//               BoissonDao.createBoisson(boisson5);
//                BoissonDao.createBoisson(boisson6);
//                 BoissonDao.createBoisson(boisson7);
//                  BoissonDao.createBoisson(boisson8);
//                   BoissonDao.createBoisson(boisson9);
//                    BoissonDao.createBoisson(boisson10);
//System.out.println(BoissonDao.getByNom("malta"));
    Serveur serveur1=new Serveur("Khaled", "Ali",'M', LocalDate.of(10, 10, 10), 25000);
      Serveur serveur2=new Serveur("Omar", "Ali",'M', LocalDate.of(10, 10, 10), 25000);
        Serveur serveur3=new Serveur("Marius", "Ali",'M', LocalDate.of(10, 10, 10), 25000);
          Serveur serveur4=new Serveur("Serpi", "Ali",'M', LocalDate.of(10, 10, 10), 25000);
//           ServeurDao.createServeur(serveur4);
//           ServeurDao.createServeur(serveur3);
//           ServeurDao.createServeur(serveur2);
//           ServeurDao.createServeur(serveur1);
           System.out.println(ServeurDao.getAll());
           
        
//        System.out.println(Boisson.ifExist("Beaufort"));
    }
}
