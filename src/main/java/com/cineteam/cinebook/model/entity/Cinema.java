package com.cineteam.cinebook.model.entity;

import java.util.List;

/** @author alexis */
public class Cinema 
{
    private String id;
    private String nom;
    private String adresse;
    private String code_postal;
    private String ville;
    private int nombre_salles;
    private Geolocalisation position;
    private String url_image;
    private List<Seances_film> seances_films;

    public String getId() {
        return id;
    }
    
    public void setId(String _id) {
        id = _id;
    }
    
    public String getNom() {
        return nom;
    }
    
    public void setNom(String _nom) {
        nom = _nom;
    }
    
    public String getAdresse() {
        return adresse;
    }
    
    public void setAdresse(String _adresse) {
        adresse = _adresse;
    }
    
    public String getCode_postal() {
        return code_postal;
    }
    
    public void setCode_postal(String _code_postal) {
        code_postal = _code_postal;
    }
    
    public String getVille() {
        return ville;
    }
    
    public void setVille(String _ville) {
        ville = _ville;
    }

    public int getNombre_salles() {
        return nombre_salles;
    }

    public void setNombre_salles(int _nombre_salles) {
        nombre_salles = _nombre_salles;
    }

    public Geolocalisation getPosition() {
        return position;
    }

    public void setPosition(Geolocalisation _position) {
        position = _position;
    }

    public String getUrl_image() {
        return url_image;
    }

    public void setUrl_image(String _url_image) {
        url_image = _url_image;
    }
    
    public List<Seances_film> getSeances_films() {
        return seances_films;
    }

    public void setSeances_films(List<Seances_film> _seances_films) {
        seances_films = _seances_films;
    }
    
}
