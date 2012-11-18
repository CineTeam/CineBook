package com.cineteam.cinebook.model.testprovider.cinema;

import com.cineteam.cinebook.model.entity.Cinema;
import com.cineteam.cinebook.model.provider.cinema.CinemaXMLParser;
import com.cineteam.cinebook.model.provider.FileProviderSource;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;

/** @author alexis */
public class TestCinemaXMLParser {
     
    @Test
    public void parserRetourneUneListeDeCinemas() 
    {
        CinemaXMLParser parser = new CinemaXMLParser();
        FileProviderSource source = new FileProviderSource();
        
        List<Cinema> cinemas = parser.parserLesCinemasAPartirDeInputStream(source.getInputStream("TestXml/searchTheater.xml"));
        
        assertNotNull(cinemas);
    }
    
    @Test
    public void parserRetourneDesCinemasDuTestXml()
    {
        CinemaXMLParser parser = new CinemaXMLParser();
        FileProviderSource source = new FileProviderSource();
        
        List<Cinema> cinemas = parser.parserLesCinemasAPartirDeInputStream(source.getInputStream("TestXml/searchTheater.xml"));
        
        assertNotNull(cinemas);
        assertTrue(cinemas.size() > 0);
    }
    
    @Test
    public void parserRetourneDesCinemasCompletsDuTestXml()
    {
        CinemaXMLParser parser = new CinemaXMLParser();
        FileProviderSource source = new FileProviderSource();
        
        List<Cinema> cinemas = parser.parserLesCinemasAPartirDeInputStream(source.getInputStream("TestXml/searchTheater.xml"));
        Cinema cinema = cinemas.get(0);
        
        assertNotNull(cinemas);
        assertEquals("W3300", cinema.getId());
        assertEquals("Mega CGR Français - Bordeaux", cinema.getNom());
        assertEquals("9 rue Montesquieu  ", cinema.getAdresse());
        assertEquals("33000", cinema.getCode_postal());
        assertEquals("Bordeaux", cinema.getVille());
    }
    
    @Test
    public void parserRetourneLeDetailDUnCinema()
    {
        CinemaXMLParser parser = new CinemaXMLParser();
        FileProviderSource source = new FileProviderSource();
        
        Cinema cinema = parser.parserLeCinemaAPartirDeInputStream(source.getInputStream("TestXml/detailCinema.xml"));
        
        assertNotNull(cinema);
        assertEquals("W3300", cinema.getId());
        assertEquals("Mega CGR Français - Bordeaux", cinema.getNom());
        assertEquals("9 rue Montesquieu", cinema.getAdresse());
        assertEquals("33000", cinema.getCode_postal());
        assertEquals("Bordeaux", cinema.getVille());
        assertEquals(12, cinema.getNombre_ecrans());
        assertNotNull(cinema.getPosition());
        assertEquals(44.8424880, cinema.getPosition().getLatitude(), 0.001);
        assertEquals(-0.5785400, cinema.getPosition().getLongitude(), 0.001);
        assertEquals("http://images.allocine.fr/medias/nmedia/18/75/02/25/19456348.JPG", cinema.getUrl_image());
    }
}
