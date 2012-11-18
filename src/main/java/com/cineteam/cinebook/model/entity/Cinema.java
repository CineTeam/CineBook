package com.cineteam.cinebook.model.entity;
import com.cineteam.cinebook.outils.Geolocalisation;


/** @author alexis */
public class Cinema 
{
    private String id;
    private String nom;
    private String adresse;
    private String code_postal;
    private String ville;
    private int nombreEcrans;
    private Geolocalisation position;
    private String urlImage;
    
    public String getId()
    {
        return id;
    }
    
    public void setId(String _id)
    {
        id = _id;
    }
    
    public String getNom()
    {
        return nom;
    }
    
    public void setNom(String _nom)
    {
        nom = _nom;
    }
    
    public String getAdresse()
    {
        return adresse;
    }
    
    public void setAdresse(String _adresse)
    {
        adresse = _adresse;
    }
    public String getCode_postal()
    {
        return code_postal;
    }
    
    public void setCode_postal(String _code_postal)
    {
        code_postal = _code_postal;
    }
    
    public String getVille()
    {
        return ville;
    }
    
    public void setVille(String _ville)
    {
        ville = _ville;
    }

    public int getNombreEcrans() {
        return nombreEcrans;
    }

    public void setNombreEcrans(int nombreEcrans) {
        this.nombreEcrans = nombreEcrans;
    }

    public Geolocalisation getPosition() {
        return position;
    }

    public void setPosition(Geolocalisation position) {
        this.position = position;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }
}
