package com.cineteam.cinebook.web.testActions;

import com.cineteam.cinebook.web.actions.SinscrireAction;
import com.cineteam.cinebook.web.testServlets.AddedParametersRequestWrapper;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.junit.Before;
import org.junit.Test;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.replay;
import static org.junit.Assert.assertEquals;


public class TestSinscrireAction {
    
    private HttpServletRequest request ;
    private SinscrireAction sinscrireAction;
    
    @Before
    public void setUp()
    {
        sinscrireAction = new SinscrireAction();
        request = createMock(HttpServletRequest.class);
        replay(request);
    }
 
    @Test
    public void retourneEchecSiPasDeLogin()
    {
        final Map parametres = new HashMap();
        
        parametres.put("motDePasse","mdp");
        parametres.put("motDePasseConfirmation", "mdp");
        request = new AddedParametersRequestWrapper(request, parametres);
        
        sinscrireAction.execute(request);
        assertEquals(true,request.getAttribute("echec_inscription"));
    }
    
     @Test
    public void retourneEchecSiPasDeMotDePasse()
    {
        final Map parametres = new HashMap();
        
        parametres.put("login","login");
        parametres.put("motDePasseConfirmation", "mdp");
        request = new AddedParametersRequestWrapper(request, parametres);
        
        sinscrireAction.execute(request);
        assertEquals(true,request.getAttribute("echec_inscription"));
    }
    
    @Test
    public void retourneEchecSiPasDeMotDePasseConfirmation()
    {
        final Map parametres = new HashMap();
        
        parametres.put("login","login");
        parametres.put("motDePasse", "mdp");
        request = new AddedParametersRequestWrapper(request, parametres);
        
        sinscrireAction.execute(request);
        assertEquals(true,request.getAttribute("echec_inscription"));
    }
    
    @Test
    public void retourneEchecSiLesMotsDePassesDifferents()
    {
        final Map parametres = new HashMap();
        parametres.put("login", "login");
        parametres.put("motDePasse", "mdp");
        parametres.put("motDePasseConfirmation", "mdpConfirm");
        request = new AddedParametersRequestWrapper(request, parametres);
        
        sinscrireAction.execute(request);
        assertEquals(true,request.getAttribute("echec_inscription"));
    }
     
    @Test
    public void retournePasDEchecSiLoginMotDePasseEtConfirmationCorrecte()
    {
        final Map parametres = new HashMap();
        parametres.put("login", "login");
        parametres.put("motDePasse","mdp");
        parametres.put("motDePasseConfirmation", "mdp");
        request = new AddedParametersRequestWrapper(request, parametres);
        
        sinscrireAction.execute(request);
        
        assertEquals(false,request.getAttribute("echec_inscription"));
    }
    
     @Test
    public void redirigeSurIndexSiPasDEchec()
    {
        final Map parametres = new HashMap();
        parametres.put("login", "login");
        parametres.put("motDePasse","mdp");
        parametres.put("motDePasseConfirmation", "mdp");
        request = new AddedParametersRequestWrapper(request, parametres);
        
        assertEquals("index.jsp",sinscrireAction.execute(request));           
    }
    
     @Test
    public void redirigeSurInscriptionSiEchec()
    {
        final Map parametres = new HashMap();
        parametres.put("login", "login");
        parametres.put("motDePasse","mdp");
        parametres.put("motDePasseConfirmation", "mdpConfirm");
        request = new AddedParametersRequestWrapper(request, parametres);
        
        assertEquals("inscription.jsp",sinscrireAction.execute(request));           
    }
     
    @Test
    public void RetourneBonMessageDErreurSiMotDePassesDifferents()
    {
        final Map parametres = new HashMap();
        parametres.put("login", "login");
        parametres.put("motDePasse","mdp");
        parametres.put("motDePasseConfirmation", "mdpConfirm");
        request = new AddedParametersRequestWrapper(request, parametres);
        sinscrireAction.execute(request);
        
        assertEquals("Les mots de passe saisies ne correspondent pas.",request.getAttribute("erreur"));           
    }
     
    @Test
    public void RetourneBonMessageDErreurSiChampsManquants()
    {
        final Map parametres = new HashMap();
        
        parametres.put("motDePasse","mdp");
        parametres.put("motDePasseConfirmation", "mdp");
        request = new AddedParametersRequestWrapper(request, parametres);
        sinscrireAction.execute(request);
        
        assertEquals("Veuillez renseigner tous les champs.",request.getAttribute("erreur"));           
    }
    
     @Test
    public void retourneUnLoginDansLaSessionSiPasDEchec()
    {
        final Map parametres = new HashMap();
        parametres.put("login", "login");
        parametres.put("motDePasse","mdp");
        parametres.put("motDePasseConfirmation", "mdp");
        request = new AddedParametersRequestWrapper(request, parametres);
        
        sinscrireAction.execute(request);
        
        assertEquals("login",request.getSession().getAttribute("login"));
    }
    
}
