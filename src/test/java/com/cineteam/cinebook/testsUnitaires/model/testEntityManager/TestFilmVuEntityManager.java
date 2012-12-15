package com.cineteam.cinebook.testsUnitaires.model.testEntityManager;

import com.cineteam.cinebook.model.film.FilmVu;
import com.cineteam.cinebook.model.film.FilmVuEntityManager;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/** @author Bérangère */
public class TestFilmVuEntityManager {
    
    private FilmVuEntityManager entityManager;
    
    @Before
    public void setUp()
    {
        entityManager = new FilmVuEntityManager();
    }
    
    @Test
    public void nEnregistrePasUnFilmVuEnBaseSiInfosNecessairesNonSaisies() 
    {
        FilmVu filmVu = new FilmVu();
        
        entityManager.enregistrerFilmVu(filmVu);
        
        assertNull(entityManager.rechercherFilmsVus(0).get(0).getId_film());
    }
    
    @Test
    public void enregistreUnFilmVuEnBaseSiInfosNecessairesSaisies() 
    {
        FilmVu filmVu = new FilmVu();
        filmVu.setId_film("idfilm");
        filmVu.setId_utilisateur(1);
        
        entityManager.enregistrerFilmVu(filmVu);
        
        assertTrue(!entityManager.rechercherFilmsVus(filmVu.getId_utilisateur()).isEmpty());
        assertTrue(entityManager.rechercherFilmsVus(filmVu.getId_utilisateur()).get(0).equals(filmVu));
    }
    
    @Test
    public void neRecherchePasFilmVuEnBaseSiNExistePas() 
    {        
        List<FilmVu> filmsVus = entityManager.rechercherFilmsVus(0);
        
        assertTrue(filmsVus.isEmpty());
    }
    
    
    @Test
    public void rechercheFilmVuEnBaseSiExiste() 
    {        
        FilmVu filmVu = new FilmVu();
        filmVu.setId_film("idfilm");
        filmVu.setId_utilisateur(1);
        entityManager.enregistrerFilmVu(filmVu);
        
        List<FilmVu> filmsVus = entityManager.rechercherFilmsVus(1);
        
        assertTrue(!filmsVus.isEmpty());
        assertNotNull(filmsVus.get(0));
        assertEquals(filmsVus.get(0).getId_film(),"idfilm");
        assertEquals(filmsVus.get(0).getId_utilisateur(),1);
    }
    
    
}
