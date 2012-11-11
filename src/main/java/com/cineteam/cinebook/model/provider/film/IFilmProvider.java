package com.cineteam.cinebook.model.provider.film;

import com.cineteam.cinebook.model.entity.Film;
import java.util.List;

/** @author alexis */
public interface IFilmProvider 
{
    public List<Film> getFilmsParNom(String nom);
}
