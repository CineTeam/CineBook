package com.cineteam.cinebook.web.cinema;

import com.cineteam.cinebook.model.cinema.Cinema;
import com.cineteam.cinebook.model.cinema.ICinemaProvider;
import com.cineteam.cinebook.outils.StringUtils;
import com.cineteam.cinebook.web.servlets.Action;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/** @author Bérangère */
public class RechercherCinemaParCPAction implements Action{

    private ICinemaProvider provider ; 
    
    public RechercherCinemaParCPAction(ICinemaProvider _provider) 
    {
        provider = _provider;
    }
    
    public String execute(HttpServletRequest request) {

        String cinema_recherche = (String) request.getParameter("recherche");
        if(!StringUtils.estVide(cinema_recherche)){
            List<Cinema> cinemasParCP = provider.rechercherCinemasParCodePostal(cinema_recherche);
            request.setAttribute("cinemas", cinemasParCP);       
        }    
        return "listeCinemas.jsp";

    }
    
}
