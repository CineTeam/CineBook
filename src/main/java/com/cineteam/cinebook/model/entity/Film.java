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

    public void setTitre(String Titre) {
        this.titre = Titre;
    }

    public DateTime getDate_sortie() {
        return date_sortie;
    }

    public void setDate_sortie(DateTime date_sortie) {
        this.date_sortie = date_sortie;
    }

    public String getRealisateur() {
        return realisateur;
    }

    public void setRealisateur(String realisateur) {
        this.realisateur = realisateur;
    }

    public String getActeurs() {
        return acteurs;
    }

    public void setActeurs(String acteurs) {
        this.acteurs = acteurs;
    }

    public float getNote_utilisateurs() {
        return note_utilisateurs;
    }

    public void setNote_utilisateurs(float note_utilisateurs) {
        this.note_utilisateurs = note_utilisateurs;
    }

    public float getNote_presse() {
        return note_presse;
    }

    public void setNote_presse(float note_presse) {
        this.note_presse = note_presse;
    }

    public String getUrl_affiche() {
        return url_affiche;
    }

    public void setUrl_affiche(String url_affiche) {
        this.url_affiche = url_affiche;
    }
    
}
