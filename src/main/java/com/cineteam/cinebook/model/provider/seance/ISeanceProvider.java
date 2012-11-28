package com.cineteam.cinebook.model.provider.seance;

import com.cineteam.cinebook.model.entity.Cinema;
import com.cineteam.cinebook.model.entity.Seances_film;
import java.util.List;

/**@author alexis*/
public interface ISeanceProvider
{
    public List<Seances_film> getSeancesPourUnCinema(String id);
    public List<Cinema> getSeancesPourUnFilm(String id, String codePostal);
}
