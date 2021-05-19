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
public class Marque {
    private String nom;
    private int idMarque;

    public Marque( int idMarque,String nom) {
        this.nom = nom;
        this.idMarque = idMarque;
    }
//CONSTRUCTEUR PRINCIPALE
    public Marque(String nom) {
       
        this.nom = nom;
    }

    public Marque() {
    }

    @Override
    public String toString() {
        return "Marque{" + "nom=" + nom + '}';
    }

    

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getIdMarque() {
        return idMarque;
    }

    public void setIdMarque(int idMarque) {
        this.idMarque = idMarque;
    }
    
    
}
