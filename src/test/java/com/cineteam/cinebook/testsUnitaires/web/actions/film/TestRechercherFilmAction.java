package com.cineteam.cinebook.testsUnitaires.web.actions.film;

import com.cineteam.cinebook.model.film.Film;
import com.cineteam.cinebook.testsUnitaires.web.servlets.AddedParametersRequestWrapper;
import com.cineteam.cinebook.web.film.RechercherFilmAction;
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

/** @author Berangere */
public class TestRechercherFilmAction {
  
    private MockFilmProvider fauxProvider ;
    private HttpServletRequest request ;
    private RechercherFilmAction rechercherFilmAction ;
    
    @Before
    public void setUp() {
        fauxProvider = new MockFilmProvider();
        rechercherFilmAction = new RechercherFilmAction(fauxProvider);
        request = createMock(HttpServletRequest.class);
        replay(request);
    }
    
    @Test
    public void neRecherchePasdeFilmSansParametreDeRecherche()
    {
        request = new AddedParametersRequestWrapper(request,new HashMap());
        
        rechercherFilmAction.execute(request);
        
        assertTrue(fauxProvider.rechercherFilmParMotCle("").isEmpty());        
        assertNull(request.getAttribute("films"));
    }
 
    @Test
    public void neRetournePasDeFilmSiPasDeFilm()
    {
        String param_recherche = "filmRecherche";
        final Map parametres = new HashMap();
        parametres.put("recherche",param_recherche);
        request = new AddedParametersRequestWrapper(request, parametres);   
        
        rechercherFilmAction.execute(request);
        
        assertTrue(fauxProvider.rechercherFilmParMotCle(param_recherche).isEmpty());       
        assertTrue(((List<Film>)request.getAttribute("films")).isEmpty());
    }
    
    @Test
    public void rechercheFilmAvecParametreDeRechercheEtFilms()
    {
        final Film film = new Film();
        film.setTitre("filmRecherche");
        fauxProvider.films.add(film);
        String param_recherche = "filmRecherche";
        final Map parametres = new HashMap();
        parametres.put("recherche",param_recherche);
        request = new AddedParametersRequestWrapper(request, parametres);   
        
        rechercherFilmAction.execute(request);
        
        assertTrue(!fauxProvider.rechercherFilmParMotCle(param_recherche).isEmpty()); 
        assertTrue(!((List<Film>)request.getAttribute("films")).isEmpty());
    }
    
}
