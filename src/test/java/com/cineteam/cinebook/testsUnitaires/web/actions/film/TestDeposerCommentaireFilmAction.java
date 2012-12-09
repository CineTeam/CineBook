package com.cineteam.cinebook.testsUnitaires.web.actions.film;

import com.cineteam.cinebook.model.utilisateur.Utilisateur;
import com.cineteam.cinebook.testsUnitaires.web.servlets.AddedParametersRequestWrapper;
import com.cineteam.cinebook.web.film.DeposerCommentaireFilmAction;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.replay;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/** @author alexis */
public class TestDeposerCommentaireFilmAction 
{
    private MockCommentaireFilmEntityManager fauxEntityManager;
    private HttpServletRequest request ;
    private DeposerCommentaireFilmAction deposerCommentaireFilmAction ;
    
    @Before
    public void setUp() {
        fauxEntityManager = new MockCommentaireFilmEntityManager();
        deposerCommentaireFilmAction = new DeposerCommentaireFilmAction(fauxEntityManager);
        request = createMock(HttpServletRequest.class);
        replay(request);
    }
    
    @Test
    public void neDeposePasDeCommentaireSiNAPasSaisiTexte()
    {
        String filmId = "10";
        final Map parametres = new HashMap();
        parametres.put("cpt",filmId);
        request = new AddedParametersRequestWrapper(request, parametres);
        request.getSession().setAttribute("utilisateur", new Utilisateur());
        int nombres_commentaires = fauxEntityManager.rechercherCommentairesFilm(filmId).size();
        
        deposerCommentaireFilmAction.execute(request);
        
        assertFalse(fauxEntityManager.commentaireFilmCree);
        assertNotNull(fauxEntityManager.rechercherCommentairesFilm(filmId).size() == nombres_commentaires);
    }
    
    @Test
    public void neDeposePasDeCommentaireSiNEstPasIdentifie()
    {
        String film_id = "10";
        final Map parametres = new HashMap();
        parametres.put("cpt",film_id);
        parametres.put("champ_commentaire","texte");
        request = new AddedParametersRequestWrapper(request, parametres);
        int nombres_commentaires = fauxEntityManager.rechercherCommentairesFilm(film_id).size();
        
        deposerCommentaireFilmAction.execute(request);
        
        assertFalse(fauxEntityManager.commentaireFilmCree);
        assertTrue(fauxEntityManager.rechercherCommentairesFilm(film_id).size() == nombres_commentaires);
    }
    
    @Test
    public void deposeUnCommentaireSiEstConnecteEtASaisiTexte()
    {
        String filmId = "10";
        final Map parametres = new HashMap();
        parametres.put("cpt",filmId);
        parametres.put("champ_commentaire","texte");
        request = new AddedParametersRequestWrapper(request, parametres);
        request.getSession().setAttribute("utilisateur", new Utilisateur());
        int nombres_commentaires = fauxEntityManager.rechercherCommentairesFilm(filmId).size();
        
        deposerCommentaireFilmAction.execute(request);
        
        assertTrue(fauxEntityManager.commentaireFilmCree);
        assertTrue(fauxEntityManager.rechercherCommentairesFilm(filmId).size() == nombres_commentaires+1);
    }
}
