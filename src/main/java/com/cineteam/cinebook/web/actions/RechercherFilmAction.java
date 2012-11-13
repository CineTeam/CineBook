package com.cineteam.cinebook.web.actions;

import com.cineteam.cinebook.model.entity.Film;
import com.cineteam.cinebook.model.provider.film.IFilmProvider;
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
        if(!film_recherche.isEmpty()){
            List<Film> filmsParNom = provider.getFilmsParNom(film_recherche);
            request.setAttribute("filmsParNom", filmsParNom);  
        }
        return "listeFilms.jsp";
 
    }
    
}
