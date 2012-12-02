package com.cineteam.cinebook.web.testActions;

import com.cineteam.cinebook.web.actions.SidentifierAction;
import com.cineteam.cinebook.web.testServlets.AddedParametersRequestWrapper;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.junit.Before;
import org.junit.Test;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.replay;
import static org.junit.Assert.assertEquals;

/** @author alexis */
public class TestSidentifierAction 
{
    private HttpServletRequest request ;
    private SidentifierAction sidentifierAction;
    
    @Before
    public void setUp()
    {
        sidentifierAction = new SidentifierAction();
        request = createMock(HttpServletRequest.class);
        replay(request);
    }
    
    @Test
    public void retourneUnEchecSiPasDeLogin()
    {
        final Map parametres = new HashMap();
        parametres.put("motDePasse","mdp");
        request = new AddedParametersRequestWrapper(request, parametres);
        
        sidentifierAction.execute(request);
        
        assertEquals(true,request.getAttribute("echec_connexion"));
    }
    
    @Test
    public void retourneUnEchecSiPasDeMotDePasse()
    {
        final Map parametres = new HashMap();
        parametres.put("login","login");
        request = new AddedParametersRequestWrapper(request, parametres);
        
        sidentifierAction.execute(request);
        
        assertEquals(true,request.getAttribute("echec_connexion"));
    }
    
    @Test
    public void retourneUnEchecSiPasDeMotDePasseEtPasDeLogin()
    {
        final Map parametres = new HashMap();
        request = new AddedParametersRequestWrapper(request, parametres);
        
        sidentifierAction.execute(request);
        
        assertEquals(true,request.getAttribute("echec_connexion"));
    }
    
    @Test
    public void retournePasDEchecSiLoginEtMotDePasse()
    {
        final Map parametres = new HashMap();
        parametres.put("motDePasse","mdp");
        parametres.put("login", "login");
        request = new AddedParametersRequestWrapper(request, parametres);
        
        sidentifierAction.execute(request);
        
        assertEquals(false,request.getAttribute("echec_connexion"));
    }
    
    @Test
    public void retourneUnLoginDansLaSessionSiPasDEchec()
    {
        final Map parametres = new HashMap();
        parametres.put("motDePasse","mdp");
        parametres.put("login", "login");
        request = new AddedParametersRequestWrapper(request, parametres);
        
        sidentifierAction.execute(request);
        
        assertEquals("login",request.getSession().getAttribute("login"));
    }
    
}
