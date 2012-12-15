package com.cineteam.cinebook.web.film;

import com.cineteam.cinebook.model.film.FilmVu;
import com.cineteam.cinebook.model.film.IFilmVuEntityManager;
import com.cineteam.cinebook.model.utilisateur.Utilisateur;
import com.cineteam.cinebook.outils.StringUtils;
import com.cineteam.cinebook.web.servlets.Action;
import javax.servlet.http.HttpServletRequest;

/** @author Bérangère */
public class AjouterFilmAuxFilmsVusAction implements Action{

    private IFilmVuEntityManager entityManager;
    
    public AjouterFilmAuxFilmsVusAction(IFilmVuEntityManager _entityManager)
    {
        entityManager = _entityManager;
    }
    
    
    public String execute(HttpServletRequest request) {
        
        String indexFilm = (String) request.getParameter("cpt");
        String CP_recherche = (String) request.getParameter("code_postal");
        Utilisateur utilisateur = (Utilisateur) request.getSession().getAttribute("utilisateur");
        
        if(!StringUtils.estVide(indexFilm) && utilisateur!=null){
            FilmVu filmVu = new FilmVu();
            filmVu.setId_film(indexFilm);
            filmVu.setId_utilisateur(utilisateur.getId());
            entityManager.enregistrerFilmVu(filmVu);
        }
        
        //inclure les input au form du boutton dans la jsp
        //<input type="hidden" name="cpt" value="${requestScope.film.id}" />
        //<input type="hidden" name="code_postal" value="${requestScope.code_postal}" />
        return "ServletVisiteur?action=consulterDetailFilmAction&cpt="+indexFilm+"&recherche="+CP_recherche;
    }
    
}
