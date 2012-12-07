package com.cineteam.cinebook.model.commentaireCinema;

import java.util.List;

/** @author Bérangère */
public interface ICommentaire_CinemaEntityManager {
    
    public void creerCommentaire_Cinema(Commentaire_cinema commentaire_cinema);
    public List<Commentaire_cinema> rechercherCommentaires_cinema(String id_cinema);

}
