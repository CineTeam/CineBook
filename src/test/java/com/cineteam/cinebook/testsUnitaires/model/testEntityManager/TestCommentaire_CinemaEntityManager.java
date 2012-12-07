package com.cineteam.cinebook.testsUnitaires.model.testEntityManager;

import com.cineteam.cinebook.model.entitymanager.commentaire_cinema.Commentaire_CinemaEntityManager;
import com.cineteam.cinebook.model.entitymanager.utilisateur.UtilisateurEntityManager;
import com.cineteam.cinebook.model.entity.Commentaire_cinema;
import java.util.Date;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/** @author Bérangère */
public class TestCommentaire_CinemaEntityManager {
    
    private Commentaire_CinemaEntityManager entityManager;
    private UtilisateurEntityManager utilisateurEntityManager;
    
  /*  @Before
    public void setUp()
    {
        entityManager = new Commentaire_CinemaEntityManager();
        entityManager.setEntityManager("JPAPersistenceTest");
        utilisateurEntityManager = new UtilisateurEntityManager(); 
        utilisateurEntityManager.setEntityManager("JPAPersistenceTest");
    }
    
    @Test
    public void nEnregistrePasUnCommentaire_CinemaEnBaseSiInfosNecessairesNonSaisies() 
    {
        String erreur=null;
        Commentaire_cinema commentaire_cinema = new Commentaire_cinema();
        
        try{
            entityManager.creerCommentaire_Cinema(commentaire_cinema);
        }catch(Exception e){
            erreur = e.getMessage();
        }
        
        assertNotNull(erreur);
    }
    
    @Test
    public void enregistreUnUtilisateurEnBaseSiInfosNecessairesSaisies() 
    {
        String erreur=null;
        Commentaire_cinema commentaire_cinema = new Commentaire_cinema();
        commentaire_cinema.setDate(new Date());
        commentaire_cinema.setId_cinema("1");
        commentaire_cinema.setTexte("texte");
        commentaire_cinema.setUtilisateur(utilisateurEntityManager.rechercherUtilisateur("login"));
        
        try{
            entityManager.creerCommentaire_Cinema(commentaire_cinema);
        }catch(Exception e){
            erreur = e.getMessage();
        }
        
        assertNull(erreur);
    }
    
    @Test
    public void neListePasDeCommentairesCinemaEnBaseSiNExistePas() 
    {        
        List<Commentaire_cinema> commentaires_cinema = entityManager.rechercherCommentaires_cinema("");
        
        assertTrue(commentaires_cinema.isEmpty());
    }
    
    @Test
    public void listeCommentairesCinemaEnBaseSiExistent() 
    {        
        List<Commentaire_cinema> commentaires_cinema = entityManager.rechercherCommentaires_cinema("1");
        
        assertTrue(!commentaires_cinema.isEmpty());
        assertNotNull(commentaires_cinema.get(0));
        assertEquals(commentaires_cinema.get(0).getTexte(),"texte");
        assertEquals(commentaires_cinema.get(0).getUtilisateur().getLogin(),"login");
    }*/
        
}
