package com.cineteam.cinebook.web.testActions.cinema;

import com.cineteam.cinebook.web.actions.cinema.ConsulterDetailCinemaAction;
import com.cineteam.cinebook.web.actions.cinema.DeposerCommentaireCinemaAction;
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
public class TestDeposerCommentaireCinemaAction {
    
    private MockCinemaProvider fauxProviderCinema ;
    private MockSeanceProvider fauxProviderSeance ;
    private MockCommentaire_CinemaEntityManager fauxEntityManager;
    private HttpServletRequest request ;
    private ConsulterDetailCinemaAction consulterDetailsCinemaAction ;
    private DeposerCommentaireCinemaAction deposerCommentaireCinemaAction ;
    
    @Before
    public void setUp() {
        fauxProviderCinema = new MockCinemaProvider();
        fauxProviderSeance = new MockSeanceProvider();
        fauxEntityManager = new MockCommentaire_CinemaEntityManager();
        consulterDetailsCinemaAction = new ConsulterDetailCinemaAction(fauxProviderCinema,fauxProviderSeance,fauxEntityManager);
        deposerCommentaireCinemaAction = new DeposerCommentaireCinemaAction(fauxEntityManager);
        request = createMock(HttpServletRequest.class);
        replay(request);
    }
    
    @Test
    public void deposeUnCommentaireEnTantQueMembre()
    {
        String cinema_id = "10";
        final Map parametres = new HashMap();
        parametres.put("cpt",cinema_id);
        request = new AddedParametersRequestWrapper(request, parametres);
        int nombres_commentaires = fauxEntityManager.rechercherCommentaires_cinema(cinema_id).size();
        
        deposerCommentaireCinemaAction.execute(request);
        
        assertNotNull(fauxEntityManager.rechercherCommentaires_cinema(cinema_id));
        assertNotNull(fauxEntityManager.rechercherCommentaires_cinema(cinema_id).size() > nombres_commentaires);
    }
}
