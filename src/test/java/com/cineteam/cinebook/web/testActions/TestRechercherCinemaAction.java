package com.cineteam.cinebook.web.testActions;

import com.cineteam.cinebook.model.entity.Cinema;
import com.cineteam.cinebook.web.actions.RechercherCinemaAction;
import com.cineteam.cinebook.web.testServlets.AddedParametersRequestWrapper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.replay;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/** @author ikram */
public class TestRechercherCinemaAction {
  
    private MockCinemaProvider fauxProvider ;
    private HttpServletRequest request ;
    private RechercherCinemaAction rechercherCinemaAction ;
    
    @Before
    public void setUp() {
        fauxProvider = new MockCinemaProvider();
        rechercherCinemaAction = new RechercherCinemaAction(fauxProvider);
        request = createMock(HttpServletRequest.class);
        replay(request);
    }
    
    @Test
    public void neRecherchePasdeCinemaSansParametreDeRecherche()
    {
        final Map parametres = new HashMap();
        parametres.put("recherche","");
        request = new AddedParametersRequestWrapper(request, parametres);
        
        rechercherCinemaAction.execute(request);
        
        assertTrue(fauxProvider.getCinemasParNom("").isEmpty());       
        assertNull(request.getAttribute("cinemasParNom"));
    }
 
    @Test
    public void neRetournePasDeCinemasSiPasDeCinema()
    {
        String param_recherche = "cinemaRecherche";
        final Map parametres = new HashMap();
        parametres.put("recherche",param_recherche);
        request = new AddedParametersRequestWrapper(request, parametres);   
        
        rechercherCinemaAction.execute(request);
        
        assertTrue(fauxProvider.getCinemasParNom(param_recherche).isEmpty());       
        assertTrue(((List<Cinema>)request.getAttribute("cinemasParNom")).isEmpty());
    }
    
    @Test
    public void rechercheCinemaAvecParametreDeRecherche()
    {
        final Cinema cinema = cinema();
        fauxProvider.cinemas.add(cinema);
        String param_recherche = "cinemaRecherche";
        final Map parametres = new HashMap();
        parametres.put("recherche",param_recherche);
        request = new AddedParametersRequestWrapper(request, parametres);   
        
        rechercherCinemaAction.execute(request);
        
        assertTrue(!fauxProvider.getCinemasParNom(param_recherche).isEmpty());
        assertTrue(!((List<Cinema>)request.getAttribute("cinemasParNom")).isEmpty());
    }
    
    public Cinema cinema()
    {
        Cinema cinema = new Cinema();
        cinema.setNom("cinemaRecherche");
        return cinema;
    }
}
