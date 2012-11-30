package com.cineteam.cinebook.web.testActions.cinema;

import com.cineteam.cinebook.web.actions.cinema.ConsulterDetailCinemaAction;
import com.cineteam.cinebook.web.testActions.MockSeanceProvider;
import com.cineteam.cinebook.web.testServlets.AddedParametersRequestWrapper;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.replay;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/** @author Cedric */
public class TestConsulterDetailCinema {
    
    private MockCinemaProvider fauxProviderCinema ;
    private MockSeanceProvider fauxProviderSeance ;
    private HttpServletRequest request ;
    private ConsulterDetailCinemaAction consulterDetailsCinemaAction ;
    
    @Before
    public void setUp() {
        fauxProviderCinema = new MockCinemaProvider();
        fauxProviderSeance = new MockSeanceProvider();
        consulterDetailsCinemaAction = new ConsulterDetailCinemaAction(fauxProviderCinema,fauxProviderSeance);
        request = createMock(HttpServletRequest.class);
        replay(request);
    }
        
    @Test
    public void neConsultePasDetailCinemaSansCinemaSaisi()
    {
        String cinema_id = "";
        final Map parametres = new HashMap();
        parametres.put("cpt",cinema_id);
        request = new AddedParametersRequestWrapper(request, parametres);
        
        consulterDetailsCinemaAction.execute(request);
        
        assertNull(fauxProviderCinema.getDetailCinema(cinema_id));
        assertTrue(fauxProviderSeance.getSeancesPourUnCinema(cinema_id).isEmpty());
        assertNull(request.getAttribute("cinema"));
    }
    
    @Test
    public void consulteDetailCinemaAvecCinemaSaisi() {
        String cinema_id = "10";
        final Map parametres = new HashMap();
        parametres.put("cpt",cinema_id);
        request = new AddedParametersRequestWrapper(request, parametres);
        
        consulterDetailsCinemaAction.execute(request);
        
        assertNotNull(fauxProviderCinema.getDetailCinema(cinema_id));
        assertTrue(!fauxProviderSeance.getSeancesPourUnCinema(cinema_id).isEmpty());
        assertNotNull(request.getAttribute("cinema"));
        assertNotNull(fauxProviderCinema.getDetailCinema(cinema_id).getNombre_salles());
        assertNotNull(fauxProviderSeance.getSeancesPourUnCinema(cinema_id).get(0).getSeances().get(0).getFormat());
    }
    
}
