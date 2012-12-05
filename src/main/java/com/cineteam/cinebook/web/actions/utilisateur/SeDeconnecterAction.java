package com.cineteam.cinebook.web.actions.utilisateur;

import com.cineteam.cinebook.web.actions.Action;
import javax.servlet.http.HttpServletRequest;

/** @author alexis */
public class SeDeconnecterAction implements Action
{

    public String execute(HttpServletRequest request) 
    {
        request.getSession().invalidate();
        return "index.jsp";
    }
    
}