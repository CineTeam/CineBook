package com.cineteam.cinebook.entitymanager.commentaire_cinema;

import com.cineteam.cinebook.model.entity.Commentaire_cinema;
import java.util.List;

/** @author Bérangère */
public interface ICommentaire_CinemaEntityManager {
    
    public void creerCommentaire_Cinema(Commentaire_cinema commentaire_cinema);
    public List<Commentaire_cinema> rechercherCommentaires_cinema(String id_cinema);

}
