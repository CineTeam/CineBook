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
    public void retourneListeDeFilm() 
    {
        FilmProvider filmProvider = new FilmProvider();
        
        List<Film> films = filmProvider.rechercherFilmParMotCle("Avatar");
        
        assertNotNull(films);
        assertTrue(films.size() > 0);
    }
    
    @Test
    public void retourneListDeFilmQuandLeNomAUnAccent() 
    {
        FilmProvider filmProvider = new FilmProvider();
        
        List<Film> films = filmProvider.rechercherFilmParMotCle("arrête");
        
        assertNotNull(films);
        assertTrue(films.size() > 0);
    }
    
    @Test
    public void retourneListDeFilmQuandLeNomAUnEspace() 
    {
        FilmProvider filmProvider = new FilmProvider();
        
        List<Film> films = filmProvider.rechercherFilmParMotCle("le seigneur");
        
        assertNotNull(films);
        assertTrue(films.size() > 0);
    }
}
