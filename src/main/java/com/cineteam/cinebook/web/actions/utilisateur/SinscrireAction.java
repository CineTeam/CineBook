package com.cineteam.cinebook.web.actions.utilisateur;

import com.cineteam.cinebook.model.entitymanager.utilisateur.IUtilisateurEntityManager;
import com.cineteam.cinebook.model.entity.Utilisateur;
import com.cineteam.cinebook.outils.StringUtils;
import com.cineteam.cinebook.web.actions.Action;
import javax.servlet.http.HttpServletRequest;

/** @author alexis */
public class SinscrireAction implements Action {
  
    private IUtilisateurEntityManager entityManager;

    public SinscrireAction(IUtilisateurEntityManager _entityManager) {
        entityManager = _entityManager;
    }
    
    public String execute(HttpServletRequest request)
    {
        String pseudo = request.getParameter("pseudo");
        String login = request.getParameter("login");
        String mdp = request.getParameter("mdp");
        String mdpConfirmation = request.getParameter("mdpConfirmation");
        
        String messageErreur = null;
        
        if(StringUtils.estVide(pseudo) || StringUtils.estVide(login) || StringUtils.estVide(mdp) || StringUtils.estVide(mdpConfirmation))
        {
            messageErreur = "Veuillez renseigner tous les champs.";
            request.setAttribute("messageErreur", messageErreur);
            return "inscription.jsp";
        }
        else if(!mdp.equals(mdpConfirmation))
        {
            messageErreur = "Les mots de passe saisis ne correspondent pas.";
            request.setAttribute("messageErreur", messageErreur);
            return "inscription.jsp";
        }
        else if(entityManager.rechercherUtilisateur(login)!=null)
        {
            messageErreur = "Ce login est déjà utilisé.";
            request.setAttribute("messageErreur", messageErreur);
            return "inscription.jsp";
        }        
        else
        {
            Utilisateur utilisateur = new Utilisateur();
            utilisateur.setPseudo(pseudo);
            utilisateur.setLogin(login);
            utilisateur.setMdp(mdp);
            utilisateur.setId_droit(1);
            
            if(!StringUtils.estVide(request.getParameter("adresse")))
                utilisateur.setAdresse(request.getParameter("adresse"));
            if(!StringUtils.estVide(request.getParameter("code_postal")))
                utilisateur.setCode_postal(request.getParameter("code_postal"));
            if(!StringUtils.estVide(request.getParameter("ville")))
                utilisateur.setVille(request.getParameter("ville"));
       
            entityManager.creerUtilisateur(utilisateur);
            request.setAttribute("messageErreur", messageErreur);
            return "index.jsp";
        }
       
    }
    
}
