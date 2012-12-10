package com.cineteam.cinebook.testsUnitaires.model.testEntityManager;

import com.cineteam.cinebook.model.utilisateur.Utilisateur;
import com.cineteam.cinebook.model.utilisateur.UtilisateurEntityManager;
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
        
        assertNotNull(entityManager.rechercherUtilisateur(utilisateur.getLogin()));
        assertTrue(entityManager.rechercherUtilisateur(utilisateur.getLogin()).equals(utilisateur));
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
        
        Utilisateur utilisateur_recherche = entityManager.rechercherUtilisateur(utilisateur.getLogin());
        
        assertNotNull(utilisateur_recherche);
        assertEquals(utilisateur_recherche.getPseudo(),utilisateur.getPseudo());
        assertEquals(utilisateur_recherche.getLogin(),utilisateur.getLogin());
        assertEquals(utilisateur_recherche.getMdp(),utilisateur.getMdp());
    }
    
    @Test
    public void neModifiePasUtilisateurEnBaseSiNExistePas() 
    {    
        Utilisateur utilisateur = new Utilisateur();
        entityManager.creerUtilisateur(utilisateur);
        
        entityManager.modifierUtilisateur(utilisateur);
        
        assertNull(entityManager.rechercherUtilisateur(utilisateur.getLogin()));
    }
    
    @Test
    public void modifieLUtilisateurEnBaseSiExiste()
    {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setPseudo("pseudo");
        utilisateur.setLogin("login");
        utilisateur.setMdp("mdp");
        utilisateur.setId_droit(1);
        entityManager.creerUtilisateur(utilisateur);
        utilisateur.setAdresse("adresse");
        utilisateur.setCode_postal("33000");
        utilisateur.setVille("ville");
        
        entityManager.modifierUtilisateur(utilisateur);
        
        Utilisateur utilisateur_modifie = entityManager.rechercherUtilisateur(utilisateur.getLogin());
        assertNotNull(utilisateur_modifie);
        assertEquals(utilisateur_modifie.getAdresse(),utilisateur.getAdresse());
        assertEquals(utilisateur_modifie.getCode_postal(),utilisateur.getCode_postal());
        assertEquals(utilisateur_modifie.getVille(),utilisateur.getVille());
    }
}
