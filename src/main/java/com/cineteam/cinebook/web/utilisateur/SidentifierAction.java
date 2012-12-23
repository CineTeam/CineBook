package com.cineteam.cinebook.web.utilisateur;

import com.cineteam.cinebook.model.utilisateur.IUtilisateurEntityManager;
import com.cineteam.cinebook.model.utilisateur.Utilisateur;
import com.cineteam.cinebook.outils.StringUtils;
import com.cineteam.cinebook.web.servlets.Action;
import javax.servlet.http.HttpServletRequest;

/** @author Berangere */
public class SidentifierAction implements Action{
    
    private IUtilisateurEntityManager entityManager;

    public SidentifierAction(IUtilisateurEntityManager _entityManager) {
        entityManager = _entityManager;
    }
    
    public String execute(HttpServletRequest request) 
    {
        String login = request.getParameter("login");
        String motDePasse = request.getParameter("mdp");
        Utilisateur utilisateur = entityManager.rechercherUtilisateur(login);
        
        if(StringUtils.estVide(login) || StringUtils.estVide(motDePasse) || utilisateur==null || !utilisateur.getMdp().equals(motDePasse))
        {
            request.setAttribute("echec_connexion", true);
        }     
        else
        {
            request.setAttribute("echec_connexion", false);
            request.getSession().setAttribute("utilisateur", utilisateur);
        }
        return "ServletVisiteur?action=redirigerAction";
    }
    
}
