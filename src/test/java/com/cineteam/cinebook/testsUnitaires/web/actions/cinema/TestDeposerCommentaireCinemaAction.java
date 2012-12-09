package com.cineteam.cinebook.testsUnitaires.web.actions.cinema;

import com.cineteam.cinebook.model.utilisateur.Utilisateur;
import com.cineteam.cinebook.testsUnitaires.web.servlets.AddedParametersRequestWrapper;
import com.cineteam.cinebook.web.cinema.DeposerCommentaireCinemaAction;
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
    
    private MockCommentaireCinemaEntityManager fauxEntityManager;
    private HttpServletRequest request ;
    private DeposerCommentaireCinemaAction deposerCommentaireCinemaAction ;
    
    @Before
    public void setUp() {
        fauxEntityManager = new MockCommentaireCinemaEntityManager();
        deposerCommentaireCinemaAction = new DeposerCommentaireCinemaAction(fauxEntityManager);
        request = createMock(HttpServletRequest.class);
        replay(request);
    }
    
    @Test
    public void neDeposePasDeCommentaireSiNAPasSaisiTexte()
    {
        String cinema_id="10";
        final Map parametres = new HashMap();
        parametres.put("cpt",cinema_id);
        request = new AddedParametersRequestWrapper(request, parametres);
        request.getSession().setAttribute("utilisateur", new Utilisateur());
        int nombres_commentaires = fauxEntityManager.rechercherCommentaires_cinema(cinema_id).size();
        
        deposerCommentaireCinemaAction.execute(request);
        
        assertFalse(fauxEntityManager.commentaire_cinemaCree);
        assertNotNull(fauxEntityManager.rechercherCommentaires_cinema(cinema_id).size() == nombres_commentaires);
    }
    
    @Test
    public void neDeposePasDeCommentaireSiNEstPasIdentifie()
    {
        String cinema_id="10";
        final Map parametres = new HashMap();
        parametres.put("cpt",cinema_id);
        parametres.put("champ_commentaire","texte");
        request = new AddedParametersRequestWrapper(request, parametres);
        int nombres_commentaires = fauxEntityManager.rechercherCommentaires_cinema(cinema_id).size();
        
        deposerCommentaireCinemaAction.execute(request);
        
        assertFalse(fauxEntityManager.commentaire_cinemaCree);
        assertTrue(fauxEntityManager.rechercherCommentaires_cinema(cinema_id).size() == nombres_commentaires);
    }
    
    @Test
    public void deposeUnCommentaireSiEstConnecteEtASaisiTexte()
    {
        String cinema_id="10";
        final Map parametres = new HashMap();
        parametres.put("cpt",cinema_id);
        parametres.put("champ_commentaire","texte");
        request = new AddedParametersRequestWrapper(request, parametres);
        request.getSession().setAttribute("utilisateur", new Utilisateur());
        int nombres_commentaires = fauxEntityManager.rechercherCommentaires_cinema(cinema_id).size();
        
        deposerCommentaireCinemaAction.execute(request);
        
        assertTrue(fauxEntityManager.commentaire_cinemaCree);
        assertTrue(fauxEntityManager.rechercherCommentaires_cinema(cinema_id).size() == nombres_commentaires+1);
    }
}
