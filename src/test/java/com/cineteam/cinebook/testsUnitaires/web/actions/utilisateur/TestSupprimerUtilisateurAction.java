package com.cineteam.cinebook.testsUnitaires.web.actions.utilisateur;

import com.cineteam.cinebook.model.commentaire.CommentaireCinema;
import com.cineteam.cinebook.model.commentaire.CommentaireFilm;
import com.cineteam.cinebook.model.film.FilmVu;
import com.cineteam.cinebook.model.utilisateur.Utilisateur;
import com.cineteam.cinebook.testsUnitaires.web.actions.cinema.MockCommentaireCinemaEntityManager;
import com.cineteam.cinebook.testsUnitaires.web.actions.film.MockCommentaireFilmEntityManager;
import com.cineteam.cinebook.testsUnitaires.web.actions.film.MockFilmVuEntityManager;
import com.cineteam.cinebook.testsUnitaires.web.servlets.AddedParametersRequestWrapper;
import com.cineteam.cinebook.web.utilisateur.SupprimerUtilisateurAction;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.replay;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/** @author Cedric */
public class TestSupprimerUtilisateurAction {
    private HttpServletRequest request ;
    private SupprimerUtilisateurAction supprimerUtilisateurAction;
    private MockUtilisateurEntityManager fauxEntityManagerUtilisateur;
    private MockCommentaireFilmEntityManager fauxEntityManagerCommentaireFilm;
    private MockCommentaireCinemaEntityManager fauxEntityManagerCommentaireCinema;
    private MockFilmVuEntityManager fauxEntityManagerFilmsVus;
   
    @Before
    public void setUp()
    {
        fauxEntityManagerUtilisateur = new MockUtilisateurEntityManager();
        fauxEntityManagerCommentaireFilm = new MockCommentaireFilmEntityManager();
        fauxEntityManagerCommentaireCinema = new MockCommentaireCinemaEntityManager();
        fauxEntityManagerFilmsVus = new MockFilmVuEntityManager();
        
        supprimerUtilisateurAction = new SupprimerUtilisateurAction(fauxEntityManagerUtilisateur, fauxEntityManagerCommentaireFilm, fauxEntityManagerCommentaireCinema, fauxEntityManagerFilmsVus);
        
        request = createMock(HttpServletRequest.class);
        replay(request);
    }
    
    @Test
    public void supprimerUtilisateur()
    {
      Utilisateur utilisateur = new Utilisateur();
      utilisateur.setId(1l);
      utilisateur.setLogin("alexedric");
      fauxEntityManagerUtilisateur.utilisateurs.add(utilisateur);
      
      request = new AddedParametersRequestWrapper(request, new HashMap());
      request.getSession().setAttribute("utilisateur",utilisateur);        
      
      supprimerUtilisateurAction.execute(request);
      
      assertNull(fauxEntityManagerUtilisateur.rechercherUtilisateur(utilisateur.getLogin()));
    }
            
    @Test
    public void supprimeLesCommentairesDeFilmsDeLUtilisateur()
    {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(1l);
        utilisateur.setLogin("alexedric");
        
        fauxEntityManagerUtilisateur.utilisateurs.add(utilisateur);
      
        CommentaireFilm commentaireFilm = new CommentaireFilm();
        commentaireFilm.setUtilisateur(utilisateur);
        commentaireFilm.setId_film("AZ");
        
        request = new AddedParametersRequestWrapper(request, new HashMap());
        request.getSession().setAttribute("utilisateur",utilisateur);          
        
        fauxEntityManagerCommentaireFilm.creerCommentaireFilm(commentaireFilm);
        supprimerUtilisateurAction.execute(request);
        
        assertTrue(fauxEntityManagerCommentaireFilm.rechercherCommentairesFilm(commentaireFilm.getId_film()).isEmpty());
    }
    
    @Test
    public void supprimeLesCommentairesDeCinemaDeLUtilisateur()
    {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(1l);
        utilisateur.setLogin("alexedric");
        
        fauxEntityManagerUtilisateur.utilisateurs.add(utilisateur);
      
        CommentaireCinema commentaireCinema = new CommentaireCinema();
        commentaireCinema.setUtilisateur(utilisateur);
        commentaireCinema.setId_cinema("AZ");
        
        request = new AddedParametersRequestWrapper(request, new HashMap());
        request.getSession().setAttribute("utilisateur",utilisateur);          
        
        fauxEntityManagerCommentaireCinema.creerCommentaire_Cinema(commentaireCinema);
        supprimerUtilisateurAction.execute(request);
        
        assertTrue(fauxEntityManagerCommentaireCinema.rechercherCommentaires_cinema(commentaireCinema.getId_cinema()).isEmpty());
    }
    
    @Test
    public void supprimeLesFilmsVusDeLUtilisateur()
    {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(1l);
        utilisateur.setLogin("alexedric");
        
        fauxEntityManagerUtilisateur.utilisateurs.add(utilisateur);
      
        FilmVu filmVu = new FilmVu();
        filmVu.setId_film("AZ");
        filmVu.setId_utilisateur(1l);
        
        request = new AddedParametersRequestWrapper(request, new HashMap());
        request.getSession().setAttribute("utilisateur",utilisateur);          
        
        fauxEntityManagerFilmsVus.enregistrerFilmVu(filmVu);
        
        supprimerUtilisateurAction.execute(request);
        
        assertTrue(fauxEntityManagerFilmsVus.rechercherFilmsVus(utilisateur.getId()).isEmpty());
    }
}
