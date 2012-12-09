package com.cineteam.cinebook.web.servlets;

import com.cineteam.cinebook.web.film.ConsulterDetailFilmAction;
import com.cineteam.cinebook.web.film.RecupererDixDerniersFilmsSortisAction;
import com.cineteam.cinebook.web.film.RechercherFilmAction;
import com.cineteam.cinebook.web.cinema.RechercherCinemaAction;
import com.cineteam.cinebook.web.cinema.ConsulterDetailCinemaAction;
import com.cineteam.cinebook.web.cinema.RechercherCinemaParCPAction;
import com.cineteam.cinebook.model.commentaire.CommentaireCinemaEntityManager;
import com.cineteam.cinebook.model.cinema.CinemaProvider;
import com.cineteam.cinebook.model.commentaire.CommentaireFilmEntityManager;
import com.cineteam.cinebook.model.film.FilmProvider;
import com.cineteam.cinebook.model.seance.SeanceProvider;
import java.util.HashMap;

/** @author Bérangère */
public class ServletVisiteur extends CineBookServlet {

    public ServletVisiteur()
    {
        actions = new HashMap<String, Action>();
        actions.put("rechercherCinemaAction", new RechercherCinemaAction(new CinemaProvider()));
        actions.put("rechercherFilmAction", new RechercherFilmAction(new FilmProvider()));
        actions.put("recupererDixDerniersFilmsSortisAction", new RecupererDixDerniersFilmsSortisAction(new FilmProvider()));
        actions.put("rechercherCinemaParCPAction", new RechercherCinemaParCPAction(new CinemaProvider()));
        actions.put("consulterDetailCinemaAction", new ConsulterDetailCinemaAction(new CinemaProvider(),new SeanceProvider(),new CommentaireCinemaEntityManager()));
        actions.put("consulterDetailFilmAction", new ConsulterDetailFilmAction(new FilmProvider(), new SeanceProvider(), new CommentaireFilmEntityManager()));
    }
}
