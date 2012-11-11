package com.cineteam.cinebook.model.entity;

import org.joda.time.DateTime;

/** @author alexis */
public class Film {

    private String id;
    private String titre;
    private DateTime date_sortie;
    private String realisateur;
    private String acteurs;
    private float note_utilisateurs;
    private float note_presse;
    private String url_affiche;
            
    public String getId()
    {
        return id;
    }
    
    public void setId(String _id)
    {
        id = _id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String _titre) {
        titre = _titre;
    }

    public DateTime getDate_sortie() {
        return date_sortie;
    }

    public void setDate_sortie(DateTime _date_sortie) {
        date_sortie = _date_sortie;
    }

    public String getRealisateur() {
        return realisateur;
    }

    public void setRealisateur(String _realisateur) {
        realisateur = _realisateur;
    }

    public String getActeurs() {
        return acteurs;
    }

    public void setActeurs(String _acteurs) {
        acteurs = _acteurs;
    }

    public float getNote_utilisateurs() {
        return note_utilisateurs;
    }

    public void setNote_utilisateurs(float _note_utilisateurs) {
        note_utilisateurs = _note_utilisateurs;
    }

    public float getNote_presse() {
        return note_presse;
    }

    public void setNote_presse(float _note_presse) {
        note_presse = _note_presse;
    }

    public String getUrl_affiche() {
        return url_affiche;
    }

    public void setUrl_affiche(String _url_affiche) {
        url_affiche = _url_affiche;
    }
    
}
