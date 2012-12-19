package com.cineteam.cinebook.web.film;

import com.cineteam.cinebook.model.film.Film;
import com.cineteam.cinebook.model.film.FilmVu;
import com.cineteam.cinebook.model.film.IFilmProvider;
import com.cineteam.cinebook.model.film.IFilmVuEntityManager;
import com.cineteam.cinebook.model.utilisateur.Utilisateur;
import com.cineteam.cinebook.web.servlets.Action;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/** @author Ikram */
public class RecupererFilmsVusAction implements Action {

    private IFilmProvider provider;
    private IFilmVuEntityManager em;
        
    public RecupererFilmsVusAction(IFilmProvider _provider, IFilmVuEntityManager _em) {
        provider = _provider;
        em = _em;
    }

    public String execute(HttpServletRequest request) {
        List<Film> filmsVus = new ArrayList<Film>();
        Utilisateur utilisateur = (Utilisateur) request.getSession().getAttribute("utilisateur");
               
        if(utilisateur!=null){
            List<FilmVu> filmsVusParIds = em.rechercherFilmsVus(utilisateur.getId());
            if(!filmsVusParIds.isEmpty())
            {
                filmsVus = provider.getFilmsParIds(filmsVusParIds);
            }
        }
        request.setAttribute("type", "filmsVus");
        request.setAttribute("films", filmsVus);           
        return "listeFilms.jsp";   
    }
  
}
