package com.cineteam.cinebook.web.testActions;

import com.cineteam.cinebook.web.actions.ConsulterDetailCinemaAction;
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
    
    private MockCinemaProvider fauxProvider ;
    private HttpServletRequest request ;
    private ConsulterDetailCinemaAction consulterDetailsCinemaAction ;
    
    @Before
    public void setUp() {
        fauxProvider = new MockCinemaProvider();
        consulterDetailsCinemaAction = new ConsulterDetailCinemaAction(fauxProvider);
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
        
        assertNull(fauxProvider.getDetailCinema(cinema_id));
        assertNull(request.getAttribute("cinema"));
    }
    
    @Test
    public void consulteDetailCinemaAvecCinemaSaisi() {
        String cinema_id = "10";
        final Map parametres = new HashMap();
        parametres.put("cpt",cinema_id);
        request = new AddedParametersRequestWrapper(request, parametres);
        
        consulterDetailsCinemaAction.execute(request);
        
        assertNotNull(fauxProvider.getDetailCinema(cinema_id));
        assertNotNull(request.getAttribute("cinema"));
        assertNotNull(fauxProvider.getDetailCinema(cinema_id).getNombre_salles());
    }
    
}
