package com.cineteam.cinebook.model.entity;

import java.util.Date;

/** @author Vivien */
public class Commentaire_film {
    
    protected Date date;
    protected Utilisateur utilisateur;
    protected String texte;
    protected Film film;

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
    
    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }
    
    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }
    
}
