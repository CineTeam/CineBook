package com.cineteam.cinebook.testsUnitaires.web.actions.film;

import com.cineteam.cinebook.model.film.Film;
import com.cineteam.cinebook.model.film.FilmVu;
import com.cineteam.cinebook.model.utilisateur.Utilisateur;
import com.cineteam.cinebook.testsUnitaires.web.servlets.AddedParametersRequestWrapper;
import com.cineteam.cinebook.web.film.RecupererFilmsVusAction;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.replay;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/** @author Cedric */
public class TestRecupererFilmsVusAction {
    
    private MockFilmProvider fauxProvider;
    private MockFilmVuEntityManager fauxEntityManager;
    private HttpServletRequest request;
    private RecupererFilmsVusAction recupererFilmsVusAction;
    
    @Before
    public void setUp() {
        fauxProvider = new MockFilmProvider();
        fauxEntityManager = new MockFilmVuEntityManager();
        recupererFilmsVusAction = new RecupererFilmsVusAction(fauxProvider,fauxEntityManager);
        request = createMock(HttpServletRequest.class);
        replay(request);
    }

    @Test
    public void neRetournePasDeFilmsVusSiUtilisateurNonConnecte() 
    { 
        request = new AddedParametersRequestWrapper(request);   
        
        recupererFilmsVusAction.execute(request);
    
        assertTrue(fauxEntityManager.rechercherFilmsVus(null).isEmpty());
        assertTrue(fauxProvider.getFilmsParIds(fauxEntityManager.filmsVus).isEmpty());
        assertTrue(((List<Film>)request.getAttribute("filmsVus")).isEmpty());
    }
    
    @Test
    public void neRetournePasDeFilmVuSiPasDeFilmsVus() 
    { 
        final Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(33L);
        request = new AddedParametersRequestWrapper(request);   
        request.getSession().setAttribute("utilisateur",utilisateur);
        
        recupererFilmsVusAction.execute(request);
    
        assertTrue(fauxEntityManager.rechercherFilmsVus(utilisateur.getId()).isEmpty());
        assertTrue(fauxProvider.getFilmsParIds(fauxEntityManager.filmsVus).isEmpty());
        assertTrue(((List<Film>)request.getAttribute("filmsVus")).isEmpty());
    }
    
    @Test
    public void recupereDesFilmsSiUtilisateurConnecteEtFilmsVus() 
    {
        final Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(33L);
        final Film film = new Film();
        film.setId("10");
        final FilmVu filmVu = new FilmVu();
        filmVu.setId_film(film.getId());
        filmVu.setId_utilisateur(utilisateur.getId());
        fauxEntityManager.filmsVus.add(filmVu);
        request = new AddedParametersRequestWrapper(request);   
        request.getSession().setAttribute("utilisateur",utilisateur);
        
        recupererFilmsVusAction.execute(request);
        
        assertTrue(!fauxEntityManager.rechercherFilmsVus(utilisateur.getId()).isEmpty());
        assertTrue(!fauxProvider.getFilmsParIds(fauxEntityManager.filmsVus).isEmpty());
        assertTrue(!((List<Film>)request.getAttribute("filmsVus")).isEmpty());
        assertEquals(((List<Film>)request.getAttribute("filmsVus")).get(0).getId(),"10");
    }
    
}
