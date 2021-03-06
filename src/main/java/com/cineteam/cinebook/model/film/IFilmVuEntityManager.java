package com.cineteam.cinebook.model.film;

import java.util.List;

/** @author Bérangère */
public interface IFilmVuEntityManager {
    
    public void enregistrerFilmVu(FilmVu filmVu);
    public List<FilmVu> rechercherFilmsVus(Long id_utilisateur);
    public void supprimerFilmsVus(Long id_utilisateur);
}
