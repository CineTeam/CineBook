package com.cineteam.cinebook.web.testActions;

import com.cineteam.cinebook.model.entity.Film;
import com.cineteam.cinebook.model.provider.film.IFilmProvider;
import java.util.ArrayList;
import java.util.List;

/** @author ikram */
public class MockFilmProvider implements IFilmProvider
{
    public List<Film> films = new ArrayList<Film>();
    
    public List<Film> getFilmsParNom(String nom) {
        List<Film> resultat = new ArrayList<Film>();
        if(!films.isEmpty()){
            for(Film film : films){
                if(film.getTitre().contains(nom)) {
                    resultat.add(film);
                }
            }
        }
        return resultat;
    }

    public List<Film> getDixDerniersFilms() {
        List<Film> resultat = new ArrayList<Film>();
        if(!films.isEmpty()){
            for(int i=0; i < 10; i++){
                Film film = films.get(i);
                resultat.add(film);
            }
        }
        return resultat;
    }
    
}
