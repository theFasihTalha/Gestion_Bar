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
public class Table {
    private int idTable;
    private int numTable;
    private boolean statut;
    private int nbPlace;

    public Table(int idTable, int numTable, boolean statut, int nbPlace) {
        this.idTable = idTable;
        this.numTable = numTable;
        this.statut = statut;
        this.nbPlace = nbPlace;
    }
////////////////////////////////////////////////////////////////////////
    public Table(int numTable, boolean statut, int nbPlace) {
        this.numTable = numTable;
        this.statut = statut;
        this.nbPlace = nbPlace;
    }
//////////////////////////////////////////////////////////////////
    public int getIdTable() {
        return idTable;
    }

    public void setIdTable(int idTable) {
        this.idTable = idTable;
    }

    public int getNumTable() {
        return numTable;
    }

    public void setNumTable(int numTable) {
        this.numTable = numTable;
    }

    public boolean isStatut() {
        return statut;
    }

    public void setStatut(boolean statut) {
        this.statut = statut;
    }

    public int getNbPlace() {
        return nbPlace;
    }

    public void setNbPlace(int nbPlace) {
        this.nbPlace = nbPlace;
    }

    @Override
    public String toString() {
        return "Table{" + "idTable=" + idTable + ", numTable=" + numTable + ", statut=" + statut + ", nbPlace=" + nbPlace + '}';
    }
    
    
}
