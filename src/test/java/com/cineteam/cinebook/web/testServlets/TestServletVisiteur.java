package com.cineteam.cinebook.web.testServlets;

import com.cineteam.cinebook.web.servlets.ServletVisiteur;
import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.*;
import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;

/** @author Bérangère */
public class TestServletVisiteur {
    
    private HttpServletRequest request;
    private HttpServletResponse response;
    private ServletVisiteur servlet;
  
    @Before
    public void setUp() {
        servlet = new ServletVisiteur();
        request = createMock(HttpServletRequest.class);
        replay(request);
        response = createMock(HttpServletResponse.class);
        replay(response);
    }
    
    @Test
    public void neDispatchePasSiVueNonRenseignee() throws ServletException, IOException 
    {
        final Map params = new HashMap();
        params.put("action", "");
        params.put("vue", "");
        request = new AddedParametersRequestWrapper(request,params);
                
        servlet.processRequest(request,response);
        
        assertNull(servlet.getVue());
    }
    
    @Test
    public void dispatcheSiVueRenseignee() throws ServletException, IOException 
    {
        final Map params = new HashMap();
        params.put("action", "");
        params.put("vue", "vue.jsp");
        request = new AddedParametersRequestWrapper(request,params);
                
        servlet.processRequest(request,response);
        
        assertNotNull(servlet.getVue());
    }
    
    @Test
    public void dispatcheLesActions() throws ServletException, IOException 
    {
        final Map params = new HashMap();
        params.put("action", "rechercherCinemaAction");
        params.put("vue", "");
        request = new AddedParametersRequestWrapper(request,params);
                
        servlet.processRequest(request,response);
        
        assertNotNull(servlet.getVue());
    }
}
