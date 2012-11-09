package com.cineteam.cinebook.model.testprovider;

import com.cineteam.cinebook.model.entity.Cinema;
import com.cineteam.cinebook.model.provider.AllocineXMLParser;
import com.cineteam.cinebook.model.provider.FileProviderSource;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;

/** @author alexis */
public class AllocineXMLParserTest {
    
    public AllocineXMLParserTest() {
    }
    
    @Test
    public void parserRetourneUneListeDeCinemas() 
    {
        AllocineXMLParser parser = new AllocineXMLParser();
        FileProviderSource source = new FileProviderSource();
        
        List<Cinema> cinemas = parser.parseCinemaFromInputStream(source.getInputStream("TestXml/searchTheater.xml"));
        
        assertNotNull(cinemas);
    }
    
    @Test
    public void parserRetourneDesCinemasDuTestXml()
    {
        AllocineXMLParser parser = new AllocineXMLParser();
        FileProviderSource source = new FileProviderSource();
        
        List<Cinema> cinemas = parser.parseCinemaFromInputStream(source.getInputStream("TestXml/searchTheater.xml"));
        
        assertNotNull(cinemas);
        assertTrue(cinemas.size() > 0);
    }
    
    @Test
    public void parserRetourneDesCinemasCompletsDuTestXml()
    {
        AllocineXMLParser parser = new AllocineXMLParser();
        FileProviderSource source = new FileProviderSource();
        
        List<Cinema> cinemas = parser.parseCinemaFromInputStream(source.getInputStream("TestXml/searchTheater.xml"));
        Cinema cinema = cinemas.get(0);
        
        assertNotNull(cinemas);
        assertEquals("W3300", cinema.getId());
        assertEquals("Mega CGR Français - Bordeaux", cinema.getNom());
        assertEquals("9 rue Montesquieu  ", cinema.getAdresse());
        assertEquals("33000", cinema.getCode_postal());
        assertEquals("Bordeaux", cinema.getVille());
    }
}
