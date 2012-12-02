package com.cineteam.cinebook.web.actions;

import com.cineteam.cinebook.outils.StringUtils;
import javax.servlet.http.HttpServletRequest;

/** @author alexis */
public class SinscrireAction implements Action
{
  
    public String execute(HttpServletRequest request)
    {
        String login = request.getParameter("login");
        String motDePasse = request.getParameter("motDePasse");
        String motDePasseConfirmation = request.getParameter("motDePasseConfirmation");
        String messageDerreur =null;
        
        if(StringUtils.estVide(login) || StringUtils.estVide(motDePasse) || StringUtils.estVide(motDePasseConfirmation) )
        {
            messageDerreur = "Veuillez renseigner tous les champs.";
        }
        else if(!motDePasse.equals(motDePasseConfirmation))
        {
            messageDerreur = "Les mots de passe saisies ne correspondent pas.";
        }    
        else
        {
            request.setAttribute("echec_inscription", false);
            request.getSession().setAttribute("login", login);
        }
       
        if (messageDerreur != null)
        {
            request.setAttribute("echec_inscription", true);
            request.setAttribute("erreur", messageDerreur);
            return "inscription.jsp";
        }   
        return "index.jsp";
    }
    
}
