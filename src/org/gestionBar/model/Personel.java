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
public class Personel {
    private int idPersonne;
    private String NomP;
    private String prenom;
    private char sexe;
    
    
///////////CONSTRUCTEUR PRINCIPALE//////////////////////////////////
    public Personel(String NomP, String prenom, char sexe) {
        this.NomP = NomP;
        this.prenom = prenom;
        this.sexe = sexe;
    }
    ////////////////////////////////////////////////////////////////////

    public Personel(int idPersonne, String NomP, String prenom, char sexe) {
        this.idPersonne = idPersonne;
        this.NomP = NomP;
        this.prenom = prenom;
        this.sexe = sexe;
    }

    public Personel() {
    }
    

    public int getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne(int idPersonne) {
        this.idPersonne = idPersonne;
    }

    public String getNomP() {
        return NomP;
    }

    public void setNomP(String NomP) {
        this.NomP = NomP;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public char getSexe() {
        return sexe;
    }

    public void setSexe(char sexe) {
        this.sexe = sexe;
    }

    @Override
    public String toString() {
        return  NomP ;
    }
    
     
    
    
}
