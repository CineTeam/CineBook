package com.cineteam.cinebook.web.actions;

import com.cineteam.cinebook.model.entity.Film;
import com.cineteam.cinebook.model.provider.film.IFilmProvider;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Cedric
 */
public class RecupererLesDixDerniersFilmsSortisAction implements Action {

    private IFilmProvider provider;
    
    public RecupererLesDixDerniersFilmsSortisAction(IFilmProvider _provider) {
        provider = _provider;
    }

    public String execute(HttpServletRequest request) {
        
        List<Film> derniersFilmsSortis = provider.getDixDerniersFilms();
        request.setAttribute("derniersFilmsSortis", derniersFilmsSortis);           
        
        return "accueilFilm.jsp";
        
    }
    
    
}
