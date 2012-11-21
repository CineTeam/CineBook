package com.cineteam.cinebook.web.actions;

import com.cineteam.cinebook.model.entity.Film;
import com.cineteam.cinebook.model.provider.film.IFilmProvider;
import javax.servlet.http.HttpServletRequest;

/** @author Vivien */
public class ConsulterDetailFilmAction implements Action {
    
    private IFilmProvider provider;

    public ConsulterDetailFilmAction(IFilmProvider _provider) {
        provider = _provider;
    }

    public String execute(HttpServletRequest request) {
        String index_film = (String) request.getParameter("cpt");
        if(!index_film.isEmpty()){
            Film film = provider.getDetailFilm(index_film);
            request.setAttribute("film", film);       
        }    
        
        return "detailFilm.jsp";
    }
    
}
