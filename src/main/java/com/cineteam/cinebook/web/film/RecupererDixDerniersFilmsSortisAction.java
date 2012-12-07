package com.cineteam.cinebook.web.film;

import com.cineteam.cinebook.model.film.Film;
import com.cineteam.cinebook.model.film.IFilmProvider;
import com.cineteam.cinebook.web.servlets.Action;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/** @author Cedric */
public class RecupererDixDerniersFilmsSortisAction implements Action {

    private IFilmProvider provider;
    
    public RecupererDixDerniersFilmsSortisAction(IFilmProvider _provider) {
        provider = _provider;
    }

    public String execute(HttpServletRequest request) {
        
        List<Film> derniersFilmsSortis = provider.getDixDerniersFilms();
        request.setAttribute("derniersFilmsSortis", derniersFilmsSortis);           
        return "accueilFilm.jsp";
        
    }
     
}
