package com.cineteam.cinebook.testsUnitaires.web.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.replay;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.Test;

/** @author Bérangère */
public class TestCineBookServlet {
    
    private HttpServletRequest request;
    private HttpServletResponse response;
    private MockCinebookServlet servlet;
  
    @Before
    public void setUp() 
    {
        servlet = new MockCinebookServlet();
        servlet.addAction("mockAction", new MockAction());
        request = createMock(HttpServletRequest.class);
        replay(request);
        response = createMock(HttpServletResponse.class);
        replay(response);
    }
    
    @Test
    public void neDispatchePasSiVueNonRenseignee() throws ServletException, IOException 
    {
        request = new AddedParametersRequestWrapper(request);
                
        servlet.processRequest(request,response);
        
        assertNull(servlet.getVue());
    }
    
    @Test
    public void dispatcheSiVueRenseignee() throws ServletException, IOException 
    {
        final Map parametres = new HashMap();
        parametres.put("vue", "vue.jsp");
        request = new AddedParametersRequestWrapper(request,parametres);
                
        servlet.processRequest(request,response);
        
        assertNotNull(servlet.getVue());
    }
    
    @Test
    public void dispatcheLesActions() throws ServletException, IOException 
    {
        final Map parametres = new HashMap();
        parametres.put("action", "mockAction");
        request = new AddedParametersRequestWrapper(request,parametres);
                
        servlet.processRequest(request,response);
        
        assertNotNull(servlet.getVue());
    }
}
