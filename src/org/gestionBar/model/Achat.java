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
public class Achat {
    private LocalDate date_achat;
    private int idAchat;
    private Gerand gerand;
    private double montant;
    private Serveur serveur;

    public Achat(int idAchat,LocalDate date_achat, Gerand gerand, double montant, Serveur serveur) {
        this.date_achat = date_achat;
        this.idAchat = idAchat;
        this.gerand = gerand;
        this.montant = montant;
        this.serveur = serveur;
    }
    
////////////////////////////////////////////////////////////////////////////////

    public Achat(LocalDate date_achat, Gerand gerand, double montant, Serveur serveur) {
        this.date_achat = date_achat;
        this.gerand = gerand;
        this.montant = montant;
        this.serveur = serveur;
    }
   
 /////////////////////////////////////////////////////////////////////////////////////////////////////   

    public Achat() {
    }

    public Serveur getServeur() {
        return serveur;
    }

    public void setServeur(Serveur serveur) {
        this.serveur = serveur;
    }

    public LocalDate getDate_achat() {
        return date_achat;
    }

    public void setDate_achat(LocalDate date_achat) {
        this.date_achat = date_achat;
    }

    public int getIdAchat() {
        return idAchat;
    }

    public void setIdAchat(int idAchat) {
        this.idAchat = idAchat;
    }

    public Gerand getGerand() {
        return gerand;
    }

    public void setGerand(Gerand gerand) {
        this.gerand = gerand;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    @Override
    public String toString() {
        return "Achat{" + "date_achat=" + date_achat + ", idAchat=" + idAchat + ", gerand=" + gerand + ", montant=" + montant + ", serveur=" + serveur + '}';
    }

 
    
}
