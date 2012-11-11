package com.cineteam.cinebook.model.testprovider.film;

import com.cineteam.cinebook.model.entity.Film;
import com.cineteam.cinebook.model.provider.FileProviderSource;
import com.cineteam.cinebook.model.provider.film.FilmXMLParser;
import java.util.List;
import org.joda.time.DateTime;
import static org.junit.Assert.*;
import org.junit.Test;

/** @author alexis */
public class TestFilmXMLParser {
    
     @Test
    public void parserRetourneUneListeDeCinemas() 
    {
        FilmXMLParser parser = new FilmXMLParser();
        FileProviderSource source = new FileProviderSource();
        
        List<Film> films = parser.parseFilmFromInputStream(source.getInputStream("TestXml/searchMovie.xml"));
        
        assertNotNull(films);
    }
    
    @Test
    public void parserRetourneDesCinemasDuTestXml()
    {
        FilmXMLParser parser = new FilmXMLParser();
        FileProviderSource source = new FileProviderSource();
        
        List<Film> cinemas = parser.parseFilmFromInputStream(source.getInputStream("TestXml/searchMovie.xml"));
        
        assertNotNull(cinemas);
        assertTrue(cinemas.size() > 0);
    }
    
    @Test
    public void parserRetourneDesCinemasCompletsDuTestXml()
    {
        FilmXMLParser parser = new FilmXMLParser();
        FileProviderSource source = new FileProviderSource();
        
        List<Film> films = parser.parseFilmFromInputStream(source.getInputStream("TestXml/searchMovie.xml"));
        Film film = films.get(0);
        
        assertNotNull(films);
        assertEquals("61282", film.getId());
        assertEquals("Avatar", film.getTitre());
        assertEquals(new DateTime(2010,9,1,0,0), film.getDate_sortie());
        assertEquals("James Cameron", film.getRealisateur());
        assertEquals("Sam Worthington, Zoe Saldana, Sigourney Weaver, Stephen Lang, Michelle Rodriguez", film.getActeurs());
        assertEquals(4.3333,film.getNote_presse(), 0.1 );
        assertEquals(4.31534,film.getNote_utilisateurs(), 0.1 );
        assertEquals("http://images.allocine.fr/medias/nmedia/18/78/95/70/19485155.jpg", film.getUrl_affiche());
    }
}
