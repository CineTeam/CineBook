package com.cineteam.cinebook.testsUnitaires.web.actions.cinema;

import com.cineteam.cinebook.model.commentaire.ICommentaireCinemaEntityManager;
import com.cineteam.cinebook.model.commentaire.CommentaireCinema;
import java.util.ArrayList;
import java.util.List;

/** @author Berangere */
public class MockCommentaireCinemaEntityManager implements ICommentaireCinemaEntityManager{
    
    public List<CommentaireCinema> commentaires_cinema = new ArrayList<CommentaireCinema>();
    public boolean commentaire_cinemaCree = false;
    
    public void creerCommentaire_Cinema(CommentaireCinema commentaire_cinema) {
        commentaire_cinemaCree = true;
        commentaires_cinema.add(commentaire_cinema);
    }

    public List<CommentaireCinema> rechercherCommentaires_cinema(String id_cinema) {
        List<CommentaireCinema> resultat = new ArrayList<CommentaireCinema>(); 
        for(CommentaireCinema commentaire_cinema : commentaires_cinema)
            if(commentaire_cinema.getId_cinema().equals(id_cinema))
                resultat.add(commentaire_cinema);
        return resultat;     
    }
   
}
