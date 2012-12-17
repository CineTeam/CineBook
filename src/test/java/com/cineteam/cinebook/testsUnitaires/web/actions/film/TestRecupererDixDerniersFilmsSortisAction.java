package com.cineteam.cinebook.testsUnitaires.web.actions.film;

import com.cineteam.cinebook.model.film.Film;
import com.cineteam.cinebook.testsUnitaires.web.servlets.AddedParametersRequestWrapper;
import com.cineteam.cinebook.web.film.RecupererDixDerniersFilmsSortisAction;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.replay;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/** @author Cedric */
public class TestRecupererDixDerniersFilmsSortisAction {
    
    private MockFilmProvider fauxProvider;
    private HttpServletRequest request;
    private RecupererDixDerniersFilmsSortisAction recupererDixDerniersFilmsSortisAction;
    
    @Before
    public void setUp() {
        fauxProvider = new MockFilmProvider();
        recupererDixDerniersFilmsSortisAction = new RecupererDixDerniersFilmsSortisAction(fauxProvider);
        request = createMock(HttpServletRequest.class);
        replay(request);
    }
            
    @Test
    public void neRetournePasDeFilmSiPasDeFilm() 
    {
        request = new AddedParametersRequestWrapper(request);   
        
        recupererDixDerniersFilmsSortisAction.execute(request);
        
        assertTrue(fauxProvider.getDixDerniersFilms().isEmpty());  
        assertTrue(((List<Film>)request.getAttribute("derniersFilmsSortis")).isEmpty());
    }
        
    @Test
    public void recupereDixFilms() 
    {
        for(int i=0; i < 10; i++){
            fauxProvider.films.add(new Film());
        }
        request = new AddedParametersRequestWrapper(request);   
        
        recupererDixDerniersFilmsSortisAction.execute(request);
        
        assertEquals(fauxProvider.getDixDerniersFilms().size(), 10);
        assertTrue(!((List<Film>)request.getAttribute("derniersFilmsSortis")).isEmpty());
    }
    
}
