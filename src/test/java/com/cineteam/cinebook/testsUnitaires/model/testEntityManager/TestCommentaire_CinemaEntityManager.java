package com.cineteam.cinebook.testsUnitaires.model.testEntityManager;

import com.cineteam.cinebook.model.commentaireCinema.Commentaire_cinema;
import com.cineteam.cinebook.model.utilisateur.Utilisateur;
import com.cineteam.cinebook.model.commentaireCinema.Commentaire_CinemaEntityManager;
import com.cineteam.cinebook.model.utilisateur.UtilisateurEntityManager;
import java.util.Date;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/** @author Bérangère */
public class TestCommentaire_CinemaEntityManager {
    
    private Commentaire_CinemaEntityManager entityManager;
    private UtilisateurEntityManager utilisateurEntityManager;
    
    @Before
    public void setUp()
    {
        entityManager = new Commentaire_CinemaEntityManager();
        utilisateurEntityManager = new UtilisateurEntityManager(); 
    }
    
    @Test
    public void nEnregistrePasUnCommentaire_CinemaEnBaseSiInfosNecessairesNonSaisies() 
    {
        Commentaire_cinema commentaire_cinema = new Commentaire_cinema();
        
        entityManager.creerCommentaire_Cinema(commentaire_cinema);
        
        assertTrue(entityManager.rechercherCommentaires_cinema("").isEmpty());
    }
    
    @Test
    public void enregistreUnUtilisateurEnBaseSiInfosNecessairesSaisies() 
    {
        Commentaire_cinema commentaire_cinema = new Commentaire_cinema();
        commentaire_cinema.setDate(new Date());
        commentaire_cinema.setId_cinema("1");
        commentaire_cinema.setTexte("texte");
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setPseudo("pseudo");
        utilisateur.setLogin("login");
        utilisateur.setMdp("mdp");
        utilisateur.setId_droit(1);
        utilisateurEntityManager.creerUtilisateur(utilisateur);
        commentaire_cinema.setUtilisateur(utilisateur);
        
        entityManager.creerCommentaire_Cinema(commentaire_cinema);
        
        
        assertTrue(!entityManager.rechercherCommentaires_cinema("1").isEmpty());
        assertTrue(entityManager.rechercherCommentaires_cinema("1").get(0).equals(commentaire_cinema));
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
        Commentaire_cinema commentaire_cinema = new Commentaire_cinema();
        commentaire_cinema.setDate(new Date());
        commentaire_cinema.setId_cinema("1");
        commentaire_cinema.setTexte("texte");
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setPseudo("pseudo");
        utilisateur.setLogin("login");
        utilisateur.setMdp("mdp");
        utilisateur.setId_droit(1);
        utilisateurEntityManager.creerUtilisateur(utilisateur);
        commentaire_cinema.setUtilisateur(utilisateur);
        entityManager.creerCommentaire_Cinema(commentaire_cinema);
        
        List<Commentaire_cinema> commentaires_cinema = entityManager.rechercherCommentaires_cinema("1");
        
        assertTrue(!commentaires_cinema.isEmpty());
        assertNotNull(commentaires_cinema.get(0));
        assertEquals(commentaires_cinema.get(0).getTexte(),"texte");
        assertEquals(commentaires_cinema.get(0).getUtilisateur().getLogin(),"login");
    }
        
}
