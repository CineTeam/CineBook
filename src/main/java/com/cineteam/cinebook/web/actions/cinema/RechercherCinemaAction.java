package com.cineteam.cinebook.web.actions.cinema;

import com.cineteam.cinebook.model.entity.Cinema;
import com.cineteam.cinebook.model.provider.cinema.ICinemaProvider;
import com.cineteam.cinebook.outils.StringUtils;
import com.cineteam.cinebook.web.actions.Action;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/** @author Bérangère */
public class RechercherCinemaAction implements Action{

    private ICinemaProvider provider ; 
    
    public RechercherCinemaAction(ICinemaProvider _provider) 
    {
        provider = _provider;
    }
    
    public String execute(HttpServletRequest request) {

        String cinema_recherche = (String) request.getParameter("recherche");
        if(!StringUtils.estVide(cinema_recherche)){
            List<Cinema> cinemasParMotCle = provider.rechercherCinemasParMotCle(cinema_recherche);
            request.setAttribute("cinemas", cinemasParMotCle);       
        }    
        return "listeCinemas.jsp";

    }
    
}
