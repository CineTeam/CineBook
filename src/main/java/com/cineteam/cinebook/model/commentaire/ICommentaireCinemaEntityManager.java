package com.cineteam.cinebook.model.commentaire;

import java.util.List;

/** @author Bérangère */
public interface ICommentaireCinemaEntityManager {
    
    public void creerCommentaire_Cinema(CommentaireCinema commentaire_cinema);
    public List<CommentaireCinema> rechercherCommentaires_cinema(String id_cinema);
    public void supprimerCommentairesCinemaDeLUtilisateur(Long id_utilisateur);
}
