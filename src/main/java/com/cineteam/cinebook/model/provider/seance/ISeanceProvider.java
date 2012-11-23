package com.cineteam.cinebook.model.provider.seance;

import com.cineteam.cinebook.model.entity.Seance;
import java.util.List;

/**@author alexis*/
public interface ISeanceProvider
{
    public List<Seance> getSeancesPourUnCinema(String id);
}
