package com.cineteam.cinebook.model.film;
import java.util.Date;
import java.util.List;

/** @author alexis */
public class Film {

    private String id;
    private String titre;
    private Date date_sortie;
    private String realisateur;
    private String acteurs;
    private float note_utilisateurs;
    private float note_presse;
    private String url_affiche;
    private String url_bande_annonce;
    private String duree;
    private List<String> pays;
    private List<String> genres;
    private String synopsis;
            
    public String getId() {
        return id;
    }
    
    public void setId(String _id) {
        id = _id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String _titre) {
        titre = _titre;
    }

    public Date getDate_sortie() {
        return date_sortie;
    }

    public void setDate_sortie(Date _date_sortie) {
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

    public String getDuree() {
        return duree;
    }

    public void setDuree(String _duree) {
        duree = _duree;
    }

    public List<String> getPays() {
        return pays;
    }

    public void setPays(List<String> _pays) {
        pays = _pays;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> _genres) {
        genres = _genres;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String _synopsis) {
        synopsis = _synopsis;
    }

    public String getUrl_bande_annonce() {
        return url_bande_annonce;
    }

    public void setUrl_bande_annonce(String url_bande_annonce) {
        this.url_bande_annonce = url_bande_annonce;
    }
    
}
