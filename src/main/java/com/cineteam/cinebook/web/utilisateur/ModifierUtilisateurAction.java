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
             
        utilisateur.setAdresse(request.getParameter("adresse"));
        utilisateur.setCode_postal(request.getParameter("code_postal"));
        utilisateur.setVille(request.getParameter("ville"));

        entityManager.modifierUtilisateur(utilisateur);
        
        return "profilUtilisateur.jsp";
    }
  
    
}
