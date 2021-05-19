/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gestionBar.model;

import java.util.List;

/**
 *
 * @author talhi
 */
public class CommandePerso {
   private Achat achat;
   private List boisson;
   private int quantité;

    public CommandePerso(Achat achat, List boisson, int quantité) {
        this.achat = achat;
        this.boisson = boisson;
        this.quantité = quantité;
    }


    

    public Achat getAchat() {
        return achat;
    }

    public void setAchat(Achat achat) {
        this.achat = achat;
    }

    public List getBoisson() {
        return boisson;
    }

    public void setBoisson(List boisson) {
        this.boisson = boisson;
    }

   

    public int getQuantité() {
        return quantité;
    }

    public void setQuantité(int quantité) {
        this.quantité = quantité;
    }

    @Override
    public String toString() {
        return "CommandePerso{" + "achat=" + achat + ", boisson=" + boisson + ", quantit\u00e9=" + quantité + '}';
    }
          
        public void commande() {
        
    }
    
}
