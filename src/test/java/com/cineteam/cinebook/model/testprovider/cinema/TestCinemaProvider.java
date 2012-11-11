package com.cineteam.cinebook.model.testprovider.cinema;

import com.cineteam.cinebook.model.entity.Cinema;
import com.cineteam.cinebook.model.provider.cinema.CinemaProvider;
import java.util.List;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/** @author alexis */
public class TestCinemaProvider {
    
    public TestCinemaProvider() {
    }
    
    @Test
    public void retourneUneListeDeCinema() 
    {
        CinemaProvider cinemaProvider = new CinemaProvider();
        
        List<Cinema> cinemas = cinemaProvider.getCinemasParNom("Bordeaux");
        
        assertNotNull(cinemas);
        assertTrue(cinemas.size() > 0);
    }
    
    @Test
    public void retourneUneListeDeCinemaAvecLeNomRecherche() 
    {
        CinemaProvider cinemaProvider = new CinemaProvider();
        
        List<Cinema> cinemas = cinemaProvider.getCinemasParNom("Bordeaux");
        
        assertNotNull(cinemas);
        assertTrue(cinemas.size() > 0);
        
        for(Cinema cinema : cinemas)
        {
            assertTrue(cinema.getNom().contains("Bordeaux") || cinema.getVille().contains("Bordeaux"));
        }
    }
}
