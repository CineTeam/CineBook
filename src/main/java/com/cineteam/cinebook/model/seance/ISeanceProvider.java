package com.cineteam.cinebook.model.seance;

import com.cineteam.cinebook.model.cinema.Cinema;
import java.util.List;

/**@author alexis*/
public interface ISeanceProvider
{
    public List<Seances_film> getSeancesPourUnCinema(String id);
    public List<Cinema> getSeancesPourUnFilm(String id, String codePostal);
}
