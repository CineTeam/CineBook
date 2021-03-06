package com.cineteam.cinebook.testsUnitaires.web.actions.utilisateur;

import com.cineteam.cinebook.model.cinema.CinemaFrequente;
import com.cineteam.cinebook.model.commentaire.CommentaireCinema;
import com.cineteam.cinebook.model.commentaire.CommentaireFilm;
import com.cineteam.cinebook.model.film.FilmVu;
import com.cineteam.cinebook.model.utilisateur.Utilisateur;
import com.cineteam.cinebook.testsUnitaires.web.actions.cinema.MockCinemaFrequenteEntityManager;
import com.cineteam.cinebook.testsUnitaires.web.actions.cinema.MockCommentaireCinemaEntityManager;
import com.cineteam.cinebook.testsUnitaires.web.actions.film.MockCommentaireFilmEntityManager;
import com.cineteam.cinebook.testsUnitaires.web.actions.film.MockFilmVuEntityManager;
import com.cineteam.cinebook.testsUnitaires.web.servlets.AddedParametersRequestWrapper;
import com.cineteam.cinebook.web.utilisateur.SupprimerUtilisateurAction;
import javax.servlet.http.HttpServletRequest;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.replay;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/** @author Cedric */
public class TestSupprimerUtilisateurAction {
    
    private HttpServletRequest request ;
    private SupprimerUtilisateurAction supprimerUtilisateurAction;
    private MockUtilisateurEntityManager fauxEntityManagerUtilisateur;
    private MockCommentaireFilmEntityManager fauxEntityManagerCommentaireFilm;
    private MockCommentaireCinemaEntityManager fauxEntityManagerCommentaireCinema;
    private MockFilmVuEntityManager fauxEntityManagerFilmsVus;
    private MockCinemaFrequenteEntityManager fauxEntityManagerCinemasFrequentes;
   
    @Before
    public void setUp() 
    {
        fauxEntityManagerUtilisateur = new MockUtilisateurEntityManager();
        fauxEntityManagerCommentaireFilm = new MockCommentaireFilmEntityManager();
        fauxEntityManagerCommentaireCinema = new MockCommentaireCinemaEntityManager();
        fauxEntityManagerFilmsVus = new MockFilmVuEntityManager();
        fauxEntityManagerCinemasFrequentes = new MockCinemaFrequenteEntityManager();
        supprimerUtilisateurAction = new SupprimerUtilisateurAction(fauxEntityManagerUtilisateur, fauxEntityManagerCommentaireFilm, fauxEntityManagerCommentaireCinema, fauxEntityManagerFilmsVus, fauxEntityManagerCinemasFrequentes);
        request = createMock(HttpServletRequest.class);
        replay(request);
    }
    
    @Test
    public void neSupprimePasLUtilisateurSiNEstPasConnecte()
    {
        request = new AddedParametersRequestWrapper(request);
        final Utilisateur utilisateur = utilisateur();
        fauxEntityManagerUtilisateur.utilisateurs.add(utilisateur);     
      
        supprimerUtilisateurAction.execute(request);
      
        assertFalse(fauxEntityManagerUtilisateur.utilisateurSupprime);
        assertNotNull(fauxEntityManagerUtilisateur.rechercherUtilisateur(utilisateur.getLogin()));
    }
    
    @Test
    public void supprimeLUtilisateurSiEstConnecte()
    {
        request = new AddedParametersRequestWrapper(request);
        final Utilisateur utilisateur = utilisateur();
        fauxEntityManagerUtilisateur.utilisateurs.add(utilisateur); 
        request.getSession().setAttribute("utilisateur",utilisateur);        
      
        supprimerUtilisateurAction.execute(request);
      
        assertTrue(fauxEntityManagerUtilisateur.utilisateurSupprime);
        assertNull(fauxEntityManagerUtilisateur.rechercherUtilisateur(utilisateur.getLogin()));
    }
            
    @Test
    public void supprimeLesCommentairesDeFilmsDeLUtilisateur()
    {
        request = new AddedParametersRequestWrapper(request);
        final Utilisateur utilisateur = utilisateur();
        request.getSession().setAttribute("utilisateur",utilisateur);        
        CommentaireFilm commentaireFilm = new CommentaireFilm();
        commentaireFilm.setUtilisateur(utilisateur);
        commentaireFilm.setId_film("AZ");
        fauxEntityManagerCommentaireFilm.commentairesFilm.add(commentaireFilm);  
        
        supprimerUtilisateurAction.execute(request);
        
        assertTrue(fauxEntityManagerCommentaireFilm.commentaireFilmSupprime);
        assertTrue(fauxEntityManagerCommentaireFilm.rechercherCommentairesFilm(commentaireFilm.getId_film()).isEmpty());
    }
    
    @Test
    public void supprimeLesCommentairesDeCinemaDeLUtilisateur()
    {
        request = new AddedParametersRequestWrapper(request);
        final Utilisateur utilisateur = utilisateur();        
        request.getSession().setAttribute("utilisateur",utilisateur);    
        CommentaireCinema commentaireCinema = new CommentaireCinema();
        commentaireCinema.setUtilisateur(utilisateur);
        commentaireCinema.setId_cinema("AZ");
        fauxEntityManagerCommentaireCinema.commentaires_cinema.add(commentaireCinema);
        
        supprimerUtilisateurAction.execute(request);
        
        assertTrue(fauxEntityManagerCommentaireCinema.commentaire_cinemaSupprime);
        assertTrue(fauxEntityManagerCommentaireCinema.rechercherCommentaires_cinema(commentaireCinema.getId_cinema()).isEmpty());
    }
    
    @Test
    public void supprimeLesFilmsVusDeLUtilisateur()
    {
        request = new AddedParametersRequestWrapper(request);
        final Utilisateur utilisateur = utilisateur();
        request.getSession().setAttribute("utilisateur",utilisateur);      
        FilmVu filmVu = new FilmVu();
        filmVu.setId_film("AZ");
        filmVu.setId_utilisateur(1l);
        fauxEntityManagerFilmsVus.filmsVus.add(filmVu);
        
        supprimerUtilisateurAction.execute(request);
        
        assertTrue(fauxEntityManagerFilmsVus.filmVuSupprime);
        assertTrue(fauxEntityManagerFilmsVus.rechercherFilmsVus(utilisateur.getId()).isEmpty());
    }
    
    @Test
    public void supprimeLesCinemasFrequentesDeLUtilisateur()
    {
        request = new AddedParametersRequestWrapper(request);
        final Utilisateur utilisateur = utilisateur();
        request.getSession().setAttribute("utilisateur",utilisateur);      
        CinemaFrequente cinemaFrequente = new CinemaFrequente();
        cinemaFrequente.setId_cinema("ZA");
        cinemaFrequente.setId_utilisateur(1l);
        fauxEntityManagerCinemasFrequentes.cinemasFrequentes.add(cinemaFrequente);
        
        supprimerUtilisateurAction.execute(request);
        
        assertTrue(fauxEntityManagerCinemasFrequentes.cinemaFrequenteSupprime);
        assertTrue(fauxEntityManagerCinemasFrequentes.rechercherCinemasFrequentes(utilisateur.getId()).isEmpty());
    }
    
    private Utilisateur utilisateur(){
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(1l);
        utilisateur.setLogin("alexedric");
        return utilisateur;
    }
    
}
