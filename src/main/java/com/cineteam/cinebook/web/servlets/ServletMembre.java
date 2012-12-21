package com.cineteam.cinebook.web.servlets;

import com.cineteam.cinebook.model.cinema.CinemaFrequenteEntityManager;
import com.cineteam.cinebook.model.commentaire.CommentaireCinemaEntityManager;
import com.cineteam.cinebook.model.commentaire.CommentaireFilmEntityManager;
import com.cineteam.cinebook.model.film.FilmProvider;
import com.cineteam.cinebook.model.film.FilmVuEntityManager;
import com.cineteam.cinebook.model.utilisateur.UtilisateurEntityManager;
import com.cineteam.cinebook.web.cinema.AjouterCinemaAuxCinemasFrequentesAction;
import com.cineteam.cinebook.web.cinema.DeposerCommentaireCinemaAction;
import com.cineteam.cinebook.web.film.AjouterFilmAuxFilmsVusAction;
import com.cineteam.cinebook.web.film.DeposerCommentaireFilmAction;
import com.cineteam.cinebook.web.film.RecupererFilmsVusAction;
import com.cineteam.cinebook.web.utilisateur.*;
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
        actions.put("modifierUtilisateurAction", new ModifierUtilisateurAction(new UtilisateurEntityManager()));                
        actions.put("recupererFilmsVusAction", new RecupererFilmsVusAction(new FilmProvider(),new FilmVuEntityManager()));
        actions.put("supprimerUtilisateurAction", new SupprimerUtilisateurAction(new UtilisateurEntityManager(), new CommentaireFilmEntityManager(), new CommentaireCinemaEntityManager(), new FilmVuEntityManager(), new CinemaFrequenteEntityManager()));
        actions.put("ajouterFilmAuxFilmsVusAction", new AjouterFilmAuxFilmsVusAction(new FilmVuEntityManager()));
        actions.put("ajouterCinemaAuxCinemasFrequentesAction", new AjouterCinemaAuxCinemasFrequentesAction(new CinemaFrequenteEntityManager()));               
    }
}
