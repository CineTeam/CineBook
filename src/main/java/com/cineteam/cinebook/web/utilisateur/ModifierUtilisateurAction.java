package com.cineteam.cinebook.web.utilisateur;

import com.cineteam.cinebook.model.utilisateur.IUtilisateurEntityManager;
import com.cineteam.cinebook.model.utilisateur.Utilisateur;
import com.cineteam.cinebook.outils.StringUtils;
import com.cineteam.cinebook.web.servlets.Action;
import javax.servlet.http.HttpServletRequest;

/** @author ikram */
public class ModifierUtilisateurAction implements Action{
      private IUtilisateurEntityManager entityManager;

    public ModifierUtilisateurAction(IUtilisateurEntityManager _entityManager) {
        entityManager = _entityManager;
    }
    
    public String execute(HttpServletRequest request)
    {
        Utilisateur utilisateur = (Utilisateur) request.getSession().getAttribute("utilisateur");
        String adresse = request.getParameter("adresse");
        String code_postal = request.getParameter("code_postal");
        String ville = request.getParameter("ville");
        
        if(!StringUtils.estVide(adresse) || !StringUtils.estVide(code_postal) || !StringUtils.estVide(ville)){
            utilisateur.setAdresse(adresse);
            utilisateur.setCode_postal(code_postal);
            utilisateur.setVille(ville);
            
            entityManager.modifierUtilisateur(utilisateur);
            
            request.getSession().setAttribute("utilisateur", utilisateur);
        }
        
        return "profilUtilisateur.jsp";
    }

}
