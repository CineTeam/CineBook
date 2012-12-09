package com.cineteam.cinebook.web.film;

import com.cineteam.cinebook.model.commentaire.CommentaireFilm;
import com.cineteam.cinebook.model.commentaire.ICommentaireFilmEntityManager;
import com.cineteam.cinebook.model.utilisateur.Utilisateur;
import com.cineteam.cinebook.outils.StringUtils;
import com.cineteam.cinebook.web.servlets.Action;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;

/* @author alexis */
public class DeposerCommentaireFilmAction implements Action
{
    private ICommentaireFilmEntityManager entityManager;
    
    public DeposerCommentaireFilmAction(ICommentaireFilmEntityManager _entityManager)
    {
        entityManager = _entityManager;
    }
    
    public String execute(HttpServletRequest request) 
    {
        String indexFilm = (String) request.getParameter("cpt");
        String CP_recherche = (String) request.getParameter("code_postal");
        Utilisateur utilisateur = (Utilisateur) request.getSession().getAttribute("utilisateur");
        String texte = (String) request.getParameter("champ_commentaire");
        
        if(!StringUtils.estVide(texte) && utilisateur!=null){
            CommentaireFilm commentaire = new CommentaireFilm();
            commentaire.setId_film(indexFilm);
            commentaire.setTexte(texte);
            commentaire.setDate(new Date());
            commentaire.setUtilisateur(utilisateur);

            entityManager.creerCommentaireFilm(commentaire);
        }
        return "ServletVisiteur?action=consulterDetailFilmAction&cpt="+indexFilm+"&recherche="+CP_recherche;
    }

}
