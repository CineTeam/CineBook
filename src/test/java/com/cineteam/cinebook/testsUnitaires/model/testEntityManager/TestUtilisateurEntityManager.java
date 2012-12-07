package com.cineteam.cinebook.testsUnitaires.model.testEntityManager;

import com.cineteam.cinebook.model.entity.Utilisateur;
import com.cineteam.cinebook.model.entitymanager.utilisateur.UtilisateurEntityManager;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/** @author Bérangère */
public class TestUtilisateurEntityManager {
    
    private UtilisateurEntityManager entityManager;
    
    @Before
    public void setUp()
    {
        entityManager = new UtilisateurEntityManager();
    }
    
    @Test
    public void nEnregistrePasUnUtilisateurEnBaseSiInfosNecessairesNonSaisies() 
    {
       
        entityManager.creerUtilisateur(new Utilisateur());
        
        assertNull(entityManager.rechercherUtilisateur(""));
    }
    
    @Test
    public void enregistreUnUtilisateurEnBaseSiInfosNecessairesSaisies() 
    {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setPseudo("pseudo");
        utilisateur.setLogin("login");
        utilisateur.setMdp("mdp");
        utilisateur.setId_droit(1);
        
        entityManager.creerUtilisateur(utilisateur);
        
        assertNotNull(entityManager.rechercherUtilisateur("login"));
        assertTrue(entityManager.rechercherUtilisateur("login").equals(utilisateur));
    }
    
    @Test
    public void neRecherchePasUtilisateurEnBaseSiNExistePas() 
    {        
        Utilisateur utilisateur = entityManager.rechercherUtilisateur("");
        
        assertNull(utilisateur);
    }
    
    
    @Test
    public void rechercheUtilisateurEnBaseSiExiste() 
    {        
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setPseudo("pseudo");
        utilisateur.setLogin("login");
        utilisateur.setMdp("mdp");
        utilisateur.setId_droit(1);
        entityManager.creerUtilisateur(utilisateur);
        
        Utilisateur utilisateur_recherche = entityManager.rechercherUtilisateur("login");
        
        assertNotNull(utilisateur_recherche);
        assertEquals(utilisateur_recherche.getPseudo(),"pseudo");
        assertEquals(utilisateur_recherche.getLogin(),"login");
        assertEquals(utilisateur_recherche.getMdp(),"mdp");
    }
        
}
