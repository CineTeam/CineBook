package com.cineteam.cinebook.web.cinema;

import com.cineteam.cinebook.model.commentaireCinema.ICommentaire_CinemaEntityManager;
import com.cineteam.cinebook.model.cinema.Cinema;
import com.cineteam.cinebook.model.commentaireCinema.Commentaire_cinema;
import com.cineteam.cinebook.model.cinema.ICinemaProvider;
import com.cineteam.cinebook.model.seance.ISeanceProvider;
import com.cineteam.cinebook.outils.StringUtils;
import com.cineteam.cinebook.web.servlets.Action;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/** @author Cedric */
public class ConsulterDetailCinemaAction implements Action {
    
    private ICinemaProvider providerCinema;
    private ISeanceProvider providerSeance;
    private ICommentaire_CinemaEntityManager entityManager;

    public ConsulterDetailCinemaAction(ICinemaProvider _providerCinema,ISeanceProvider _providerSeance, ICommentaire_CinemaEntityManager _entityManager) {
        providerCinema = _providerCinema;
        providerSeance = _providerSeance;
        entityManager = _entityManager;
    }

    public String execute(HttpServletRequest request) {
        String index_cinema = (String) request.getParameter("cpt");
        if(!StringUtils.estVide(index_cinema)){
            Cinema cinema = providerCinema.getDetailCinema(index_cinema);
            cinema.setSeances_films(providerSeance.getSeancesPourUnCinema(cinema.getId()));
            request.setAttribute("cinema", cinema);       
            List<Commentaire_cinema> commentaires = entityManager.rechercherCommentaires_cinema(cinema.getId());
            request.setAttribute("commentaires", commentaires);
        }    
        return "detailCinema.jsp";
    }
    
}
