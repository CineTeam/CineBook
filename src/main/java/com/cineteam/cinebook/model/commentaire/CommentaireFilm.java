package com.cineteam.cinebook.model.commentaire;

import com.cineteam.cinebook.model.utilisateur.Utilisateur;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
/** @author alexis */

@Entity
public class CommentaireFilm implements Serializable
{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    
    @Temporal(TemporalType.DATE)
    private Date date;
    
    @ManyToOne
    @JoinColumn(name="id_utilisateur")
    private Utilisateur utilisateur;
    
    private String texte;
    private String id_film;

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
    
    public String getId_film() {
        return id_film;
    }

    public void setId_film(String _id_film) {
        id_film = _id_film;
    }

    public String getTexte() {
        return texte;
    }

    public void setTexte(String _texte) {
        texte = _texte;
    }
}
