package com.cineteam.cinebook.web.testActions;

import com.cineteam.cinebook.model.entity.Cinema;
import com.cineteam.cinebook.web.actions.RechercherCinemaAction;
import com.cineteam.cinebook.web.testServlets.AddedParametersRequestWrapper;
import java.security.Provider;
import java.util.*;
import javax.servlet.http.HttpServletRequest;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.easymock.EasyMock.*;

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
    }
    
    public Cinema cinema()
    {
        Cinema cinema = new Cinema();
        cinema.setNom("cinemaRecherche");
        return cinema;
    }
}
