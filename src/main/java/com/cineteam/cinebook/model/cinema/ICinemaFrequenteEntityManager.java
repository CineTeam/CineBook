package com.cineteam.cinebook.model.cinema;

import java.util.List;

/** @author Bérangère */
public interface ICinemaFrequenteEntityManager {
    
    public void enregistrerCinemaFrequente(CinemaFrequente cinemaFrequente);
    public List<CinemaFrequente> rechercherCinemasFrequentes(Long id_utilisateur);
    public void supprimerCinemasFrequentes(Long id_utilisateur);
}
