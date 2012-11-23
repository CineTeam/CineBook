package com.cineteam.cinebook.model.provider.seance;

/**@author alexis*/
public interface ISeanceProvider
{
    public List<Seance> getSeancesPourUnCinema(String id);
}
