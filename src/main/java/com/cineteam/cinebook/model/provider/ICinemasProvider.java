package com.cineteam.cinebook.model.provider;

import com.cineteam.cinebook.model.entity.Cinema;
import java.util.List;

/** @author alexis */
public interface ICinemasProvider
{
    public List<Cinema> getCinemasParNom(String nom);
}
