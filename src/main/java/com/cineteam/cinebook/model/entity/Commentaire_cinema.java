/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cineteam.cinebook.model.entity;

import java.util.Date;

/**
 *
 * @author Vivien
 */
public class Commentaire_cinema {
    protected Date date;
    protected Utilisateur utilisateur;
    protected String texte;
    protected Cinema cinema;

    public Commentaire_cinema() {
    }

    public Commentaire_cinema(Date date, Utilisateur utilisateur, String texte, Cinema cinema) {
        this.date = date;
        this.utilisateur = utilisateur;
        this.texte = texte;
        this.cinema = cinema;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
    
    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }
    
    
}
