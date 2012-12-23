package com.cineteam.cinebook.testsUnitaires.web.actions.cinema;

import com.cineteam.cinebook.model.cinema.Cinema;
import com.cineteam.cinebook.model.cinema.CinemaFrequente;
import com.cineteam.cinebook.model.utilisateur.Utilisateur;
import com.cineteam.cinebook.testsUnitaires.web.servlets.AddedParametersRequestWrapper;
import com.cineteam.cinebook.web.cinema.RecupererCinemasFrequentesAction;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.replay;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/** @author Berangere */
public class TestRecupererCinemasFrequentesAction {
    
    private MockCinemaProvider fauxProvider;
    private MockCinemaFrequenteEntityManager fauxEntityManager;
    private HttpServletRequest request;
    private RecupererCinemasFrequentesAction recupererCinemasFrequentesAction;
    
    @Before
    public void setUp() {
        fauxProvider = new MockCinemaProvider();
        fauxEntityManager = new MockCinemaFrequenteEntityManager();
        recupererCinemasFrequentesAction = new RecupererCinemasFrequentesAction(fauxProvider,fauxEntityManager);
        request = createMock(HttpServletRequest.class);
        replay(request);
    }

    @Test
    public void neRetournePasDeCinemasFrequentesSiUtilisateurNonConnecte() 
    { 
        request = new AddedParametersRequestWrapper(request);   
        
        recupererCinemasFrequentesAction.execute(request);
    
        assertTrue(fauxEntityManager.rechercherCinemasFrequentes(null).isEmpty());
        assertTrue(fauxProvider.getCinemasParIds(fauxEntityManager.cinemasFrequentes).isEmpty());
        assertTrue(((List<Cinema>)request.getAttribute("cinemas")).isEmpty());
    }
    
    @Test
    public void neRetournePasDeCinemaFrequenteSiPasDeCinemaFrequente() 
    { 
        final Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(33L);
        request = new AddedParametersRequestWrapper(request);   
        request.getSession().setAttribute("utilisateur",utilisateur);
        
        recupererCinemasFrequentesAction.execute(request);
    
        assertTrue(fauxEntityManager.rechercherCinemasFrequentes(utilisateur.getId()).isEmpty());
        assertTrue(fauxProvider.getCinemasParIds(fauxEntityManager.cinemasFrequentes).isEmpty());
        assertTrue(((List<Cinema>)request.getAttribute("cinemas")).isEmpty());
    }
    
    @Test
    public void recupereDesCinemasSiUtilisateurConnecteEtCinemasFrequentes() 
    {
        final Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(33L);
        final Cinema cinema = new Cinema();
        cinema.setId("10");
        final CinemaFrequente cinemaFrequente = new CinemaFrequente();
        cinemaFrequente.setId_cinema(cinema.getId());
        cinemaFrequente.setId_utilisateur(utilisateur.getId());
        fauxEntityManager.cinemasFrequentes.add(cinemaFrequente);
        request = new AddedParametersRequestWrapper(request);   
        request.getSession().setAttribute("utilisateur",utilisateur);
        
        recupererCinemasFrequentesAction.execute(request);
        
        assertTrue(!fauxEntityManager.rechercherCinemasFrequentes(utilisateur.getId()).isEmpty());
        assertTrue(!fauxProvider.getCinemasParIds(fauxEntityManager.cinemasFrequentes).isEmpty());
        assertTrue(!((List<Cinema>)request.getAttribute("cinemas")).isEmpty());
        assertEquals(((List<Cinema>)request.getAttribute("cinemas")).get(0).getId(),"10");
    }
    
}
