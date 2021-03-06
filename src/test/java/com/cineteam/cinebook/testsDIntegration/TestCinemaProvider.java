package com.cineteam.cinebook.testsDIntegration;

import com.cineteam.cinebook.model.cinema.Cinema;
import com.cineteam.cinebook.model.cinema.CinemaFrequente;
import com.cineteam.cinebook.model.cinema.CinemaProvider;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/** @author alexis */
public class TestCinemaProvider {
    
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
    
    @Test
    public void retourneUnCinemaParSonIdentifiant() 
    {
        CinemaProvider cinemaProvider = new CinemaProvider();
        
        Cinema cinema = cinemaProvider.getDetailCinema("W3300");
        
        assertNotNull(cinema);
    }
    
    @Test
    public void retourneListeCinemaPourListeId()
    {
        CinemaProvider cinemaProvider = new CinemaProvider();
        CinemaFrequente cinemaFrequente = new CinemaFrequente();
        cinemaFrequente.setId_cinema("W3300");
        List<CinemaFrequente> cinemasFrequentes = new ArrayList<CinemaFrequente>();
        cinemasFrequentes.add(cinemaFrequente);
        
        List<Cinema> cinemas = cinemaProvider.getCinemasParIds(cinemasFrequentes);
      
        assertNotNull(cinemas);
        assertTrue(cinemas.size()>0);
    }
    
    @Test
    public void neRetournePasDeCinemaSiPasDeCinema() 
    {
        CinemaProvider cinemaProvider = new CinemaProvider();
        
        assertTrue(cinemaProvider.getCinemasParIds(null).isEmpty());      
    }
    
}
