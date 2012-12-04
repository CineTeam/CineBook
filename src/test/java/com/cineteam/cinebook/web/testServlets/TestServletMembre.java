package com.cineteam.cinebook.web.testServlets;

import com.cineteam.cinebook.web.servlets.ServletMembre;
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
public class TestServletMembre {
    
    private HttpServletRequest request;
    private HttpServletResponse response;
    private ServletMembre servlet;
  
    @Before
    public void setUp() {
        servlet = new ServletMembre();
        request = createMock(HttpServletRequest.class);
        replay(request);
        response = createMock(HttpServletResponse.class);
        replay(response);
    }
    
    @Test
    public void neDispatchePasSiVueNonRenseignee() throws ServletException, IOException 
    {
        final Map params = new HashMap();
        request = new AddedParametersRequestWrapper(request,params);
                
        servlet.processRequest(request,response);
        
        assertNull(servlet.getVue());
    }
    
    @Test
    public void dispatcheSiVueRenseignee() throws ServletException, IOException 
    {
        final Map params = new HashMap();
        params.put("vue", "vue.jsp");
        request = new AddedParametersRequestWrapper(request,params);
                
        servlet.processRequest(request,response);
        
        assertNotNull(servlet.getVue());
    }
    
    @Test
    public void dispatcheLesActions() throws ServletException, IOException 
    {
        final Map params = new HashMap();
        params.put("action", "seDeconnecterAction");
        request = new AddedParametersRequestWrapper(request,params);
                
        servlet.processRequest(request,response);
        
        assertNotNull(servlet.getVue());
    }
}
