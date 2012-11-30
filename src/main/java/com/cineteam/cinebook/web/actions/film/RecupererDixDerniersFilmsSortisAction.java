package com.cineteam.cinebook.web.actions.film;

import com.cineteam.cinebook.model.entity.Film;
import com.cineteam.cinebook.model.provider.film.IFilmProvider;
import com.cineteam.cinebook.web.actions.Action;
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
