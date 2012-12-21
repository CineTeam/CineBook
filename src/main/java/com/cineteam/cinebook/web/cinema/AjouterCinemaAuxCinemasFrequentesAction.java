package com.cineteam.cinebook.web.cinema;

import com.cineteam.cinebook.model.cinema.CinemaFrequente;
import com.cineteam.cinebook.model.cinema.ICinemaFrequenteEntityManager;
import com.cineteam.cinebook.model.utilisateur.Utilisateur;
import com.cineteam.cinebook.outils.StringUtils;
import com.cineteam.cinebook.web.servlets.Action;
import javax.servlet.http.HttpServletRequest;

/** @author Berangere */
public class AjouterCinemaAuxCinemasFrequentesAction implements Action{

    private ICinemaFrequenteEntityManager entityManager;
    
    public AjouterCinemaAuxCinemasFrequentesAction(ICinemaFrequenteEntityManager _entityManager)
    {
        entityManager = _entityManager;
    }
    
    public String execute(HttpServletRequest request) {
        
        String indexCinema = (String) request.getParameter("cpt");
        Utilisateur utilisateur = (Utilisateur) request.getSession().getAttribute("utilisateur");
        
        if(!StringUtils.estVide(indexCinema) && utilisateur!=null){
            if(!cinemaDejaDansLesCinemasFrequentes(indexCinema,utilisateur.getId())){
                CinemaFrequente cinemaFrequente = new CinemaFrequente();
                cinemaFrequente.setId_cinema(indexCinema);
                cinemaFrequente.setId_utilisateur(utilisateur.getId());
                entityManager.enregistrerCinemaFrequente(cinemaFrequente);
            }
        }
        
        return "ServletVisiteur?action=consulterDetailCinemaAction&cpt="+indexCinema;
    }

    private boolean cinemaDejaDansLesCinemasFrequentes(String idCinema, Long idUtilisateur){
        for(CinemaFrequente cinemaFrequente : entityManager.rechercherCinemasFrequentes(idUtilisateur))
            if(cinemaFrequente.getId_cinema().equals(idCinema))
                return true;
        return false;
    }
}
