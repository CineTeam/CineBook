package com.cineteam.cinebook.model.provider.cinema;

import com.cineteam.cinebook.model.entity.Cinema;
import java.util.List;

/** @author alexis */
public interface ICinemaProvider
{
    public List<Cinema> getCinemasParNom(String nom);
}