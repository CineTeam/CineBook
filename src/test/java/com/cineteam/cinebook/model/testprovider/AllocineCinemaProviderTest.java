package com.cineteam.cinebook.model.testprovider;

import com.cineteam.cinebook.model.entity.Cinema;
import com.cineteam.cinebook.model.provider.AllocineCinemaProvider;
import java.util.List;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/** @author alexis */
public class AllocineCinemaProviderTest {
    
    public AllocineCinemaProviderTest() {
    }
    
    @Test
    public void returnListOfTheaters() 
    {
        AllocineCinemaProvider theaterProvider = new AllocineCinemaProvider();
        
        List<Cinema> theaters = theaterProvider.getCinemasParNom("Bordeaux");
        
        assertNotNull(theaters);
        assertTrue(theaters.size() > 0);
    }
    
    @Test
    public void returnListOfTheatersWithSearchedName() 
    {
        AllocineCinemaProvider theaterProvider = new AllocineCinemaProvider();
        
        List<Cinema> theaters = theaterProvider.getCinemasParNom("Bordeaux");
        
        assertNotNull(theaters);
        assertTrue(theaters.size() > 0);
        
        for(Cinema theater : theaters)
        {
            assertTrue(theater.getNom().contains("Bordeaux") || theater.getVille().contains("Bordeaux"));
        }
    }
}
