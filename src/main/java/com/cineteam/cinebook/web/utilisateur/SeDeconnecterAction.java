package com.cineteam.cinebook.web.utilisateur;

import com.cineteam.cinebook.web.servlets.Action;
import javax.servlet.http.HttpServletRequest;

/** @author alexis */
public class SeDeconnecterAction implements Action
{

    public String execute(HttpServletRequest request) 
    {
        request.getSession().invalidate();
        String page_courante = request.getParameter("page_courante_avant_deco");
        page_courante = page_courante.substring(9, page_courante.length());
        return page_courante;
    }
    
}
