package com.cineteam.cinebook.testsUnitaires.web.actions.film;

import com.cineteam.cinebook.web.film.ConsulterDetailFilmAction;
import com.cineteam.cinebook.testsUnitaires.web.actions.MockSeanceProvider;
import com.cineteam.cinebook.testsUnitaires.web.servlets.AddedParametersRequestWrapper;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.replay;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/** @author Vivien */
public class TestConsulterDetailFilm {
    
    private MockFilmProvider fauxProviderFilm ;
    private MockSeanceProvider fauxProviderSeance ;
    private HttpServletRequest request ;
    private ConsulterDetailFilmAction consulterDetailsFilmAction ;
    
    @Before
    public void setUp() {
        fauxProviderFilm = new MockFilmProvider();
        fauxProviderSeance = new MockSeanceProvider();
        consulterDetailsFilmAction = new ConsulterDetailFilmAction(fauxProviderFilm,fauxProviderSeance);
        request = createMock(HttpServletRequest.class);
        replay(request);
    }
        
    @Test
    public void neConsultePasDetailFilmSansFilmSaisi()
    {
        String film_id = "";
        request = new AddedParametersRequestWrapper(request, new HashMap());
        
        consulterDetailsFilmAction.execute(request);
        
        assertNull(fauxProviderFilm.getDetailFilm(film_id));
        assertNull(request.getAttribute("film"));
    }
    
    @Test
    public void consulteDetailFilmAvecFilmSaisi() {
        String film_id = "10";
        final Map parametres = new HashMap();
        parametres.put("cpt",film_id);
        request = new AddedParametersRequestWrapper(request, parametres);
        
        consulterDetailsFilmAction.execute(request);
        
        assertNotNull(fauxProviderFilm.getDetailFilm(film_id));
        assertNotNull(request.getAttribute("film"));
        assertNotNull(fauxProviderFilm.getDetailFilm(film_id).getSynopsis());
    }
    
    @Test
    public void nAffichePasLesCinemasEtLeursSeancesSansCodePostalRecherche()    {
        String film_id = "10";
        String cp_recherche = "";
        final Map parametres = new HashMap();
        parametres.put("cpt",film_id);
        parametres.put("recherche",cp_recherche);
        request = new AddedParametersRequestWrapper(request, parametres);
        
        consulterDetailsFilmAction.execute(request);
        
        assertTrue(fauxProviderSeance.getSeancesPourUnFilm(film_id,cp_recherche).isEmpty());
        assertNull(request.getAttribute("cinemas"));
    }
    
    @Test
    public void afficheLesCinemasEtLeursSeancesAvecCodePostalRecherche() {
        String film_id = "10";
        String cp_recherche = "33000";
        final Map parametres = new HashMap();
        parametres.put("cpt",film_id);
        parametres.put("recherche",cp_recherche);
        request = new AddedParametersRequestWrapper(request, parametres);
        
        consulterDetailsFilmAction.execute(request);
        
        assertTrue(!fauxProviderSeance.getSeancesPourUnFilm(film_id,cp_recherche).isEmpty());
        assertNotNull(request.getAttribute("cinemas"));
        assertNotNull(fauxProviderSeance.getSeancesPourUnFilm(film_id,cp_recherche).get(0).getSeances_films().get(0).getSeances().get(0).getFormat());
    }
    
}
