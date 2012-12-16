package com.cineteam.cinebook.testsUnitaires.web.actions.film;

import com.cineteam.cinebook.model.film.Film;
import com.cineteam.cinebook.model.film.FilmVu;
import com.cineteam.cinebook.model.utilisateur.Utilisateur;
import com.cineteam.cinebook.web.film.RecupererDixDerniersFilmsSortisAction;
import com.cineteam.cinebook.testsUnitaires.web.servlets.AddedParametersRequestWrapper;
import com.cineteam.cinebook.web.film.RecupererFilmsVusActions;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.replay;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/** @author Cedric */
public class TestRecupererFilmsVusActions {
    
    private MockFilmProvider fauxProvider;
    private MockFilmVuEntityManager fauxEntityManager;
    private HttpServletRequest request;
    private RecupererFilmsVusActions recupererFilmsVusAction;
    
    @Before
    public void setUp() {
        fauxProvider = new MockFilmProvider();
        fauxEntityManager = new MockFilmVuEntityManager();
        recupererFilmsVusAction = new RecupererFilmsVusActions(fauxProvider,fauxEntityManager);
        
        request = createMock(HttpServletRequest.class);
        replay(request);
    }
            
    @Test
    public void neRetournePasDeFilmSiPasDeFilm() 
    { 
        Utilisateur utilisateur = new Utilisateur();
        
        utilisateur.setLogin("uti");
        utilisateur.setId(33L);
        
        request = new AddedParametersRequestWrapper(request);   
        request.getSession().setAttribute("utilisateur",utilisateur);
        recupererFilmsVusAction.execute(request);
    
        assertTrue(((List<Film>)request.getAttribute("filmsVus")).isEmpty());
    }
        
    @Test
    public void recupereDesFilmsSiFilmsVus() 
    {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setLogin("uti");
        utilisateur.setId(33L);
        
        Film film = new Film();
        film.setId("10");
        
        FilmVu filmVu = new FilmVu();
        filmVu.setId_film(film.getId());
        filmVu.setId_utilisateur(utilisateur.getId());
        
        fauxEntityManager.enregistrerFilmVu(filmVu);
        request = new AddedParametersRequestWrapper(request);   
        request.getSession().setAttribute("utilisateur",utilisateur);
        
        recupererFilmsVusAction.execute(request);
        
        assertTrue(!((List<Film>)request.getAttribute("filmsVus")).isEmpty());
        assertEquals("10", ((List<Film>)request.getAttribute("filmsVus")).get(0).getId());
    }
    
    public Film film() {
        return new Film();
    }
    
}
