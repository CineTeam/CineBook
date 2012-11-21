package com.cineteam.cinebook.web.testActions;

import com.cineteam.cinebook.model.entity.Cinema;
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
    public void recupererDetailCinema() {
        final Cinema cinema = fauxProvider.getDetailCinema(cinema().getId());
        String cinema_ID = "10";
        final Map parametres = new HashMap();
        parametres.put("cinema_ID",cinema_ID);
        request = new AddedParametersRequestWrapper(request, parametres);
        consulterDetailsCinemaAction.execute(request);
        
        assertTrue(fauxProvider.getDetailCinema(cinema_ID) != null);
    }
    
    public Cinema cinema() {
        Cinema cinema = new Cinema();
        cinema.setId("10");
        return cinema;
    }
}
