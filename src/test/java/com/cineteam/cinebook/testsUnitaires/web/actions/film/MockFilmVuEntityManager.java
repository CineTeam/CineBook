package com.cineteam.cinebook.testsUnitaires.web.actions.film;

import com.cineteam.cinebook.model.film.FilmVu;
import com.cineteam.cinebook.model.film.IFilmVuEntityManager;
import java.util.ArrayList;
import java.util.List;

/* @author Berangere */
public class MockFilmVuEntityManager  implements IFilmVuEntityManager
{
    public List<FilmVu> filmsVus = new ArrayList<FilmVu>();
    public boolean filmVuEnregistre = false;
    public boolean filmVuSupprime = false;
    
    public void enregistrerFilmVu(FilmVu filmVu) 
    {
        filmVuEnregistre = true;
        filmsVus.add(filmVu);
    }

    public List<FilmVu> rechercherFilmsVus(Long id_utilisateur) 
    {
        List<FilmVu> resultat = new ArrayList<FilmVu>(); 
        for(FilmVu filmVu : filmsVus)
            if(filmVu.getId_utilisateur().equals(id_utilisateur))
                resultat.add(filmVu);
        return resultat;
    }

    public void supprimerFilmsVus(Long id_utilisateur) 
    {
        filmVuSupprime = true;
        List<FilmVu> filmVusASupprimer = new ArrayList<FilmVu>(); 
        for(FilmVu filmVu : filmsVus)
            if(filmVu.getId_utilisateur().equals(id_utilisateur))
                filmVusASupprimer.add(filmVu);
        
        for(FilmVu filmVu : filmVusASupprimer)
            filmsVus.remove(filmVu);
    }

}
