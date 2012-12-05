package com.cineteam.cinebook.web.actions.cinema;

import com.cineteam.cinebook.model.entity.Cinema;
import com.cineteam.cinebook.model.entity.Commentaire_cinema;
import com.cineteam.cinebook.model.entity.Utilisateur;
import com.cineteam.cinebook.model.provider.cinema.ICinemaProvider;
import com.cineteam.cinebook.model.provider.seance.ISeanceProvider;
import com.cineteam.cinebook.outils.StringUtils;
import com.cineteam.cinebook.web.actions.Action;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/** @author Cedric */
public class ConsulterDetailCinemaAction implements Action {
    
    private ICinemaProvider providerCinema;
    private ISeanceProvider providerSeance;

    public ConsulterDetailCinemaAction(ICinemaProvider _providerCinema,ISeanceProvider _providerSeance) {
        providerCinema = _providerCinema;
        providerSeance = _providerSeance;
    }

    public String execute(HttpServletRequest request) {
        String index_cinema = (String) request.getParameter("cpt");
        if(!StringUtils.estVide(index_cinema)){
            Cinema cinema = providerCinema.getDetailCinema(index_cinema);
            cinema.setSeances_films(providerSeance.getSeancesPourUnCinema(cinema.getId()));
            request.setAttribute("cinema", cinema);       
            
            List<Commentaire_cinema> commentaires = new ArrayList<Commentaire_cinema>();
            commentaires.add(new Commentaire_cinema(new Date(), new Utilisateur(), "Ceci est un commentaire.", cinema));
            request.setAttribute("commentaires", commentaires);
        }    
        
        return "detailCinema.jsp";
    }
    
}
