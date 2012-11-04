/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cineteam.cinebook.testprovider;

import com.cineteam.cinebook.model.Theater;
import com.cineteam.cinebook.provider.AllocineTheaterProvider;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author alexis
 */
public class AllocineTheaterProviderTest {
    
    public AllocineTheaterProviderTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void returnListOfTheaters() 
    {
        AllocineTheaterProvider theaterProvider = new AllocineTheaterProvider();
        
        List<Theater> theaters = theaterProvider.getTheatersByName("Bordeaux");
        
        assertNotNull(theaters);
        assertTrue(theaters.size() > 0);
    }
    
    @Test
    public void returnListOfTheatersWithSearchedName() 
    {
        AllocineTheaterProvider theaterProvider = new AllocineTheaterProvider();
        
        List<Theater> theaters = theaterProvider.getTheatersByName("Bordeaux");
        
        assertNotNull(theaters);
        assertTrue(theaters.size() > 0);
        
        for(Theater theater : theaters)
        {
            assertTrue(theater.getName().contains("Bordeaux") || theater.getCity().contains("Bordeaux"));
        }
    }
}
