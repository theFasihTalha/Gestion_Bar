/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gestionBar.model;

import java.time.LocalDate;

/**
 *
 * @author talhi
 */
public class Gerand extends Personel {
     private String user;
    private String pass;
     private LocalDate dateEmbauche;
    private double Salaire;

    public Gerand(int idPersonne, String user, String pass, LocalDate dateEmbauche, double Salaire, String NomP, String prenom, char sexe) {
        super(idPersonne, NomP, prenom, sexe);
        this.user = user;
        this.pass = pass;
        this.dateEmbauche = dateEmbauche;
        this.Salaire = Salaire;
    }
///////CONSTRUCTEUR PRINCIPALE///////////////////////////////////

    public Gerand(String user, String pass, LocalDate dateEmbauche, double Salaire, String NomP, String prenom, char sexe) {
        super(NomP, prenom, sexe);
        this.user = user;
        this.pass = pass;
        this.dateEmbauche = dateEmbauche;
        this.Salaire = Salaire;
    }
  
   ////////////////////////////////////////////////////////////

    public Gerand() {
    }

    @Override
    public String toString() {
        return "Gerand{" + "user=" + user + ", pass=" + pass + ", dateEmbauche=" + dateEmbauche + ", Salaire=" + Salaire + '}';
    }




    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public LocalDate getDateEmbauche() {
        return dateEmbauche;
    }

    public void setDateEmbauche(LocalDate dateEmbauche) {
        this.dateEmbauche = dateEmbauche;
    }

    public double getSalaire() {
        return Salaire;
    }

    public void setSalaire(double Salaire) {
        this.Salaire = Salaire;
    }
    
}
