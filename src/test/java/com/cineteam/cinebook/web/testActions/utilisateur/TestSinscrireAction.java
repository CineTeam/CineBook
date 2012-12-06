package com.cineteam.cinebook.web.testActions.utilisateur;

import com.cineteam.cinebook.model.entity.Utilisateur;
import com.cineteam.cinebook.web.actions.utilisateur.SinscrireAction;
import com.cineteam.cinebook.web.testServlets.AddedParametersRequestWrapper;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.replay;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/** @author Berangere */
public class TestSinscrireAction {
    
    private HttpServletRequest request ;
    private SinscrireAction sinscrireAction;
    private MockUtilisateurEntityManager fauxEntityManager;
    
    @Before
    public void setUp()
    {
        fauxEntityManager = new MockUtilisateurEntityManager();
        sinscrireAction = new SinscrireAction(fauxEntityManager);
        request = createMock(HttpServletRequest.class);
        replay(request);
    }
    
    @Test
    public void retourneEchecSiAucunChampSaisi()
    {
        request = new AddedParametersRequestWrapper(request, new HashMap());
        
        sinscrireAction.execute(request);
        
        assertTrue(!((String)request.getAttribute("messageErreur")).isEmpty());
        assertEquals("Veuillez renseigner tous les champs.",request.getAttribute("messageErreur"));
        assertFalse(fauxEntityManager.utilisateurCree);
        assertNull(fauxEntityManager.rechercherUtilisateur(""));
    }
    
    @Test
    public void retourneEchecSiPasDePseudo()
    {
        final Map parametres = new HashMap();
        parametres.put("login","login");
        parametres.put("mdp","mdp");
        parametres.put("mdpConfirmation", "mdp");
        request = new AddedParametersRequestWrapper(request, parametres);
        
        sinscrireAction.execute(request);
        
        assertTrue(!((String)request.getAttribute("messageErreur")).isEmpty());
        assertEquals("Veuillez renseigner tous les champs.",request.getAttribute("messageErreur"));
        assertFalse(fauxEntityManager.utilisateurCree);
        assertNull(fauxEntityManager.rechercherUtilisateur("login"));
    }
    
    @Test
    public void retourneEchecSiPasDeLogin()
    {
        final Map parametres = new HashMap();
        parametres.put("pseudo","pseudo");
        parametres.put("mdp","mdp");
        parametres.put("mdpConfirmation", "mdp");
        request = new AddedParametersRequestWrapper(request, parametres);
        
        sinscrireAction.execute(request);
        
        assertTrue(!((String)request.getAttribute("messageErreur")).isEmpty());
        assertEquals("Veuillez renseigner tous les champs.",request.getAttribute("messageErreur"));
        assertFalse(fauxEntityManager.utilisateurCree);
        assertNull(fauxEntityManager.rechercherUtilisateur(""));
    }
    
    @Test
    public void retourneEchecSiPasDeMotDePasse()
    {
        final Map parametres = new HashMap();
        parametres.put("pseudo","pseudo");
        parametres.put("login","login");
        parametres.put("mdpConfirmation", "mdp");
        request = new AddedParametersRequestWrapper(request, parametres);
        
        sinscrireAction.execute(request);
        
        assertTrue(!((String)request.getAttribute("messageErreur")).isEmpty());
        assertEquals("Veuillez renseigner tous les champs.",request.getAttribute("messageErreur"));
        assertFalse(fauxEntityManager.utilisateurCree);
        assertNull(fauxEntityManager.rechercherUtilisateur("login"));
    }
    
    @Test
    public void retourneEchecSiPasDeMotDePasseConfirmation()
    {
        final Map parametres = new HashMap();
        parametres.put("pseudo","pseudo");
        parametres.put("login","login");
        parametres.put("mdp", "mdp");
        request = new AddedParametersRequestWrapper(request, parametres);
        
        sinscrireAction.execute(request);
        
        assertTrue(!((String)request.getAttribute("messageErreur")).isEmpty());
        assertEquals("Veuillez renseigner tous les champs.",request.getAttribute("messageErreur"));
        assertFalse(fauxEntityManager.utilisateurCree);
        assertNull(fauxEntityManager.rechercherUtilisateur("login"));
    }
    
    @Test
    public void retourneEchecSiLesMotsDePassesSontDifferents()
    {
        final Map parametres = new HashMap();
        parametres.put("login", "login");
        parametres.put("pseudo","pseudo");
        parametres.put("mdp", "mdp");
        parametres.put("mdpConfirmation", "mdpConfirm");
        request = new AddedParametersRequestWrapper(request, parametres);
        
        sinscrireAction.execute(request);
        
        assertTrue(!((String)request.getAttribute("messageErreur")).isEmpty());
        assertEquals("Les mots de passe saisis ne correspondent pas.",request.getAttribute("messageErreur"));
        assertFalse(fauxEntityManager.utilisateurCree);
        assertNull(fauxEntityManager.rechercherUtilisateur("login"));
    }
    
    @Test
    public void retourneEchecSiLoginDejaPris()
    {
        String login = "login";
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setLogin(login);
        fauxEntityManager.utilisateurs.add(utilisateur);
        final Map parametres = new HashMap();
        parametres.put("pseudo","pseudo");
        parametres.put("login",login);
        parametres.put("mdp","mdp");
        parametres.put("mdpConfirmation", "mdp");
        request = new AddedParametersRequestWrapper(request, parametres);
        
        sinscrireAction.execute(request);
        
        assertTrue(!((String)request.getAttribute("messageErreur")).isEmpty());
        assertEquals("Ce login est déjà utilisé.",request.getAttribute("messageErreur"));
        assertNotNull(fauxEntityManager.rechercherUtilisateur(login));
        assertFalse(fauxEntityManager.utilisateurCree);
    }
    
    @Test
    public void enregistreUtilisateurSiPseudoLoginMotDePasseEtConfirmationSontCorrects()
    {
        String login = "login";
        final Map parametres = new HashMap();
        parametres.put("pseudo", "pseudo");
        parametres.put("login", login);
        parametres.put("mdp","mdp");
        parametres.put("mdpConfirmation", "mdp");
        request = new AddedParametersRequestWrapper(request, parametres);
        
        sinscrireAction.execute(request);
        
        assertEquals(null,request.getAttribute("messageErreur"));
        assertTrue(fauxEntityManager.utilisateurCree);
        assertNotNull(fauxEntityManager.rechercherUtilisateur(login));
    }
    
    @Test
    public void redirigeSurJSPIndexSiPasDEchec()
    {
        final Map parametres = new HashMap();
        parametres.put("pseudo", "pseudo");
        parametres.put("login", "login");
        parametres.put("mdp","mdp");
        parametres.put("mdpConfirmation", "mdp");
        request = new AddedParametersRequestWrapper(request, parametres);
        
        assertEquals("index.jsp",sinscrireAction.execute(request));           
    }
    
    @Test
    public void redirigeSurJSPInscriptionSiEchec()
    {
        final Map parametres = new HashMap();
        parametres.put("login", "login");
        parametres.put("mdp","mdp");
        parametres.put("mdpConfirmation", "mdpConfirm");
        request = new AddedParametersRequestWrapper(request, parametres);
        
        assertEquals("inscription.jsp",sinscrireAction.execute(request));           
    }
 
    
}
