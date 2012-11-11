package com.cineteam.cinebook.model.testprovider.film;

import com.cineteam.cinebook.model.entity.Film;
import com.cineteam.cinebook.model.provider.film.FilmProvider;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;

/** @author alexis */
public class TestFilmProvider {
    
    @Test
    public void retourneListeDeFilm() 
    {
        FilmProvider filmProvider = new FilmProvider();
        
        List<Film> films = filmProvider.getFilmsParNom("Avatar");
        
        assertNotNull(films);
        assertTrue(films.size() > 0);
    }
    
    @Test
    public void retourneListDeFilmAvecLeNomRecheche() 
    {
        FilmProvider filmProvider = new FilmProvider();
        
        List<Film> films = filmProvider.getFilmsParNom("Avatar");
        
        assertNotNull(films);
        assertTrue(films.size() > 0);
        
        for(Film film : films)
        {
            assertTrue(film.getTitre().contains("Avatar"));
        }
    }
}
