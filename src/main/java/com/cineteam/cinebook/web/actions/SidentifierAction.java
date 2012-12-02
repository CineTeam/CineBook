package com.cineteam.cinebook.web.actions;

import com.cineteam.cinebook.outils.StringUtils;
import javax.servlet.http.HttpServletRequest;

/** @author Bérangère */
public class SidentifierAction implements Action{
    
    public SidentifierAction() 
    { }
    
    public String execute(HttpServletRequest request) 
    {
        String login = request.getParameter("login");
        String motDePasse = request.getParameter("motDePasse");
        
        if(StringUtils.estVide(login) || StringUtils.estVide(motDePasse))
        {
            request.setAttribute("echec_connexion", true);
        }
        else
        {
            request.setAttribute("echec_connexion", false);
            request.getSession().setAttribute("login", login);
        }
        return "index.jsp";
    }
    
}
