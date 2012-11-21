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
        
        List<Film> films = parser.parserLesFilmsAPartirDeLInputStream(source.getInputStream("TestXml/searchMovie.xml"));
        
        assertNotNull(films);
    }
    
    @Test
    public void parserRetourneDesCinemasDuTestXml()
    {
        FilmXMLParser parser = new FilmXMLParser();
        FileProviderSource source = new FileProviderSource();
        
        List<Film> cinemas = parser.parserLesFilmsAPartirDeLInputStream(source.getInputStream("TestXml/searchMovie.xml"));
        
        assertNotNull(cinemas);
        assertTrue(cinemas.size() > 0);
    }
    
    @Test
    public void parserRetourneDesCinemasCompletsDuTestXml()
    {
        FilmXMLParser parser = new FilmXMLParser();
        FileProviderSource source = new FileProviderSource();
        
        List<Film> films = parser.parserLesFilmsAPartirDeLInputStream(source.getInputStream("TestXml/searchMovie.xml"));
        Film film = films.get(0);
        
        assertNotNull(films);
        assertEquals("61282", film.getId());
        assertEquals("Avatar", film.getTitre());
        assertEquals(new DateTime(2010,9,1,0,0).toDate(), film.getDate_sortie());
        assertEquals("James Cameron", film.getRealisateur());
        assertEquals("Sam Worthington, Zoe Saldana, Sigourney Weaver, Stephen Lang, Michelle Rodriguez", film.getActeurs());
        assertEquals(4.3333,film.getNote_presse(), 0.1 );
        assertEquals(4.31534,film.getNote_utilisateurs(), 0.1 );
        assertEquals("http://images.allocine.fr/medias/nmedia/18/78/95/70/19485155.jpg", film.getUrl_affiche());
    }
    
    @Test
    public void parserRetourneLeDetailDUnFilmComplet()
    {
        FilmXMLParser parser = new FilmXMLParser();
        FileProviderSource source = new FileProviderSource();
        
        Film film = parser.parserLeFilmAPartirDeLInputStream(source.getInputStream("TestXml/detailFilm.xml"));
        String synopsis = "Malgré sa paralysie, Jake Sully, un ancien marine immobilisé dans un fauteuil roulant, est resté un combattant au plus profond de son être. Il est recruté pour se rendre à des années-lumière de la Terre, sur Pandora, où de puissants groupes industriels exploitent un minerai rarissime destiné à résoudre la crise énergétique sur Terre. Parce que l'atmosphère de Pandora est toxique pour les humains, ceux-ci ont créé le Programme Avatar, qui permet à des \" pilotes \" humains de lier leur esprit à un avatar, un corps biologique commandé à distance, capable de survivre dans cette atmosphère létale. Ces avatars sont des hybrides créés génétiquement en croisant l'ADN humain avec celui des Na'vi, les autochtones de Pandora.Sous sa forme d'avatar, Jake peut de nouveau marcher. On lui confie une mission d'infiltration auprès des Na'vi, devenus un obstacle trop conséquent à l'exploitation du précieux minerai. Mais tout va changer lorsque Neytiri, une très belle Na'vi, sauve la vie de Jake...";
        
        assertNotNull(film);
        assertEquals("61282", film.getId());
        assertEquals("Avatar", film.getTitre());
        assertEquals(new DateTime(2009,12,16,0,0).toDate(), film.getDate_sortie());
        assertEquals("James Cameron", film.getRealisateur());
        assertEquals("Sam Worthington, Zoe Saldana, Sigourney Weaver, Stephen Lang, Michelle Rodriguez", film.getActeurs());
        assertEquals(4.3333,film.getNote_presse(), 0.1 );
        assertEquals(4.31534,film.getNote_utilisateurs(), 0.1 );
        assertEquals("http://images.allocine.fr/medias/nmedia/18/78/95/70/19485155.jpg", film.getUrl_affiche());
        assertEquals("http://www.allocine.fr/blogvision/19135625", film.getUrl_bande_annonce());
        assertEquals("2h42", film.getDuree());
        assertEquals(synopsis, film.getSynopsis());
        assertEquals(1,film.getPays().size());
        assertEquals("U.S.A.",film.getPays().get(0));
        assertEquals(2,film.getGenres().size());
        assertEquals("Science fiction",film.getGenres().get(0));
        assertEquals("Aventure",film.getGenres().get(1));

    }
}
