package com.cineteam.cinebook.model.entity;

import java.util.Date;

/** @author Vivien */
public class Commentaire_cinema {
    
    protected Date date;
    protected Utilisateur utilisateur;
    protected String texte;
    protected Cinema cinema;

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
