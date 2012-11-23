package com.cineteam.cinebook.model.provider.seance;

import com.cineteam.cinebook.model.entity.Seance;
import com.cineteam.cinebook.model.entity.Seances_film;
import java.util.List;

/**@author alexis*/
public interface ISeanceProvider
{
    public List<Seances_film> getSeancesPourUnCinema(String id);
}
