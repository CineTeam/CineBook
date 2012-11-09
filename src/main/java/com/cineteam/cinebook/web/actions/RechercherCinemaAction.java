package com.cineteam.cinebook.web.actions;

import com.cineteam.cinebook.model.entity.Cinema;
import com.cineteam.cinebook.model.provider.cinema.CinemaProvider;
import com.cineteam.cinebook.model.provider.cinema.ICinemaProvider;
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
        if(!cinema_recherche.isEmpty()){
            
            List<Cinema> cinemasParNom = provider.getCinemasParNom(cinema_recherche);
            request.setAttribute("cinemasParNom", cinemasParNom);           
            return "listeCinemas.jsp";
        }
        else{
            return "accueilCinema.jsp";
        }
  
    }
    
}
