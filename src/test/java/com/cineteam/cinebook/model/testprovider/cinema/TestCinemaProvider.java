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
    public void returnListOfTheaters() 
    {
        CinemaProvider theaterProvider = new CinemaProvider();
        
        List<Cinema> theaters = theaterProvider.getCinemasParNom("Bordeaux");
        
        assertNotNull(theaters);
        assertTrue(theaters.size() > 0);
    }
    
    @Test
    public void returnListOfTheatersWithSearchedName() 
    {
        CinemaProvider theaterProvider = new CinemaProvider();
        
        List<Cinema> theaters = theaterProvider.getCinemasParNom("Bordeaux");
        
        assertNotNull(theaters);
        assertTrue(theaters.size() > 0);
        
        for(Cinema theater : theaters)
        {
            assertTrue(theater.getNom().contains("Bordeaux") || theater.getVille().contains("Bordeaux"));
        }
    }
}
