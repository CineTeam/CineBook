package com.cineteam.cinebook.testsUnitaires.web.actions.film;

import com.cineteam.cinebook.model.film.Film;
import com.cineteam.cinebook.model.film.IFilmProvider;
import java.util.ArrayList;
import java.util.List;

/** @author ikram */
public class MockFilmProvider implements IFilmProvider
{
    public List<Film> films = new ArrayList<Film>();
    
    public List<Film> rechercherFilmParMotCle(String mot_cle) {
        List<Film> resultat = new ArrayList<Film>();
        if(!films.isEmpty()){
            for(Film film : films){
                if(film.getTitre().contains(mot_cle)) {
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

    public Film getDetailFilm(String id) 
    {    
        Film film = null;
        if(!id.isEmpty()){
            film = new Film();
            film.setId(id);
            film.setSynopsis("Synopsis");
        }
        return film;
    }
    
}
