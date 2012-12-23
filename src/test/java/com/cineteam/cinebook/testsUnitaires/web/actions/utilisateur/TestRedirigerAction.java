package com.cineteam.cinebook.testsUnitaires.web.actions.utilisateur;

import com.cineteam.cinebook.testsUnitaires.web.servlets.AddedParametersRequestWrapper;
import com.cineteam.cinebook.web.utilisateur.RedirigerAction;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.replay;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.Test;

/** @author Berangere */
public class TestRedirigerAction 
{
    private HttpServletRequest request ;
    private RedirigerAction redirigerAction;
    
    @Before
    public void setUp()
    {
        redirigerAction = new RedirigerAction();
        request = createMock(HttpServletRequest.class);
        replay(request);
    }
    
    @Test
    public void neRedirigePasSiPasDePageCourante()
    {
        request = new AddedParametersRequestWrapper(request, new HashMap());
        
        String page = redirigerAction.execute(request);
        
        assertNull(page);
    }
    
    @Test
    public void redirigeSiPageCourante()
    {
        final Map parametres = new HashMap();
        parametres.put("page_courante","/WEB-INF/index.jsp");
        request = new AddedParametersRequestWrapper(request, parametres);
        
        String page = redirigerAction.execute(request);
        
        assertEquals(page,"index.jsp");
    }

}
