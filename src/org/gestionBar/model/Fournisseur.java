/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gestionBar.model;

/**
 *
 * @author talhi
 */
public class Fournisseur {
      private int idFournisseur;
      private String raisonSocial;
      private String adresse;
      private int numerotel;

    public Fournisseur(int idFournisseur, String raisonSocial, String adresse, int numerotel) {
        this.idFournisseur = idFournisseur;
        this.raisonSocial = raisonSocial;
        this.adresse = adresse;
        this.numerotel = numerotel;
    }

    public Fournisseur() {
    }
//CONSTRUCTEUR PRINCIPALE
    public Fournisseur(String raisonSocial, String adresse, int numerotel) {
        this.idFournisseur=idFournisseur+1;
        this.raisonSocial = raisonSocial;
        this.adresse = adresse;
        this.numerotel = numerotel;
    }

    public int getIdFournisseur() {
        return idFournisseur;
    }

    public void setIdFournisseur(int idFournisseur) {
        this.idFournisseur = idFournisseur;
    }

    public String getRaisonSocial() {
        return raisonSocial;
    }

    public void setRaisonSocial(String raisonSocial) {
        this.raisonSocial = raisonSocial;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getNumerotel() {
        return numerotel;
    }

    public void setNumerotel(int numerotel) {
        this.numerotel = numerotel;
    }

    @Override
    public String toString() {
        return "Fournisseur{" + "raisonSocial=" + raisonSocial + ", adresse=" + adresse + ", numerotel=" + numerotel + '}';
    }

    
      
}
