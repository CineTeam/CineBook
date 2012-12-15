package com.cineteam.cinebook.model.film;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/** @author Bérangère */
@Entity
public class FilmVu implements Serializable {
    
    private static final long serialVersionUID = 1L;
        
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    
    private String id_film;
    
    private Long id_utilisateur;

    public Long getId() {
        return id;
    }

    public String getId_film() {
        return id_film;
    }

    public void setId_film(String _id_film) {
        id_film = _id_film;
    }

    public Long getId_utilisateur() {
        return id_utilisateur;
    }

    public void setId_utilisateur(Long _id_utilisateur) {
        id_utilisateur = _id_utilisateur;
    }
    
}
