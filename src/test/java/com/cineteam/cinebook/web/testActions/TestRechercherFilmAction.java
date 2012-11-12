package com.cineteam.cinebook.web.testActions;

import com.cineteam.cinebook.model.entity.Film;
import com.cineteam.cinebook.web.actions.RechercherFilmAction;
import com.cineteam.cinebook.web.testServlets.AddedParametersRequestWrapper;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.replay;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/** @author ikram */
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
        final Map parametres = new HashMap();
        parametres.put("recherche","");
        request = new AddedParametersRequestWrapper(request, parametres);
        
        rechercherFilmAction.execute(request);
        
        assertTrue(fauxProvider.getFilmsParNom("").isEmpty());
    }
 
    @Test
    public void rechercheFilmAvecParametreDeRecherche()
    {
        final Film film = film();
        fauxProvider.films.add(film);
        String param_recherche = "filmRecherche";
        final Map parametres = new HashMap();
        parametres.put("recherche",param_recherche);
        request = new AddedParametersRequestWrapper(request, parametres);   
        
        rechercherFilmAction.execute(request);
        
        assertTrue(!fauxProvider.getFilmsParNom(param_recherche).isEmpty());
    }
    
    public Film film()
    {
        Film film = new Film();
        film.setTitre("filmRecherche");
        return film;
    }
}
