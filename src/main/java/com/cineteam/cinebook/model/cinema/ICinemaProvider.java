package com.cineteam.cinebook.model.cinema;

import java.util.List;

/** @author alexis */
public interface ICinemaProvider
{
    public List<Cinema> rechercherCinemasParMotCle(String nom);
    
    public List<Cinema> rechercherCinemasParCodePostal(String codePostal);
    
    public Cinema getDetailCinema(String id);
    
    public List<Cinema> getCinemasParIds(List<CinemaFrequente> idsCinemas);
}
