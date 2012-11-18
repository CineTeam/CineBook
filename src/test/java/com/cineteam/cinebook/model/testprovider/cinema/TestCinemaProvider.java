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
    public void retourneUneListeDeCinemaParMotCle() 
    {
        CinemaProvider cinemaProvider = new CinemaProvider();
        
        List<Cinema> cinemas = cinemaProvider.rechercherCinemasParMotCle("Bordeaux");
        
        assertNotNull(cinemas);
        assertTrue(cinemas.size() > 0);
    }
    
    @Test
    public void retourneUneListeDeCinemaParCodePostal() 
    {
        CinemaProvider cinemaProvider = new CinemaProvider();
        
        List<Cinema> cinemas = cinemaProvider.rechercherCinemasParCodePostal("33000");
        
        assertNotNull(cinemas);
        assertTrue(cinemas.size() > 0);
        
    }
    
    
}
