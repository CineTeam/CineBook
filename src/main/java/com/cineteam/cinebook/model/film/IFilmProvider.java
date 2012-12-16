package com.cineteam.cinebook.model.film;

import java.util.List;

/** @author alexis */
public interface IFilmProvider 
{
    public List<Film> rechercherFilmParMotCle(String nom);
    public List<Film> getDixDerniersFilms();
    public Film getDetailFilm(String id);
    public List<Film> getFilmsParIds(List<FilmVu> idsFilms);
}
