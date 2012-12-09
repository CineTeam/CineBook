package com.cineteam.cinebook.testsUnitaires.model.testEntityManager;

import com.cineteam.cinebook.model.commentaire.CommentaireFilm;
import com.cineteam.cinebook.model.commentaire.CommentaireFilmEntityManager;
import com.cineteam.cinebook.model.utilisateur.Utilisateur;
import com.cineteam.cinebook.model.utilisateur.UtilisateurEntityManager;
import java.util.Date;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/** @author alexis */
public class TestCommentaireFilmEntityManager
{
    private CommentaireFilmEntityManager entityManager;
    private UtilisateurEntityManager utilisateurEntityManager;
    
    @Before
    public void setUp()
    {
        entityManager = new CommentaireFilmEntityManager();
        utilisateurEntityManager = new UtilisateurEntityManager(); 
    }
    
    @Test
    public void nEnregistrePasUnCommentaireFilmEnBaseSiInfosNecessairesNonSaisies() 
    {
        CommentaireFilm commentaireFilm = new CommentaireFilm();
        
        entityManager.creerCommentaireFilm(commentaireFilm);
        
        assertTrue(entityManager.rechercherCommentairesFilm("").isEmpty());
    }
    
    @Test
    public void enregistreUnUtilisateurEnBaseSiInfosNecessairesSaisies() 
    {
        CommentaireFilm commentaireFilm = new CommentaireFilm();
        commentaireFilm.setDate(new Date());
        commentaireFilm.setId_film("1");
        commentaireFilm.setTexte("texte");
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setPseudo("pseudo");
        utilisateur.setLogin("login");
        utilisateur.setMdp("mdp");
        utilisateur.setId_droit(1);
        utilisateurEntityManager.creerUtilisateur(utilisateur);
        commentaireFilm.setUtilisateur(utilisateur);
        
        entityManager.creerCommentaireFilm(commentaireFilm);

        assertTrue(!entityManager.rechercherCommentairesFilm("1").isEmpty());
        assertTrue(entityManager.rechercherCommentairesFilm("1").get(0).equals(commentaireFilm));
    }
    
    @Test
    public void neListePasDeCommentairesCinemaEnBaseSiNExistePas() 
    {        
        List<CommentaireFilm> commentaires_cinema = entityManager.rechercherCommentairesFilm("");
        
        assertTrue(commentaires_cinema.isEmpty());
    }
    
    @Test
    public void listeCommentairesCinemaEnBaseSiExistent() 
    {        
        CommentaireFilm commentaireFilm = new CommentaireFilm();
        commentaireFilm.setDate(new Date());
        commentaireFilm.setId_film("1");
        commentaireFilm.setTexte("texte");
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setPseudo("pseudo");
        utilisateur.setLogin("login");
        utilisateur.setMdp("mdp");
        utilisateur.setId_droit(1);
        utilisateurEntityManager.creerUtilisateur(utilisateur);
        commentaireFilm.setUtilisateur(utilisateur);
        entityManager.creerCommentaireFilm(commentaireFilm);
        
        List<CommentaireFilm> commentairesFilm = entityManager.rechercherCommentairesFilm("1");
        
        assertTrue(!commentairesFilm.isEmpty());
        assertNotNull(commentairesFilm.get(0));
        assertEquals(commentairesFilm.get(0).getTexte(),"texte");
        assertEquals(commentairesFilm.get(0).getUtilisateur().getLogin(),"login");
    }
}
