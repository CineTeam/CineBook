package com.cineteam.cinebook.web.utilisateur;

import com.cineteam.cinebook.model.commentaire.ICommentaireCinemaEntityManager;
import com.cineteam.cinebook.model.commentaire.ICommentaireFilmEntityManager;
import com.cineteam.cinebook.model.film.IFilmVuEntityManager;
import com.cineteam.cinebook.model.utilisateur.IUtilisateurEntityManager;
import com.cineteam.cinebook.model.utilisateur.Utilisateur;
import com.cineteam.cinebook.web.servlets.Action;
import javax.servlet.http.HttpServletRequest;

/** @author Cedric */
public class SupprimerUtilisateurAction implements Action{
    
    private IUtilisateurEntityManager entityManager;
    private ICommentaireFilmEntityManager entityManagerFilm;
    private ICommentaireCinemaEntityManager entityManagerCinema;
    private IFilmVuEntityManager entityManagerFilmVu;
    
    public SupprimerUtilisateurAction(IUtilisateurEntityManager _entityManager, ICommentaireFilmEntityManager _entityManagerFilm, ICommentaireCinemaEntityManager _entityManagerCinema, IFilmVuEntityManager _entityManagerFilmVu) {
        entityManager = _entityManager;
        entityManagerFilm = _entityManagerFilm;
        entityManagerCinema = _entityManagerCinema;
        entityManagerFilmVu = _entityManagerFilmVu;
    }
    
    public String execute(HttpServletRequest request) 
    {
        Utilisateur utilisateur = (Utilisateur)request.getSession().getAttribute("utilisateur");
        
        entityManagerFilm.supprimerCommentaireFilmDeLUtilisateur(utilisateur.getId());
        entityManagerCinema.supprimerCommentairesCinemaDeLUtilisateur(utilisateur.getId());
        entityManagerFilmVu.supprimerFilmsVus(utilisateur.getId());
        
        entityManager.supprimerUtilisateur(utilisateur.getId());
        request.getSession().invalidate();
        
        return "index.jsp";
    }
}
