package com.cineteam.cinebook.web.servlets;

import com.cineteam.cinebook.model.entitymanager.commentaire_cinema.Commentaire_CinemaEntityManager;
import com.cineteam.cinebook.model.entitymanager.utilisateur.UtilisateurEntityManager;
import com.cineteam.cinebook.web.actions.Action;
import com.cineteam.cinebook.web.actions.cinema.DeposerCommentaireCinemaAction;
import com.cineteam.cinebook.web.actions.utilisateur.SeDeconnecterAction;
import com.cineteam.cinebook.web.actions.utilisateur.SidentifierAction;
import com.cineteam.cinebook.web.actions.utilisateur.SinscrireAction;
import java.util.HashMap;

public class ServletMembre extends CineBookServlet {

    public ServletMembre()
    {
        actions = new HashMap<String, Action>();
        actions.put("sinscrireAction", new SinscrireAction(new UtilisateurEntityManager()));
        actions.put("sidentifierAction", new SidentifierAction(new UtilisateurEntityManager()));
        actions.put("seDeconnecterAction", new SeDeconnecterAction());
        actions.put("deposerCommentaireCinemaAction", new DeposerCommentaireCinemaAction(new Commentaire_CinemaEntityManager()));
    }
}
