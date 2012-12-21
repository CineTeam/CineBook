package com.cineteam.cinebook.web.utilisateur;

import com.cineteam.cinebook.model.cinema.ICinemaFrequenteEntityManager;
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
    private ICommentaireFilmEntityManager entityManagerCommentaireFilm;
    private ICommentaireCinemaEntityManager entityManagerCommentaireCinema;
    private IFilmVuEntityManager entityManagerFilmVu;
    private ICinemaFrequenteEntityManager entityManagerCinemaFrequente;
    
    public SupprimerUtilisateurAction(IUtilisateurEntityManager _entityManager, ICommentaireFilmEntityManager _entityManagerCommentaireFilm, ICommentaireCinemaEntityManager _entityManagerCommentaireCinema, IFilmVuEntityManager _entityManagerFilmVu, ICinemaFrequenteEntityManager _entityManagerCinemaFrequente) 
    {
        entityManager = _entityManager;
        entityManagerCommentaireFilm = _entityManagerCommentaireFilm;
        entityManagerCommentaireCinema = _entityManagerCommentaireCinema;
        entityManagerFilmVu = _entityManagerFilmVu;
        entityManagerCinemaFrequente = _entityManagerCinemaFrequente;
    }
    
    public String execute(HttpServletRequest request) 
    {
        Utilisateur utilisateur = (Utilisateur)request.getSession().getAttribute("utilisateur");
        
        if(utilisateur!=null){
            entityManagerCommentaireFilm.supprimerCommentaireFilmDeLUtilisateur(utilisateur.getId());
            entityManagerCommentaireCinema.supprimerCommentairesCinemaDeLUtilisateur(utilisateur.getId());
            entityManagerFilmVu.supprimerFilmsVus(utilisateur.getId());
            entityManagerCinemaFrequente.supprimerCinemasFrequentes(utilisateur.getId());
            entityManager.supprimerUtilisateur(utilisateur.getId());
        }
        
        request.getSession().invalidate();
        return "index.jsp";
    }
}
