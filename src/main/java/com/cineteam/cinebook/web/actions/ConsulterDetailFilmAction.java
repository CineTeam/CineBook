package com.cineteam.cinebook.web.actions;

import com.cineteam.cinebook.model.entity.Cinema;
import com.cineteam.cinebook.model.entity.Film;
import com.cineteam.cinebook.model.provider.film.IFilmProvider;
import com.cineteam.cinebook.model.provider.seance.ISeanceProvider;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/** @author Vivien */
public class ConsulterDetailFilmAction implements Action {
    
    private IFilmProvider providerFilm;
    private ISeanceProvider providerSeance;

    public ConsulterDetailFilmAction(IFilmProvider _providerFilm,ISeanceProvider _providerSeance) {
        providerFilm = _providerFilm;
        providerSeance = _providerSeance;
    }

    public String execute(HttpServletRequest request) {
        
        String index_film = (String) request.getParameter("cpt");
        if(!index_film.isEmpty()){
            Film film = providerFilm.getDetailFilm(index_film);
            request.setAttribute("film", film);       
        }    
        
        String CP_recherche = (String) request.getParameter("recherche");
        if(CP_recherche!=null){
            if(!CP_recherche.isEmpty()){
                List<Cinema> cinemasParCP = providerSeance.getSeancesPourUnFilm(index_film,CP_recherche);
                request.setAttribute("cinemas", cinemasParCP);       
            }    
        }
            
        return "detailFilm.jsp";
    }
    
}
