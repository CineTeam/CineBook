package com.cineteam.cinebook.web.testActions.film;

import com.cineteam.cinebook.model.entity.Film;
import com.cineteam.cinebook.web.actions.film.RecupererDixDerniersFilmsSortisAction;
import com.cineteam.cinebook.web.testServlets.AddedParametersRequestWrapper;
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
            fauxProvider.films.add(film());
        }
        request = new AddedParametersRequestWrapper(request);   
        
        recupererDixDerniersFilmsSortisAction.execute(request);
        
        assertEquals(fauxProvider.getDixDerniersFilms().size(), 10);
        assertTrue(!((List<Film>)request.getAttribute("derniersFilmsSortis")).isEmpty());
    }

    public Film film() {
        return new Film();
    }
    
}
