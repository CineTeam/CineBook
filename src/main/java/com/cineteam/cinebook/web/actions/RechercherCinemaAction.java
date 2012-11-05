package com.cineteam.cinebook.web.actions;

import javax.servlet.http.HttpServletRequest;

/** @author Bérangère */
public class RechercherCinemaAction implements Action{

    public RechercherCinemaAction() {}
    
    public String execute(HttpServletRequest request) {

        return "listeCinemas.jsp";
  
    }
    
}
