package com.cineteam.cinebook.testsUnitaires.web.actions.cinema;

import com.cineteam.cinebook.model.cinema.CinemaFrequente;
import com.cineteam.cinebook.model.utilisateur.Utilisateur;
import com.cineteam.cinebook.testsUnitaires.web.servlets.AddedParametersRequestWrapper;
import com.cineteam.cinebook.web.cinema.AjouterCinemaAuxCinemasFrequentesAction;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.replay;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/** @author Bérangère */
public class TestAjouterCinemaAuxCinemaFrequentesAction {

    private MockCinemaFrequenteEntityManager fauxEntityManager;
    private HttpServletRequest request ;
    private AjouterCinemaAuxCinemasFrequentesAction ajouterCinemaAuxCinemasFrequentesAction ;
    
    @Before
    public void setUp() {
        fauxEntityManager = new MockCinemaFrequenteEntityManager();
        ajouterCinemaAuxCinemasFrequentesAction = new AjouterCinemaAuxCinemasFrequentesAction(fauxEntityManager);
        request = createMock(HttpServletRequest.class);
        replay(request);
    }
        
    @Test
    public void nEnregistrePasCinemaFrequenteSiUtilisateurNonConnecteEtCinemaNonSaisi()
    {
        request = new AddedParametersRequestWrapper(request,new HashMap());
        
        ajouterCinemaAuxCinemasFrequentesAction.execute(request);
        
        assertFalse(fauxEntityManager.cinemaFrequenteEnregistre);
        assertTrue(fauxEntityManager.rechercherCinemasFrequentes(new Long(0)).isEmpty());
    }
    
    @Test
    public void nEnregistrePasCinemaFrequenteSiCinemaNonSaisi()
    {
        request = new AddedParametersRequestWrapper(request,new HashMap());
        final Utilisateur utilisateur = utilisateur();
        request.getSession().setAttribute("utilisateur",utilisateur);       
        
        ajouterCinemaAuxCinemasFrequentesAction.execute(request);
        
        assertFalse(fauxEntityManager.cinemaFrequenteEnregistre);
        assertTrue(fauxEntityManager.rechercherCinemasFrequentes(utilisateur.getId()).isEmpty());
    }
    
    @Test
    public void nEnregistrePasCinemaFrequenteSiUtilisateurNonConnecte()
    {
        final Map parametres = new HashMap();
        parametres.put("cpt","id_cinema");
        request = new AddedParametersRequestWrapper(request, parametres);   
        
        ajouterCinemaAuxCinemasFrequentesAction.execute(request);
        
        assertFalse(fauxEntityManager.cinemaFrequenteEnregistre);
        assertTrue(fauxEntityManager.rechercherCinemasFrequentes(new Long(0)).isEmpty());
    }
    
    @Test
    public void nEnregistrePasCinemaSiDejaDansLaListe()
    {
        String idCinema = "id_cinema";
        final Map parametres = new HashMap();
        parametres.put("cpt",idCinema);
        request = new AddedParametersRequestWrapper(request, parametres);    
        final Utilisateur utilisateur = utilisateur();
        request.getSession().setAttribute("utilisateur",utilisateur); 
        CinemaFrequente cinemaFrequente = new CinemaFrequente();
        cinemaFrequente.setId_cinema(idCinema);
        cinemaFrequente.setId_utilisateur(utilisateur.getId());
        fauxEntityManager.cinemasFrequentes.add(cinemaFrequente);
        
        ajouterCinemaAuxCinemasFrequentesAction.execute(request);
        
        assertFalse(fauxEntityManager.cinemaFrequenteEnregistre);
        assertTrue(fauxEntityManager.rechercherCinemasFrequentes(new Long(0)).isEmpty());
    }
    
    @Test
    public void enregistreCinemaFrequenteSiUtilisateurConnecteEtCinemaSaisi()
    {
        final Map parametres = new HashMap();
        parametres.put("cpt","id_cinema");
        request = new AddedParametersRequestWrapper(request, parametres);   
        final Utilisateur utilisateur = utilisateur();
        request.getSession().setAttribute("utilisateur",utilisateur); 
        
        ajouterCinemaAuxCinemasFrequentesAction.execute(request);
        
        assertTrue(fauxEntityManager.cinemaFrequenteEnregistre);
        assertTrue(!fauxEntityManager.rechercherCinemasFrequentes(utilisateur.getId()).isEmpty());
        assertNotNull(fauxEntityManager.rechercherCinemasFrequentes(utilisateur.getId()).get(0));
        assertEquals(fauxEntityManager.rechercherCinemasFrequentes(utilisateur.getId()).get(0).getId_cinema(),"id_cinema");
        assertEquals(fauxEntityManager.rechercherCinemasFrequentes(utilisateur.getId()).get(0).getId_utilisateur(),utilisateur.getId());
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
