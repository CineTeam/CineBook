package com.cineteam.cinebook.web.testActions;

import com.cineteam.cinebook.model.entity.Film;
import com.cineteam.cinebook.model.provider.film.IFilmProvider;
import java.util.ArrayList;
import java.util.List;

/** @author alexis */
public class MockFilmProvider implements IFilmProvider
{
    public List<Film> films = new ArrayList<Film>();
    
    public List<Film> getFilmsParNom(String nom) {
        List<Film> resultat = new ArrayList<Film>();
        for(Film film : films){
            if(film.getTitre().contains(nom)) {
                resultat.add(film);
            }
        }
        return resultat;
    }
    
}
