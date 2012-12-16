package com.cineteam.cinebook.model.commentaire;

import java.util.List;

/** @author alexis */
public interface ICommentaireFilmEntityManager 
{
    public void creerCommentaireFilm(CommentaireFilm commentaireFilm);
    public List<CommentaireFilm> rechercherCommentairesFilm(String idFilm);
    public void supprimerCommentaireFilmDeLUtilisateur(Long id_utilisateur);
}
