package com.cineteam.cinebook.testsUnitaires.model.testEntityManager;

import com.cineteam.cinebook.model.film.FilmVu;
import com.cineteam.cinebook.model.film.FilmVuEntityManager;
import com.cineteam.cinebook.model.utilisateur.Utilisateur;
import com.cineteam.cinebook.model.utilisateur.UtilisateurEntityManager;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/** @author Bérangère */
public class TestFilmVuEntityManager {
    
    private FilmVuEntityManager entityManager;
    private UtilisateurEntityManager utilisateurEntityManager;
    
    @Before
    public void setUp()
    {
        entityManager = new FilmVuEntityManager();
        utilisateurEntityManager = new UtilisateurEntityManager();
    }
    
    @Test
    public void nEnregistrePasUnFilmVuEnBaseSiInfosNecessairesNonSaisies() 
    {
        FilmVu filmVu = new FilmVu();
        
        entityManager.enregistrerFilmVu(filmVu);
        
        assertTrue(entityManager.rechercherFilmsVus(new Long(0)).isEmpty());
    }
    
    @Test
    public void enregistreUnFilmVuEnBaseSiInfosNecessairesSaisies() 
    {
        FilmVu filmVu = new FilmVu();
        filmVu.setId_film("idfilm");
        filmVu.setId_utilisateur(new Long(1));
        
        entityManager.enregistrerFilmVu(filmVu);
        
        assertTrue(!entityManager.rechercherFilmsVus(filmVu.getId_utilisateur()).isEmpty());
        assertTrue(entityManager.rechercherFilmsVus(filmVu.getId_utilisateur()).get(0).equals(filmVu));
    }
    
    @Test
    public void neRecherchePasFilmVuEnBaseSiNExistePas() 
    {        
        List<FilmVu> filmsVus = entityManager.rechercherFilmsVus(new Long(0));
        
        assertTrue(filmsVus.isEmpty());
    }
    
    
    @Test
    public void rechercheFilmVuEnBaseSiExiste() 
    {        
        FilmVu filmVu = new FilmVu();
        filmVu.setId_film("idfilm");
        filmVu.setId_utilisateur(new Long(1));
        entityManager.enregistrerFilmVu(filmVu);
        
        List<FilmVu> filmsVus = entityManager.rechercherFilmsVus(filmVu.getId_utilisateur());
        
        assertTrue(!filmsVus.isEmpty());
        assertNotNull(filmsVus.get(0));
        assertEquals(filmsVus.get(0).getId_film(),"idfilm");
        assertEquals(filmsVus.get(0).getId_utilisateur(),new Long(1));
    }
    
    @Test
    public void supprimerFilmsVusDeLUtilisateur()
    {
        FilmVu filmVu = new FilmVu();
        filmVu.setId_film("idfilm");
        filmVu.setId_utilisateur(new Long(1));
        entityManager.enregistrerFilmVu(filmVu);
        
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setPseudo("pseudo");
        utilisateur.setLogin("login");
        utilisateur.setMdp("mdp");
        utilisateur.setId_droit(1);
        utilisateurEntityManager.creerUtilisateur(utilisateur);
        filmVu.setId_utilisateur(utilisateur.getId());
        
        entityManager.supprimerFilmsVus(utilisateur.getId());
    }
}
