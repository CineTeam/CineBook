package com.cineteam.cinebook.web.testActions;

import com.cineteam.cinebook.web.actions.ConsulterDetailFilmAction;
import com.cineteam.cinebook.web.testServlets.AddedParametersRequestWrapper;
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
    
    private MockFilmProvider fauxProvider ;
    private HttpServletRequest request ;
    private ConsulterDetailFilmAction consulterDetailsFilmAction ;
    
    @Before
    public void setUp() {
        fauxProvider = new MockFilmProvider();
        consulterDetailsFilmAction = new ConsulterDetailFilmAction(fauxProvider);
        request = createMock(HttpServletRequest.class);
        replay(request);
    }
        
    @Test
    public void neConsultePasDetailFilmSansFilmSaisi()
    {
        String film_id = "";
        final Map parametres = new HashMap();
        parametres.put("cpt",film_id);
        request = new AddedParametersRequestWrapper(request, parametres);
        
        consulterDetailsFilmAction.execute(request);
        
        assertNull(fauxProvider.getDetailFilm(film_id));
        assertNull(request.getAttribute("film"));
    }
    
    @Test
    public void consulteDetailFilmAvecFilmSaisi() {
        String film_id = "10";
        final Map parametres = new HashMap();
        parametres.put("cpt",film_id);
        request = new AddedParametersRequestWrapper(request, parametres);
        
        consulterDetailsFilmAction.execute(request);
        
        assertNotNull(fauxProvider.getDetailFilm(film_id));
        assertNotNull(request.getAttribute("film"));
        assertNotNull(fauxProvider.getDetailFilm(film_id).getSynopsis());
    }
    
}
