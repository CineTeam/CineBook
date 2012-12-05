package com.cineteam.cinebook.web.testActions.utilisateur;

import com.cineteam.cinebook.model.entity.Utilisateur;
import com.cineteam.cinebook.web.actions.utilisateur.SidentifierAction;
import com.cineteam.cinebook.web.testServlets.AddedParametersRequestWrapper;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.replay;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/** @author alexis */
public class TestSidentifierAction 
{
    private HttpServletRequest request ;
    private SidentifierAction sidentifierAction;
    private MockUtilisateurEntityManager fauxEntityManager;
    
    @Before
    public void setUp()
    {
        fauxEntityManager = new MockUtilisateurEntityManager();
        sidentifierAction = new SidentifierAction(fauxEntityManager);
        request = createMock(HttpServletRequest.class);
        replay(request);
    }
    
    @Test
    public void retourneUnEchecSiChampsVides()
    {
        final Map parametres = new HashMap();
        parametres.put("page_courante","index.jsp");
        request = new AddedParametersRequestWrapper(request, parametres);
        
        sidentifierAction.execute(request);
        
        assertEquals(true,request.getAttribute("echec_connexion"));
        assertNull(fauxEntityManager.rechercherUtilisateur(""));
        assertNull(request.getSession().getAttribute("utilisateur"));
    }
    
    @Test
    public void retourneUnEchecSiPasDeLogin()
    {
        final Map parametres = new HashMap();
        parametres.put("mdp","mdp");
        parametres.put("page_courante","index.jsp");
        request = new AddedParametersRequestWrapper(request, parametres);
        
        sidentifierAction.execute(request);
        
        assertEquals(true,request.getAttribute("echec_connexion"));
        assertNull(fauxEntityManager.rechercherUtilisateur(""));
        assertNull(request.getSession().getAttribute("utilisateur"));
    }
    
    @Test
    public void retourneUnEchecSiPasDeMotDePasse()
    {
        final Map parametres = new HashMap();
        parametres.put("login","login");
        parametres.put("page_courante","index.jsp");
        request = new AddedParametersRequestWrapper(request, parametres);
        
        sidentifierAction.execute(request);
        
        assertEquals(true,request.getAttribute("echec_connexion"));
        assertNull(fauxEntityManager.rechercherUtilisateur(""));
        assertNull(request.getSession().getAttribute("utilisateur"));
    }
    
    @Test
    public void retourneUnEchecSiUtilisateurNExistePas()
    {
        final Map parametres = new HashMap();
        parametres.put("login","login");
        parametres.put("mdp","mdp");
        parametres.put("page_courante","index.jsp");
        request = new AddedParametersRequestWrapper(request, parametres);
        
        sidentifierAction.execute(request);
        
        assertEquals(true,request.getAttribute("echec_connexion"));
        assertNull(fauxEntityManager.rechercherUtilisateur(""));
        assertNull(request.getSession().getAttribute("utilisateur"));
    }
    
    @Test
    public void retourneUnEchecSiMdpUtilisateurDifferentMdpSaisi()
    {
        String login = "login";
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setLogin(login);
        utilisateur.setMdp("motDePasse");
        fauxEntityManager.utilisateurs.add(utilisateur);
        final Map parametres = new HashMap();
        parametres.put("login", login);
        parametres.put("mdp","mdp");
        parametres.put("page_courante","index.jsp");
        request = new AddedParametersRequestWrapper(request, parametres);
        
        sidentifierAction.execute(request);
        
        assertEquals(true,request.getAttribute("echec_connexion"));
        assertNotNull(fauxEntityManager.rechercherUtilisateur(login));
        assertNull(request.getSession().getAttribute("utilisateur"));
    }
        
    @Test
    public void retourneUtilisateurSiLoginEtMotDePasseSaisisEtUtilisateurExisteEtMdpCorrect()
    {
        String login = "login";
        String mdp = "mdp";
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setLogin(login);
        utilisateur.setMdp(mdp);
        fauxEntityManager.utilisateurs.add(utilisateur);
        final Map parametres = new HashMap();
        parametres.put("login", login);
        parametres.put("mdp",mdp);
        parametres.put("page_courante","index.jsp");
        request = new AddedParametersRequestWrapper(request, parametres);
        
        sidentifierAction.execute(request);
        
        assertEquals(false,request.getAttribute("echec_connexion"));
        assertNotNull(fauxEntityManager.rechercherUtilisateur(login));
        assertNotNull(request.getSession().getAttribute("utilisateur"));
    }
    
    
}
