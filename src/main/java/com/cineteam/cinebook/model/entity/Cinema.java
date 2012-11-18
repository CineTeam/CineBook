package com.cineteam.cinebook.model.entity;

/** @author alexis */
public class Cinema 
{
    private String id;
    private String nom;
    private String adresse;
    private String code_postal;
    private String ville;
    private int nombre_ecrans;
    private Geolocalisation position;
    private String url_image;
    
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

    public int getNombre_ecrans() {
        return nombre_ecrans;
    }

    public void setNombre_ecrans(int _nombre_ecrans) {
        nombre_ecrans = _nombre_ecrans;
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
}
