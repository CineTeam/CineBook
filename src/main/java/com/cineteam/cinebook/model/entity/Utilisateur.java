package com.cineteam.cinebook.model.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/** @author Bérangère */
@Entity
public class Utilisateur implements Serializable {
    
    private static final long serialVersionUID = 1L;
        
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String pseudo;
    private String login;
    private String mdp;
    private String adresse;
    private String code_postal;
    private String ville;
    private int id_droit;

    public Long getId() {
        return id;
    }
    
    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCode_postal() {
        return code_postal;
    }

    public void setCode_postal(String code_postal) {
        this.code_postal = code_postal;
    }

    public int getId_droit() {
        return id_droit;
    }

    public void setId_droit(int id_droit) {
        this.id_droit = id_droit;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }
    
    
    
    
}
