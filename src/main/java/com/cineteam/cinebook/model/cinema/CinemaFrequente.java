package com.cineteam.cinebook.model.cinema;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/** @author Bérangère */
@Entity
public class CinemaFrequente implements Serializable {
    
    private static final long serialVersionUID = 1L;
        
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    
    private String id_cinema;
    
    private Long id_utilisateur;

    public Long getId() {
        return id;
    }

    public String getId_cinema() {
        return id_cinema;
    }

    public void setId_cinema(String _id_cinema) {
        id_cinema = _id_cinema;
    }

    public Long getId_utilisateur() {
        return id_utilisateur;
    }

    public void setId_utilisateur(Long _id_utilisateur) {
        id_utilisateur = _id_utilisateur;
    }
    
}
