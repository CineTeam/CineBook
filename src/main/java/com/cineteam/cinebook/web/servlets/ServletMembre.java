package com.cineteam.cinebook.web.servlets;

import com.cineteam.cinebook.model.commentaire.CommentaireCinemaEntityManager;
import com.cineteam.cinebook.model.commentaire.CommentaireFilmEntityManager;
import com.cineteam.cinebook.model.utilisateur.UtilisateurEntityManager;
import com.cineteam.cinebook.web.cinema.DeposerCommentaireCinemaAction;
import com.cineteam.cinebook.web.film.DeposerCommentaireFilmAction;
import com.cineteam.cinebook.web.utilisateur.SeDeconnecterAction;
import com.cineteam.cinebook.web.utilisateur.SidentifierAction;
import com.cineteam.cinebook.web.utilisateur.SinscrireAction;
import java.util.HashMap;

public class ServletMembre extends CineBookServlet {

    public ServletMembre()
    {
        actions = new HashMap<String, Action>();
        actions.put("sinscrireAction", new SinscrireAction(new UtilisateurEntityManager()));
        actions.put("sidentifierAction", new SidentifierAction(new UtilisateurEntityManager()));
        actions.put("seDeconnecterAction", new SeDeconnecterAction());
        actions.put("deposerCommentaireCinemaAction", new DeposerCommentaireCinemaAction(new CommentaireCinemaEntityManager()));
        actions.put("deposerCommentaireFilmAction", new DeposerCommentaireFilmAction(new CommentaireFilmEntityManager()));
    }
}
