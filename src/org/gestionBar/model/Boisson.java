/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gestionBar.model;
import org.gestionBar.dao.BoissonDao;

/**
 *
 * @author talhi
 */
public class Boisson {
      private int idBoisson;
    private String Nom;
    private String type;
    private double prix;
    private Casier casier;
    private Marque marque;
    private int quantité;


    public Boisson() {
    }

    public Boisson(String Nom, String type, double prix,int quantité) {
        this.Nom = Nom;
        this.type = type;
        this.prix = prix;
         this.quantité = quantité;
    }
//CONTRUCTEUR COMPLET+++++++++++++++++++++++++++++++++++++++++++
    public Boisson(String Nom, String type, double prix, Casier casier, Marque marque, int quantité) {
        this.Nom = Nom;
        this.type = type;
        this.prix = prix;
        this.casier = casier;
        this.marque = marque;
        this.quantité = quantité;
    }
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
  public Boisson(String Nom, String type, double prix,  int idBoisson,Casier casier, Marque marque, int quantité) {
        this.idBoisson=idBoisson;
        this.Nom = Nom;
        this.type = type;
        this.prix = prix;
        this.casier = casier;
        this.marque = marque;
        this.quantité = quantité;
    }
    public int getQuantité() {
        return quantité;
    }

    public void setQuantité(int quantité) {
        this.quantité = quantité;
    }

    public int getIdBoisson() {
        return idBoisson;
    }

    public void setIdBoisson(int idBoisson) {
        this.idBoisson = idBoisson;
    }


    public Marque getMarque() {
        return marque;
    }

    public void setMarque(Marque marque) {
        this.marque = marque;
    }

    public String getNom() {
        return Nom;
    }


    public String getType() {
        return type;
    }

    public double getPrix() {
        return prix;
    }

    public Casier getCasier() {
        return casier;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

 
    public void setType(String type) {
        this.type = type;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public void setCasier(Casier casier) {
        this.casier = casier;
    }

    @Override
    public String toString() {
        return "Boisson{" + "Nom=" + Nom + ", type=" + type + ", prix=" + prix + ", casier=" + casier + ", marque=" + marque + ", quantite=" + quantité + '}';
    }
    
    public static boolean ifExist( String nom) throws ClassNotFoundException {
        boolean a = false;
        if (BoissonDao.getByNom(nom)==null) {
            
            a= false;
        }
       else
                { a=true;}
               
        return a;
        
    }
   
    
    
}
