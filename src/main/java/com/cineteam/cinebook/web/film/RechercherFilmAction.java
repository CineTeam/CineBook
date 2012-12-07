package com.cineteam.cinebook.web.film;

import com.cineteam.cinebook.model.film.Film;
import com.cineteam.cinebook.model.film.IFilmProvider;
import com.cineteam.cinebook.outils.StringUtils;
import com.cineteam.cinebook.web.servlets.Action;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/** @author Bérangère */
public class RechercherFilmAction implements Action{

    private IFilmProvider provider ; 
    
    public RechercherFilmAction(IFilmProvider _provider) 
    {
        provider = _provider;
    }
    
    public String execute(HttpServletRequest request) {

        String film_recherche = (String) request.getParameter("recherche");
        if(!StringUtils.estVide(film_recherche)){
            List<Film> filmsParMotCle = provider.rechercherFilmParMotCle(film_recherche);
            request.setAttribute("filmsParMotCle", filmsParMotCle);  
        }
        return "listeFilms.jsp";
 
    }
    
}
