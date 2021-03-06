package com.cineteam.cinebook.testsUnitaires.web.actions.cinema;

import com.cineteam.cinebook.model.commentaire.CommentaireCinema;
import com.cineteam.cinebook.model.commentaire.ICommentaireCinemaEntityManager;
import java.util.ArrayList;
import java.util.List;

/** @author Berangere */
public class MockCommentaireCinemaEntityManager implements ICommentaireCinemaEntityManager{
    
    public List<CommentaireCinema> commentaires_cinema = new ArrayList<CommentaireCinema>();
    public boolean commentaire_cinemaCree = false;
    public boolean commentaire_cinemaSupprime = false;
    
    public void creerCommentaire_Cinema(CommentaireCinema commentaire_cinema) 
    {
        commentaire_cinemaCree = true;
        commentaires_cinema.add(commentaire_cinema);
    }

    public List<CommentaireCinema> rechercherCommentaires_cinema(String id_cinema) 
    {
        List<CommentaireCinema> resultat = new ArrayList<CommentaireCinema>(); 
        for(CommentaireCinema commentaire_cinema : commentaires_cinema)
            if(commentaire_cinema.getId_cinema().equals(id_cinema))
                resultat.add(commentaire_cinema);
        return resultat;     
    }

    public void supprimerCommentairesCinemaDeLUtilisateur(Long id_utilisateur) 
    {
        commentaire_cinemaSupprime = true;
        List<CommentaireCinema> commentairesCinemaASupprimer = new ArrayList<CommentaireCinema>(); 
        for(CommentaireCinema commentaire_cinema : commentaires_cinema)
            if(commentaire_cinema.getUtilisateur().getId().equals(id_utilisateur))
                commentairesCinemaASupprimer.add(commentaire_cinema);
        
        for(CommentaireCinema commentaire_cinema : commentairesCinemaASupprimer)
            commentaires_cinema.remove(commentaire_cinema);
    }
   
}
