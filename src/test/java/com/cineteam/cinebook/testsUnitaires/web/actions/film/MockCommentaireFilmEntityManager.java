package com.cineteam.cinebook.testsUnitaires.web.actions.film;

import com.cineteam.cinebook.model.commentaire.CommentaireFilm;
import com.cineteam.cinebook.model.commentaire.ICommentaireFilmEntityManager;
import java.util.ArrayList;
import java.util.List;

/* @author alexis */
public class MockCommentaireFilmEntityManager  implements ICommentaireFilmEntityManager
{
    public List<CommentaireFilm> commentairesFilm = new ArrayList<CommentaireFilm>();
    public boolean commentaireFilmCree = false;
    
    public void creerCommentaireFilm(CommentaireFilm commentaireFilm) 
    {
        commentaireFilmCree = true;
        commentairesFilm.add(commentaireFilm);
    }

    public List<CommentaireFilm> rechercherCommentairesFilm(String idFilm)
    {
        List<CommentaireFilm> resultat = new ArrayList<CommentaireFilm>(); 
        for(CommentaireFilm commentaireFilm : commentairesFilm)
            if(commentaireFilm.getId_film().equals(idFilm))
                resultat.add(commentaireFilm);
        return resultat;
    }

    public void supprimerCommentaireFilmDeLUtilisateur(Long id_utilisateur) 
    {
        List<CommentaireFilm> filmsASupprimer = new ArrayList<CommentaireFilm>();
        for(CommentaireFilm commentaireFilm : commentairesFilm)
            if(commentaireFilm.getUtilisateur().getId().equals(id_utilisateur))
                filmsASupprimer.add(commentaireFilm);
        
        for(CommentaireFilm commentaireFilm : filmsASupprimer)
            commentairesFilm.remove(commentaireFilm);
    }
}
