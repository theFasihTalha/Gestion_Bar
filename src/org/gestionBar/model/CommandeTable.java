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
public class CommandeTable {
    private Achat achat;
    private Table table;

    public CommandeTable(Achat achat, Table table) {
        this.achat = achat;
        this.table = table;
    }
    
    public Achat getAchat() {
        return achat;
    }

    public void setAchat(Achat achat) {
        this.achat = achat;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    @Override
    public String toString() {
        return "CommandeTable{" + "achat=" + achat + ", table=" + table + '}';
    }

    

}
