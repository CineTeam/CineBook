package com.cineteam.cinebook.web.testActions;

import com.cineteam.cinebook.model.entity.Film;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.replay;
import com.cineteam.cinebook.web.actions.RecupererLesDixDerniersFilmsSortisAction;
import com.cineteam.cinebook.web.testServlets.AddedParametersRequestWrapper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Cedric
 */
public class TestRecupererLesDixDerniersFilmsSortisAction {
    
    private MockFilmProvider fauxProvider;
    private HttpServletRequest request;
    private RecupererLesDixDerniersFilmsSortisAction recupererLesDixDerniersFilmsSortisAction;
    
    @Before
    public void setUp() {
        fauxProvider = new MockFilmProvider();
        recupererLesDixDerniersFilmsSortisAction = new RecupererLesDixDerniersFilmsSortisAction(fauxProvider);
        request = createMock(HttpServletRequest.class);
        replay(request);
    }
    
    @Test
    public void recupereDixFilms() {
        
        for(int i=0; i < 10; i++){
            fauxProvider.films.add(film());
        }
        
        request = new AddedParametersRequestWrapper(request);   
        
        recupererLesDixDerniersFilmsSortisAction.execute(request);
        
        assertEquals(fauxProvider.getDixDerniersFilms().size(), 10);
    }

    public Film film() {
        return new Film();
    }
    
}
