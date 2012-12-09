package com.cineteam.cinebook.testsUnitaires.web.actions.utilisateur;

import com.cineteam.cinebook.model.utilisateur.Utilisateur;
import com.cineteam.cinebook.testsUnitaires.web.servlets.AddedParametersRequestWrapper;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.replay;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import com.cineteam.cinebook.web.utilisateur.ModifierUtilisateurAction;

/** @author CrazyKoala */
public class TestModifierUtilisateurAction {
    
    private HttpServletRequest request ;
    private ModifierUtilisateurAction modifierUtilisateurAction;
    private MockUtilisateurEntityManager fauxEntityManager;
    
    @Before
    public void setUp()
    {
        fauxEntityManager = new MockUtilisateurEntityManager();
        modifierUtilisateurAction = new ModifierUtilisateurAction(fauxEntityManager);
        request = createMock(HttpServletRequest.class);
        replay(request);
    }
    
    @Test
    public void modifieUtilisateur()
    {
        final Map parametres = new HashMap();
        parametres.put("adresse","adresse");
        parametres.put("code_postal","33000");
        parametres.put("ville", "ville");
        request = new AddedParametersRequestWrapper(request, parametres);
        request.getSession().setAttribute("utilisateur", new Utilisateur());        
        
        modifierUtilisateurAction.execute(request);
        Utilisateur uti = (Utilisateur) request.getSession().getAttribute("utilisateur");
        assertNotNull(uti);
        assertEquals(uti.getAdresse(),"adresse");
        assertEquals(uti.getCode_postal(),"33000");
        assertEquals(uti.getVille(),"ville");
    }
        
}
