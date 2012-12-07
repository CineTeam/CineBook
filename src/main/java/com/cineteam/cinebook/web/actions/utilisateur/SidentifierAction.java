package com.cineteam.cinebook.web.actions.utilisateur;

import com.cineteam.cinebook.model.entitymanager.utilisateur.IUtilisateurEntityManager;
import com.cineteam.cinebook.model.entity.Utilisateur;
import com.cineteam.cinebook.outils.StringUtils;
import com.cineteam.cinebook.web.actions.Action;
import javax.servlet.http.HttpServletRequest;

/** @author Bérangère */
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
        
        String page_courante = request.getParameter("page_courante");
        page_courante = page_courante.substring(9, page_courante.length());
        return page_courante;
    }
    
}
