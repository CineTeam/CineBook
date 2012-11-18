package com.cineteam.cinebook.model.provider.cinema;

import com.cineteam.cinebook.model.entity.Cinema;
import java.util.List;

/** @author alexis */
public interface ICinemaProvider
{
    public List<Cinema> rechercherCinemasParMotCle(String nom);
    
    public List<Cinema> rechercherCinemasParCodePostal(String codePostal);
}
