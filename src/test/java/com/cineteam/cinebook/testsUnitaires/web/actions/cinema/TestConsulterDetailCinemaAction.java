package com.cineteam.cinebook.testsUnitaires.web.actions.cinema;

import com.cineteam.cinebook.model.entity.Commentaire_cinema;
import com.cineteam.cinebook.web.actions.cinema.ConsulterDetailCinemaAction;
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

/** @author Cedric */
public class TestConsulterDetailCinemaAction {
    
    private MockCinemaProvider fauxProviderCinema ;
    private MockSeanceProvider fauxProviderSeance ;
    private MockCommentaire_CinemaEntityManager fauxEntityManager;
    private HttpServletRequest request ;
    private ConsulterDetailCinemaAction consulterDetailsCinemaAction ;
    
    @Before
    public void setUp() {
        fauxProviderCinema = new MockCinemaProvider();
        fauxProviderSeance = new MockSeanceProvider();
        fauxEntityManager = new MockCommentaire_CinemaEntityManager();
        consulterDetailsCinemaAction = new ConsulterDetailCinemaAction(fauxProviderCinema,fauxProviderSeance,fauxEntityManager);
        request = createMock(HttpServletRequest.class);
        replay(request);
    }
        
    @Test
    public void neConsultePasDetailCinemaSansCinemaSaisi()
    {
        String cinema_id = "";
        request = new AddedParametersRequestWrapper(request, new HashMap());
        
        consulterDetailsCinemaAction.execute(request);
        
        assertNull(fauxProviderCinema.getDetailCinema(cinema_id));
        assertTrue(fauxProviderSeance.getSeancesPourUnCinema(cinema_id).isEmpty());
        assertNull(request.getAttribute("cinema"));
        assertNull(request.getAttribute("commentaires"));
        assertTrue(fauxEntityManager.rechercherCommentaires_cinema(cinema_id).isEmpty());
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
    
    @Test
    public void neListePasDeCommentairesSiPasDeCommentaire() {
        String cinema_id = "10";
        final Map parametres = new HashMap();
        parametres.put("cpt",cinema_id);
        request = new AddedParametersRequestWrapper(request, parametres);
        
        consulterDetailsCinemaAction.execute(request);
    
        assertNotNull(request.getAttribute("commentaires"));
        assertTrue(fauxEntityManager.rechercherCommentaires_cinema(cinema_id).isEmpty());
    }
    
    @Test
    public void listeLesCommentairesSiPresenceDeCommentaires() {
        String cinema_id = "10";
        final Map parametres = new HashMap();
        parametres.put("cpt",cinema_id);
        request = new AddedParametersRequestWrapper(request, parametres);
        Commentaire_cinema commentaire_cinema = new Commentaire_cinema();
        commentaire_cinema.setId_cinema(cinema_id);
        fauxEntityManager.commentaires_cinema.add(commentaire_cinema);
        
        consulterDetailsCinemaAction.execute(request);
    
        assertNotNull(request.getAttribute("commentaires"));
        assertTrue(!fauxEntityManager.rechercherCommentaires_cinema(cinema_id).isEmpty());
        assertNotNull(fauxEntityManager.rechercherCommentaires_cinema(cinema_id).get(0));
    }
}
