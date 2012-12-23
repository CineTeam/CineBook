package com.cineteam.cinebook.testsUnitaires.model.parser;

import com.cineteam.cinebook.model.cinema.Cinema;
import com.cineteam.cinebook.model.seance.Horaire;
import com.cineteam.cinebook.model.seance.Seance;
import com.cineteam.cinebook.model.seance.SeancesFilm;
import com.cineteam.cinebook.model.provider.FileProviderSource;
import com.cineteam.cinebook.model.seance.SeanceXMLParser;
import java.util.List;
import org.joda.time.DateTime;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/** @author alexis */
public class TestSeanceXMLParser 
{
    private SeanceXMLParser parser;
    private FileProviderSource source;
   
    @Before
    public void setUp()
    {
        parser = new SeanceXMLParser();
        source = new FileProviderSource();
    }
    
    @Test
    public void retourneDesSeancesDeFilmsPourUnCinema()
    {
        List<SeancesFilm> seances = parser.parserLesSeancesPourUnCinema(source.getInputStream("TestXml/seanceCinema.xml"));
        
        assertNotNull(seances);
        assertTrue(seances.size() > 0);
    }
    
    @Test 
    public void retourneDesSeancesDeFilmsAvecUnFilmEtDesSeances()
    {
        List<SeancesFilm> seancesFilms = parser.parserLesSeancesPourUnCinema(source.getInputStream("TestXml/seanceCinema.xml"));
        
        SeancesFilm seancesFilm = seancesFilms.get(0);
        List<Seance> seances = seancesFilm.getSeances();
        
        assertNotNull(seancesFilm);
        assertNotNull(seancesFilm.getFilm());
        assertEquals("189909",seancesFilm.getFilm().getId());
        assertNotNull(seances);
        assertTrue(seances.size() > 0);
    }
    
    @Test 
    public void retourneDesSeancesDeFilmsAvecDesSeancesCompletes()
    {
        List<SeancesFilm> seancesFilms = parser.parserLesSeancesPourUnCinema(source.getInputStream("TestXml/seanceCinema.xml"));
        
        SeancesFilm seancesFilm = seancesFilms.get(0);
        List<Seance> seances = seancesFilm.getSeances();
        Seance seance = seances.get(0);
        
        assertNotNull(seance);
        assertEquals("Français",seance.getLangue());
        assertEquals("3D",seance.getFormat());
        assertNotNull(seance.getHoraires());
        assertTrue(seance.getHoraires().size() > 0);
    }
    
    @Test
    public void retourneDesSeancesDeFilmsAvecDesHorairesComplets()
    {
        List<SeancesFilm> seancesFilms = parser.parserLesSeancesPourUnCinema(source.getInputStream("TestXml/seanceCinema.xml"));
        
        SeancesFilm seancesFilm = seancesFilms.get(0);
        List<Seance> seances = seancesFilm.getSeances();
        Seance seance = seances.get(0);
        List<Horaire> horaires = seance.getHoraires();
        Horaire horaire = horaires.get(0);
        
        assertNotNull(horaire);
        assertEquals(new DateTime(2012,11,25,0,0).toDate(), horaire.getJour());
        assertNotNull(horaire.getHeures());
        assertTrue(horaire.getHeures().size() > 0);
        assertEquals("13:30", horaire.getHeures().get(0));
    }
    
    @Test
    public void retourneLesSeancesDesCinemasDunFilm()
    {
        List<Cinema> cinemas = parser.parserLesSeancesPourUnFilm(source.getInputStream("TestXml/seanceFilm.xml"));
        Cinema cinema = cinemas.get(0);
        
        assertNotNull(cinemas);
        assertTrue(cinemas.size() > 0);
        assertNotNull(cinema);
        assertEquals("P0087", cinema.getId());
    }
}
