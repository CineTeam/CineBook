package com.cineteam.cinebook.web.utilisateur;

import com.cineteam.cinebook.web.servlets.Action;
import javax.servlet.http.HttpServletRequest;

/** @author alexis */
public class SeDeconnecterAction implements Action
{

    public String execute(HttpServletRequest request) 
    {
        request.getSession().invalidate();
        return "ServletVisiteur?action=redirigerAction";
    }
    
}
