package com.cineteam.cinebook.model.testprovider.seance;

import com.cineteam.cinebook.model.entity.Cinema;
import com.cineteam.cinebook.model.entity.Seances_film;
import com.cineteam.cinebook.model.provider.seance.SeanceProvider;
import java.util.List;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/** @author alexis */
public class TestSeanceProvider
{
    
    @Test
    public void retourneUneListeDeSeanceDeFilmsDunCinema()
    {
        SeanceProvider provider = new SeanceProvider();
        
        List<Seances_film> seances_films = provider.getSeancesPourUnCinema("W3300");
        
        assertNotNull(seances_films);
        assertTrue(seances_films.size() > 0);
    }
    
    @Test
    public void retourneUneListeDeSeancesDunFilm()
    {
        SeanceProvider provider = new SeanceProvider();
        
        List<Cinema> cinemas = provider.getSeancesPourUnFilm("145646", "33000");
        
        assertNotNull(cinemas);
        assertTrue(cinemas.size() > 0);
    }
}
