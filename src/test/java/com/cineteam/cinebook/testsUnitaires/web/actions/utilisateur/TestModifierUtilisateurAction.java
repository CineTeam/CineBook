package com.cineteam.cinebook.testsUnitaires.web.actions.utilisateur;

import com.cineteam.cinebook.model.utilisateur.Utilisateur;
import com.cineteam.cinebook.testsUnitaires.web.servlets.AddedParametersRequestWrapper;
import com.cineteam.cinebook.web.utilisateur.ModifierUtilisateurAction;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.replay;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/** @author Ikram */
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
    public void neModifiePasAdresseDeLUtilisateurSiAucunChampSaisi()
    {
        final Utilisateur utilisateur = utilisateur();
        fauxEntityManager.creerUtilisateur(utilisateur);
        request = new AddedParametersRequestWrapper(request, new HashMap());
        request.getSession().setAttribute("utilisateur", utilisateur);    
        
        modifierUtilisateurAction.execute(request);
        
        assertFalse(fauxEntityManager.utilisateurModifie);
        assertNull(fauxEntityManager.rechercherUtilisateur(utilisateur.getLogin()).getAdresse());
        assertNull(fauxEntityManager.rechercherUtilisateur(utilisateur.getLogin()).getCode_postal());
        assertNull(fauxEntityManager.rechercherUtilisateur(utilisateur.getLogin()).getVille());
        assertEquals(request.getAttribute("message"),"Profil non modifié.");
    }
    
    
    @Test
    public void modifieAdresseDeLUtilisateurSiChampsSaisis()
    {
        final Utilisateur utilisateur = utilisateur();
        fauxEntityManager.creerUtilisateur(utilisateur);
        final Map parametres = new HashMap();
        parametres.put("adresse","adresse");
        parametres.put("code_postal","33000");
        parametres.put("ville", "ville");
        request = new AddedParametersRequestWrapper(request, parametres);
        request.getSession().setAttribute("utilisateur",utilisateur);        
        
        modifierUtilisateurAction.execute(request);
        
        assertTrue(fauxEntityManager.utilisateurModifie);
        assertEquals(fauxEntityManager.rechercherUtilisateur(utilisateur.getLogin()).getAdresse(),"adresse");
        assertEquals(fauxEntityManager.rechercherUtilisateur(utilisateur.getLogin()).getCode_postal(),"33000");
        assertEquals(fauxEntityManager.rechercherUtilisateur(utilisateur.getLogin()).getVille(),"ville");
        assertEquals(request.getAttribute("message"),"Profil enregistré.");
    }
    
    private Utilisateur utilisateur(){
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setLogin("login");
        utilisateur.setPseudo("pseudo");
        utilisateur.setMdp("mdp");
        return utilisateur;
    }
 
}
