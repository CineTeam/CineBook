package com.cineteam.cinebook.web.cinema;

import com.cineteam.cinebook.model.cinema.Cinema;
import com.cineteam.cinebook.model.cinema.CinemaFrequente;
import com.cineteam.cinebook.model.cinema.ICinemaFrequenteEntityManager;
import com.cineteam.cinebook.model.cinema.ICinemaProvider;
import com.cineteam.cinebook.model.utilisateur.Utilisateur;
import com.cineteam.cinebook.web.servlets.Action;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/** @author Berangere */
public class RecupererCinemasFrequentesAction implements Action {

    private ICinemaProvider provider;
    private ICinemaFrequenteEntityManager em;
        
    public RecupererCinemasFrequentesAction(ICinemaProvider _provider, ICinemaFrequenteEntityManager _em) {
        provider = _provider;
        em = _em;
    }

    public String execute(HttpServletRequest request) {
        List<Cinema> cinemasFrequentes = new ArrayList<Cinema>();
        Utilisateur utilisateur = (Utilisateur) request.getSession().getAttribute("utilisateur");
               
        if(utilisateur!=null){
            List<CinemaFrequente> cinemasFrequentesParId = em.rechercherCinemasFrequentes(utilisateur.getId());
            if(!cinemasFrequentesParId.isEmpty())
            {
                cinemasFrequentes = provider.getCinemasParIds(cinemasFrequentesParId);
            }
        }
        request.setAttribute("cinemas", cinemasFrequentes);           
        return "listeCinemas.jsp";   
    }
  
}
