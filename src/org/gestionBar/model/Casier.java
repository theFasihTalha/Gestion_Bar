/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gestionBar.model;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author talhi
 */
public class Casier {
      private int idCasier;
    private Fournisseur fournisseur;
    private int capacité;
    private LocalDate dateLivraison;
    private Double prixCasier;
    private int numCasier;
 public Casier(int idCasier,Fournisseur fournisseur, int numCasier, int capacité, LocalDate dateLivraison, Double prixCasier) {
          this.idCasier = idCasier;
        this.fournisseur = fournisseur;
        this.capacité = capacité;
        this.dateLivraison = dateLivraison;
        this.prixCasier = prixCasier;
        this.numCasier = numCasier;
    }
   

//CONSTRUCTEUR PRINCIPALE///////////////////////////////////////////////////////

    public Casier(Fournisseur fournisseur, int numCasier, int capacité, LocalDate dateLivraison, Double prixCasier) {
          this.idCasier = idCasier;
        this.fournisseur = fournisseur;
        this.capacité = capacité;
        this.dateLivraison = dateLivraison;
        this.prixCasier = prixCasier;
        this.numCasier = numCasier;
    }
////////////////////////////////////////////////////////////////////////////////////
    public int getNumCasier() {
        return numCasier;
    }

    public void setNumCasier(int numCasier) {
        this.numCasier = numCasier;
    }
  

    public Casier() {
    }

    public int getIdCasier() {
        return idCasier;
    }

    public void setIdCasier(int idCasier) {
        this.idCasier = idCasier;
    }

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }

    public int getCapacité() {
        return capacité;
    }

    public void setCapacité(int capacité) {
        this.capacité = capacité;
    }

    public LocalDate getDateLivraison() {
        return dateLivraison;
    }

    public void setDateLivraison(LocalDate dateLivraison) {
        this.dateLivraison = dateLivraison;
    }

    public Double getPrixCasier() {
        return prixCasier;
    }

    public void setPrixCasier(Double prixCasier) {
        this.prixCasier = prixCasier;
    }

    @Override
    public String toString() {
        return "Casier{" + "fournisseur=" + fournisseur + ", capacit\u00e9=" + capacité + ", dateLivraison=" + dateLivraison + ", prixCasier=" + prixCasier + '}';
    }



    
}
