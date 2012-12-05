package com.cineteam.cinebook.model.testEntityManager;

import com.cineteam.cinebook.entitymanager.utilisateur.UtilisateurEntityManager;
import com.cineteam.cinebook.model.entity.Utilisateur;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/** @author Bérangère */
public class TestUtilisateurEntityManager {
    
    private UtilisateurEntityManager entityManager;
    
   /* @Before
    public void setUp()
    {
        entityManager = new UtilisateurEntityManager();
        entityManager.setEntityManager("JPAPersistenceTest");
    }
    
    @Test
    public void nEnregistrePasUnUtilisateurEnBaseSiInfosNecessairesNonSaisies() 
    {
        String erreur=null;
        Utilisateur utilisateur = new Utilisateur();
        
        try{
            entityManager.creerUtilisateur(utilisateur);
        }catch(Exception e){
            erreur = e.getMessage();
        }
        
        assertNotNull(erreur);
    }
    
    @Test
    public void enregistreUnUtilisateurEnBaseSiInfosNecessairesSaisies() 
    {
        String erreur=null;
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setPseudo("pseudo");
        utilisateur.setLogin("login");
        utilisateur.setMdp("mdp");
        utilisateur.setId_droit(1);
        
        try{
            entityManager.creerUtilisateur(utilisateur);
        }catch(Exception e){
            erreur = e.getMessage();
        }
        
        assertNull(erreur);
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
        Utilisateur utilisateur = entityManager.rechercherUtilisateur("login");
        
        assertNotNull(utilisateur);
        assertEquals(utilisateur.getPseudo(),"pseudo");
        assertEquals(utilisateur.getLogin(),"login");
        assertEquals(utilisateur.getMdp(),"mdp");
    }
        */
}
