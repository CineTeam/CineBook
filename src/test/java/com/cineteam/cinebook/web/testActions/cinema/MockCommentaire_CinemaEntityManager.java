package com.cineteam.cinebook.web.testActions.cinema;

import com.cineteam.cinebook.entitymanager.commentaire_cinema.ICommentaire_CinemaEntityManager;
import com.cineteam.cinebook.model.entity.Commentaire_cinema;
import java.util.ArrayList;
import java.util.List;

/** @author Berangere */
public class MockCommentaire_CinemaEntityManager implements ICommentaire_CinemaEntityManager{
    
    public List<Commentaire_cinema> commentaires_cinema = new ArrayList<Commentaire_cinema>();
    public boolean commentaire_cinemaCree = false;
    
    public void creerCommentaire_Cinema(Commentaire_cinema commentaire_cinema) {
        commentaire_cinemaCree = true;
        commentaires_cinema.add(commentaire_cinema);
    }

    public List<Commentaire_cinema> rechercherCommentaires_cinema(String id_cinema) {
        List<Commentaire_cinema> resultat = new ArrayList<Commentaire_cinema>(); 
        for(Commentaire_cinema commentaire_cinema : commentaires_cinema)
            if(commentaire_cinema.getId_cinema().equals(id_cinema))
                resultat.add(commentaire_cinema);
        return resultat;     
    }
   
}
