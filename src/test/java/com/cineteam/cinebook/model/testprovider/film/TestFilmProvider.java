package com.cineteam.cinebook.model.testprovider.film;

import com.cineteam.cinebook.model.entity.Film;
import com.cineteam.cinebook.model.provider.film.FilmProvider;
import java.util.List;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/** @author alexis */
public class TestFilmProvider {
    
    @Test
    public void retourneListeDeFilmPourUneRecherche() 
    {
        FilmProvider filmProvider = new FilmProvider();
        
        List<Film> films = filmProvider.rechercherFilmParMotCle("Avatar");
        
        assertNotNull(films);
        assertTrue(films.size() > 0);
    }
    
    @Test
    public void retourneListDeFilmPourUneRechercheQuandLeNomAUnAccent() 
    {
        FilmProvider filmProvider = new FilmProvider();
        
        List<Film> films = filmProvider.rechercherFilmParMotCle("arrête");
        
        assertNotNull(films);
        assertTrue(films.size() > 0);
    }
    
    @Test
    public void retourneListDeFilmPourUneRechercheQuandLeNomAUnEspace() 
    {
        FilmProvider filmProvider = new FilmProvider();
        
        List<Film> films = filmProvider.rechercherFilmParMotCle("le seigneur");
        
        assertNotNull(films);
        assertTrue(films.size() > 0);
    }
    
    @Test
    public void retourneListeDeFilmPourLesDixDerniereSorties() 
    {
        FilmProvider filmProvider = new FilmProvider();
        
        List<Film> films = filmProvider.getDixDerniersFilms();
        
        assertNotNull(films);
        assertTrue(films.size() > 0);
    }
    
    @Test
    public void retourneUnFilmParSonIdentifiant() 
    {
        FilmProvider filmProvider = new FilmProvider();
        
        Film film = filmProvider.getDetailFilm("61282");
        
        assertNotNull(film);
    }
}
