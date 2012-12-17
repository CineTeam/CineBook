package com.cineteam.cinebook.testsUnitaires.web.actions.cinema;

import com.cineteam.cinebook.model.cinema.Cinema;
import com.cineteam.cinebook.web.cinema.RechercherCinemaParCPAction;
import com.cineteam.cinebook.testsUnitaires.web.servlets.AddedParametersRequestWrapper;
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
public class TestRechercherCinemaParCPAction {
  
    private MockCinemaProvider fauxProvider ;
    private HttpServletRequest request ;
    private RechercherCinemaParCPAction rechercherCinemaParCPAction ;
    
    @Before
    public void setUp() {
        fauxProvider = new MockCinemaProvider();
        rechercherCinemaParCPAction = new RechercherCinemaParCPAction(fauxProvider);
        request = createMock(HttpServletRequest.class);
        replay(request);
    }
    
    @Test
    public void neRecherchePasdeCinemaSansParametreDeRecherche()
    {
        request = new AddedParametersRequestWrapper(request);
        
        rechercherCinemaParCPAction.execute(request);
        
        assertTrue(fauxProvider.rechercherCinemasParCodePostal("").isEmpty());       
        assertNull(request.getAttribute("cinemas"));
    }
 
    @Test
    public void neRetournePasDeCinemasSiPasDeCinema()
    {
        String param_recherche = "cpRecherche";
        final Map parametres = new HashMap();
        parametres.put("recherche",param_recherche);
        request = new AddedParametersRequestWrapper(request, parametres);   
        
        rechercherCinemaParCPAction.execute(request);
        
        assertTrue(fauxProvider.rechercherCinemasParCodePostal(param_recherche).isEmpty());       
        assertTrue(((List<Cinema>)request.getAttribute("cinemas")).isEmpty());
    }
    
    @Test
    public void rechercheCinemaAvecParametreDeRecherche()
    {
        final Cinema cinema = cinema();
        fauxProvider.cinemas.add(cinema);
        String param_recherche = "cpRecherche";
        final Map parametres = new HashMap();
        parametres.put("recherche",param_recherche);
        request = new AddedParametersRequestWrapper(request, parametres);   
        
        rechercherCinemaParCPAction.execute(request);
        
        assertTrue(!fauxProvider.rechercherCinemasParCodePostal(param_recherche).isEmpty());
        assertTrue(!((List<Cinema>)request.getAttribute("cinemas")).isEmpty());
    }
    
    public Cinema cinema()
    {
        Cinema cinema = new Cinema();
        cinema.setCode_postal("cpRecherche");
        return cinema;
    }
}
