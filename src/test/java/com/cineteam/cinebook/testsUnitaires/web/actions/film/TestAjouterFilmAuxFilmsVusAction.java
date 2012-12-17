package com.cineteam.cinebook.testsUnitaires.web.actions.film;

import com.cineteam.cinebook.model.film.FilmVu;
import com.cineteam.cinebook.model.utilisateur.Utilisateur;
import com.cineteam.cinebook.testsUnitaires.web.servlets.AddedParametersRequestWrapper;
import com.cineteam.cinebook.web.film.AjouterFilmAuxFilmsVusAction;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.replay;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/** @author Bérangère */
public class TestAjouterFilmAuxFilmsVusAction {

    private MockFilmVuEntityManager fauxEntityManager;
    private HttpServletRequest request ;
    private AjouterFilmAuxFilmsVusAction ajouterFilmAuxFilmsVusAction ;
    
    @Before
    public void setUp() {
        fauxEntityManager = new MockFilmVuEntityManager();
        ajouterFilmAuxFilmsVusAction = new AjouterFilmAuxFilmsVusAction(fauxEntityManager);
        request = createMock(HttpServletRequest.class);
        replay(request);
    }
        
    @Test
    public void neEnregistrePasFilmVuSiUtilisateurNonConnecteEtFilmNonSaisi()
    {
        request = new AddedParametersRequestWrapper(request);
        
        ajouterFilmAuxFilmsVusAction.execute(request);
        
        assertFalse(fauxEntityManager.filmVuEnregistre);
        assertTrue(fauxEntityManager.rechercherFilmsVus(new Long(0)).isEmpty());
    }
    
    @Test
    public void nEnregistrePasFilmVuSiFilmNonSaisi()
    {
        request = new AddedParametersRequestWrapper(request);
        final Utilisateur utilisateur = utilisateur();
        request.getSession().setAttribute("utilisateur",utilisateur);       
        
        ajouterFilmAuxFilmsVusAction.execute(request);
        
        assertFalse(fauxEntityManager.filmVuEnregistre);
        assertTrue(fauxEntityManager.rechercherFilmsVus(utilisateur.getId()).isEmpty());
    }
    
    @Test
    public void nEnregistrePasFilmVuSiUtilisateurNonConnecte()
    {
        final Map parametres = new HashMap();
        parametres.put("cpt","id_film");
        request = new AddedParametersRequestWrapper(request, parametres);   
        
        ajouterFilmAuxFilmsVusAction.execute(request);
        
        assertFalse(fauxEntityManager.filmVuEnregistre);
        assertTrue(fauxEntityManager.rechercherFilmsVus(new Long(0)).isEmpty());
    }
    
    @Test
    public void nEnregistrePasFilmSiDejaDansLaListe()
    {
        String idFilm = "id_film";
        final Map parametres = new HashMap();
        parametres.put("cpt",idFilm);
        request = new AddedParametersRequestWrapper(request, parametres);    
        final Utilisateur utilisateur = utilisateur();
        request.getSession().setAttribute("utilisateur",utilisateur); 
        FilmVu filmVu = new FilmVu();
        filmVu.setId_film(idFilm);
        filmVu.setId_utilisateur(utilisateur.getId());
        fauxEntityManager.filmsVus.add(filmVu);
        
        ajouterFilmAuxFilmsVusAction.execute(request);
        
        assertFalse(fauxEntityManager.filmVuEnregistre);
        assertTrue(fauxEntityManager.rechercherFilmsVus(new Long(0)).isEmpty());
    }
    
    @Test
    public void enregistreFilmVuSiUtilisateurConnecteEtFilmSaisi()
    {
        final Map parametres = new HashMap();
        parametres.put("cpt","id_film");
        request = new AddedParametersRequestWrapper(request, parametres);   
        final Utilisateur utilisateur = utilisateur();
        request.getSession().setAttribute("utilisateur",utilisateur); 
        
        ajouterFilmAuxFilmsVusAction.execute(request);
        
        assertTrue(fauxEntityManager.filmVuEnregistre);
        assertTrue(!fauxEntityManager.rechercherFilmsVus(utilisateur.getId()).isEmpty());
        assertNotNull(fauxEntityManager.rechercherFilmsVus(utilisateur.getId()).get(0));
        assertEquals(fauxEntityManager.rechercherFilmsVus(utilisateur.getId()).get(0).getId_film(),"id_film");
        assertEquals(fauxEntityManager.rechercherFilmsVus(utilisateur.getId()).get(0).getId_utilisateur(),utilisateur.getId());
    }
    
    private Utilisateur utilisateur(){
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(new Long(1));
        utilisateur.setLogin("login");
        utilisateur.setPseudo("pseudo");
        utilisateur.setMdp("mdp");
        return utilisateur;
    }
}
