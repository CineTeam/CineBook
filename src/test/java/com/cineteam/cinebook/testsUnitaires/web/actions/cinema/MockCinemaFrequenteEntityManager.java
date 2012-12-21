package com.cineteam.cinebook.testsUnitaires.web.actions.cinema;

import com.cineteam.cinebook.model.cinema.CinemaFrequente;
import com.cineteam.cinebook.model.cinema.ICinemaFrequenteEntityManager;
import java.util.ArrayList;
import java.util.List;

/* @author Berangere */
public class MockCinemaFrequenteEntityManager  implements ICinemaFrequenteEntityManager
{
    public List<CinemaFrequente> cinemasFrequentes = new ArrayList<CinemaFrequente>();
    public boolean cinemaFrequenteEnregistre = false;
    public boolean cinemaFrequenteSupprime = false;
    
    public void enregistrerCinemaFrequente(CinemaFrequente cinemaFrequente) 
    {
        cinemaFrequenteEnregistre = true;
        cinemasFrequentes.add(cinemaFrequente);
    }

    public List<CinemaFrequente> rechercherCinemasFrequentes(Long id_utilisateur) 
    {
        List<CinemaFrequente> resultat = new ArrayList<CinemaFrequente>(); 
        for(CinemaFrequente cinemaFrequente : cinemasFrequentes)
            if(cinemaFrequente.getId_utilisateur().equals(id_utilisateur))
                resultat.add(cinemaFrequente);
        return resultat;
    }

    public void supprimerCinemasFrequentes(Long id_utilisateur) 
    {
        cinemaFrequenteSupprime = true;
        List<CinemaFrequente> cinemasFrequentesASupprimer = new ArrayList<CinemaFrequente>(); 
        for(CinemaFrequente cinemaFrequente : cinemasFrequentes)
            if(cinemaFrequente.getId_utilisateur().equals(id_utilisateur))
                cinemasFrequentesASupprimer.add(cinemaFrequente);
        
        for(CinemaFrequente cinemaFrequente : cinemasFrequentesASupprimer)
            cinemasFrequentes.remove(cinemaFrequente);
    }

}
