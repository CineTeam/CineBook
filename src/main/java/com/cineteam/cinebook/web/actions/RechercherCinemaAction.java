package com.cineteam.cinebook.web.actions;

import javax.servlet.http.HttpServletRequest;

/** @author Bérangère */
public class RechercherCinemaAction implements Action{

    public RechercherCinemaAction() {}
    
    public String execute(HttpServletRequest request) {

        String cinema_recherche = (String) request.getParameter("recherche");
        if(!cinema_recherche.isEmpty()){
            return "listeCinemas.jsp";
        }
        else{
            return "accueilCinema.jsp";
        }
  
    }
    
}
