package com.cineteam.cinebook.testsUnitaires.model.testEntityManager;

import com.cineteam.cinebook.model.cinema.CinemaFrequente;
import com.cineteam.cinebook.model.cinema.CinemaFrequenteEntityManager;
import com.cineteam.cinebook.model.utilisateur.Utilisateur;
import com.cineteam.cinebook.model.utilisateur.UtilisateurEntityManager;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/** @author Bérangère */
public class TestCinemaFrequenteEntityManager {
    
    private CinemaFrequenteEntityManager entityManager;
    private UtilisateurEntityManager utilisateurEntityManager;
    
    @Before
    public void setUp()
    {
        entityManager = new CinemaFrequenteEntityManager();
        utilisateurEntityManager = new UtilisateurEntityManager();
    }
    
    @Test
    public void nEnregistrePasUnCinemaFrequenteEnBaseSiInfosNecessairesNonSaisies() 
    {
        CinemaFrequente cinemaFrequente = new CinemaFrequente();
        
        entityManager.enregistrerCinemaFrequente(cinemaFrequente);
        
        assertTrue(entityManager.rechercherCinemasFrequentes(new Long(0)).isEmpty());
    }
    
    @Test
    public void enregistreUnCinemaFrequenteEnBaseSiInfosNecessairesSaisies() 
    {
        CinemaFrequente cinemaFrequente = new CinemaFrequente();
        cinemaFrequente.setId_cinema("idCinema");
        cinemaFrequente.setId_utilisateur(new Long(1));
        
        entityManager.enregistrerCinemaFrequente(cinemaFrequente);
        
        assertTrue(!entityManager.rechercherCinemasFrequentes(cinemaFrequente.getId_utilisateur()).isEmpty());
        assertTrue(entityManager.rechercherCinemasFrequentes(cinemaFrequente.getId_utilisateur()).get(0).equals(cinemaFrequente));
    }
    
    @Test
    public void neRecherchePasCinemaFrequenteEnBaseSiNExistePas() 
    {        
        List<CinemaFrequente> cinemaFrequente = entityManager.rechercherCinemasFrequentes(new Long(0));
        
        assertTrue(cinemaFrequente.isEmpty());
    }
    
    
    @Test
    public void rechercheCinemaFrequenteEnBaseSiExiste() 
    {        
        CinemaFrequente cinemaFrequente = new CinemaFrequente();
        cinemaFrequente.setId_cinema("idCinema");
        cinemaFrequente.setId_utilisateur(new Long(1));
        entityManager.enregistrerCinemaFrequente(cinemaFrequente);
        
        List<CinemaFrequente> cinemasFrequentes = entityManager.rechercherCinemasFrequentes(cinemaFrequente.getId_utilisateur());
        
        assertTrue(!cinemasFrequentes.isEmpty());
        assertNotNull(cinemasFrequentes.get(0));
        assertEquals(cinemasFrequentes.get(0).getId_cinema(),"idCinema");
        assertEquals(cinemasFrequentes.get(0).getId_utilisateur(),new Long(1));
    }
    
    @Test
    public void peuxSupprimerCinemasFrequentesDeLUtilisateur()
    {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setPseudo("pseudo");
        utilisateur.setLogin("login");
        utilisateur.setMdp("mdp");
        utilisateur.setId_droit(1);
        utilisateurEntityManager.creerUtilisateur(utilisateur);
        CinemaFrequente cinemaFrequente = new CinemaFrequente();
        cinemaFrequente.setId_cinema("idCinema");
        cinemaFrequente.setId_utilisateur(utilisateur.getId());
        entityManager.enregistrerCinemaFrequente(cinemaFrequente);
        
        entityManager.supprimerCinemasFrequentes(utilisateur.getId());
        
        assertTrue(entityManager.rechercherCinemasFrequentes(utilisateur.getId()).isEmpty());
    }
}
