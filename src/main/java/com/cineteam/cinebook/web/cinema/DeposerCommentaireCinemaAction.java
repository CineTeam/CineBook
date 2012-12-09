package com.cineteam.cinebook.web.cinema;

import com.cineteam.cinebook.model.commentaire.CommentaireCinema;
import com.cineteam.cinebook.model.commentaire.ICommentaireCinemaEntityManager;
import com.cineteam.cinebook.model.utilisateur.Utilisateur;
import com.cineteam.cinebook.outils.StringUtils;
import com.cineteam.cinebook.web.servlets.Action;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;

/** @author Cedric */
public class DeposerCommentaireCinemaAction implements Action {

    private ICommentaireCinemaEntityManager entityManager;
    
    public DeposerCommentaireCinemaAction(ICommentaireCinemaEntityManager _entityManager) {
        entityManager = _entityManager;
    }
    
    public String execute(HttpServletRequest request) {
        String index_cinema = (String) request.getParameter("cpt");
        Utilisateur utilisateur = (Utilisateur) request.getSession().getAttribute("utilisateur");
        String texte = (String) request.getParameter("champ_commentaire");
        
        if(!StringUtils.estVide(texte) && utilisateur!=null){
            CommentaireCinema commentaire = new CommentaireCinema();
            commentaire.setId_cinema(index_cinema);
            commentaire.setTexte(texte);
            commentaire.setDate(new Date());
            commentaire.setUtilisateur(utilisateur);

            entityManager.creerCommentaire_Cinema(commentaire);
        }
        return "ServletVisiteur?action=consulterDetailCinemaAction&cpt="+index_cinema;
    }
    
}
