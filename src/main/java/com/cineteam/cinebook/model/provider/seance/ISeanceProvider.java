package com.cineteam.cinebook.model.provider.seance;

import com.cineteam.cinebook.model.entity.Seance;
import com.cineteam.cinebook.model.entity.SeancesFilm;
import java.util.List;

/**@author alexis*/
public interface ISeanceProvider
{
    public List<SeancesFilm> getSeancesPourUnCinema(String id);
}
