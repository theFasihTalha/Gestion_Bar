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
public class Ligne {
    private String article;
    private int quantite;
    private Double prix;
    private Double remise;

    public Ligne(String article, int quantite, Double prix, Double remise) {
        this.article = article;
        this.quantite = quantite;
        this.prix = prix;
        this.remise = remise;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public Double getRemise() {
        return remise;
    }

    public void setRemise(Double remise) {
        this.remise = remise;
    }

    @Override
    public String toString() {
        return "Ligne{" + "article=" + article + ", quantite=" + quantite + ", prix=" + prix + ", remise=" + remise + '}';
    }
    
    
}
