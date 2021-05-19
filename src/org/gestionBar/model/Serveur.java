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
public class Serveur extends Personel {
    
    private LocalDate dateEmbauche;
    private double Salaire;

    public Serveur( int idPersonne, String NomP, String prenom, char sexe,  double Salaire, LocalDate dateEmbauche) {
        super(idPersonne, NomP, prenom, sexe);
        this.dateEmbauche = dateEmbauche;
        this.Salaire = Salaire;
    }
////////////////////CONSTRUCTEUR PRINCIPALE///////////////////////
    public Serveur( String NomP, String prenom, char sexe, LocalDate dateEmbauche, double Salaire) {
        super(NomP, prenom, sexe);
        this.dateEmbauche = dateEmbauche;
        this.Salaire = Salaire;
    }
  ////////////////////////////////////////////////////////////////////////////  
    public Serveur(String NomP, String prenom, char sexe) {
        super(NomP, prenom, sexe);
    }

    public Serveur() {
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
