package com.cineteam.cinebook.model.commentaire;

import com.cineteam.cinebook.model.utilisateur.Utilisateur;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/** @author Vivien */
@Entity
public class CommentaireCinema implements Serializable {
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    
    @Temporal(TemporalType.DATE)
    private Date date;
    
    @ManyToOne
    @JoinColumn(name="id_utilisateur")
    private Utilisateur utilisateur;
    
    private String texte;
    private String id_cinema;

    public Date getDate() {
        return date;
    }

    public void setDate(Date _date) {
        date = _date;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur _utilisateur) {
        utilisateur = _utilisateur;
    }
    
    public String getId_cinema() {
        return id_cinema;
    }

    public void setId_cinema(String _id_cinema) {
        id_cinema = _id_cinema;
    }

    public String getTexte() {
        return texte;
    }

    public void setTexte(String _texte) {
        texte = _texte;
    }
    
    
}
