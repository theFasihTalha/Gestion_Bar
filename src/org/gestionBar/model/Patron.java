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
public class Patron extends Personel {
    private String user;
    private String pass;

    public Patron(String user, String pass, int idPersonne, String NomP, String prenom, char sexe) {
        super(idPersonne, NomP, prenom, sexe);
        this.user = user;
        this.pass = pass;
    }
///////////CONSTRUCTEUR PRINCIPAL
    public Patron(String user, String pass, String NomP, String prenom, char sexe) {
        super(NomP, prenom, sexe);
        this.user = user;
        this.pass = pass;
    }
    
    
 public Patron(String NomP, String prenom, char sexe) {
        super(NomP, prenom, sexe);
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
    
   
    
}
