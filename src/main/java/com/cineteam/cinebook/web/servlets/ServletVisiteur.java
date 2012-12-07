package com.cineteam.cinebook.web.servlets;

import com.cineteam.cinebook.model.entitymanager.commentaire_cinema.Commentaire_CinemaEntityManager;
import com.cineteam.cinebook.model.provider.cinema.CinemaProvider;
import com.cineteam.cinebook.model.provider.film.FilmProvider;
import com.cineteam.cinebook.model.provider.seance.SeanceProvider;
import com.cineteam.cinebook.web.actions.Action;
import com.cineteam.cinebook.web.actions.cinema.*;
import com.cineteam.cinebook.web.actions.film.*;
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
        actions.put("consulterDetailCinemaAction", new ConsulterDetailCinemaAction(new CinemaProvider(),new SeanceProvider(),new Commentaire_CinemaEntityManager()));
        actions.put("consulterDetailFilmAction", new ConsulterDetailFilmAction(new FilmProvider(), new SeanceProvider()));
    }
}
