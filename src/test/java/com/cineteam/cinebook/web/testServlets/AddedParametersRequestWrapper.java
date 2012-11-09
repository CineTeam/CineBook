package com.cineteam.cinebook.web.testServlets;

import com.mockrunner.mock.web.MockHttpSession;
import com.mockrunner.mock.web.MockRequestDispatcher;
import java.util.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpSession;

/** @author Berangere Noiraud */
public class AddedParametersRequestWrapper extends HttpServletRequestWrapper {

    private Map params;
    private Map attributes =new HashMap();
    private boolean merged;
    private String method;
    private MockHttpSession session = new MockHttpSession();
    public MockRequestDispatcher rd = new MockRequestDispatcher();

    public AddedParametersRequestWrapper(HttpServletRequest request) {
        super(request);
        merged = true;
    }
    
    public AddedParametersRequestWrapper(HttpServletRequest request, Map params) {
        super(request);
        this.params = params;
        this.addParameters(params);
        merged = false;
    }
    
    public AddedParametersRequestWrapper(HttpServletRequest request, Map params, MockHttpSession session) {
        super(request);
        this.params = params;
        this.addParameters(params);
        merged = false;
        this.session = session;
    }

    public AddedParametersRequestWrapper(HttpServletRequest request, Map params, String method) {
        super(request);
        this.params = params;
        this.addParameters(params);
        merged = false;
        this.method = method;
    }

    private void addParameters(Map params){
        for (Iterator iter = params.entrySet().iterator(); iter.hasNext();) {
            Map.Entry entry = (Map.Entry) iter.next();
            Object value = entry.getValue();
            if (value instanceof String)
                entry.setValue(new String[] {(String) value});
        }
    }
    
    @Override
    public void setAttribute(String name, Object o){
        attributes.put(name, o);
    }
    
    @Override
    public Object getAttribute(String name){
        return attributes.get(name);
    }
    
    @Override
    public RequestDispatcher getRequestDispatcher(String vue){
        return rd;
    }
        
    @Override
    public HttpSession getSession(){
        return session;
    }
    
    @Override
    public String getParameter(String name) {
        String values[] = (String[]) this.params.get(name);
        if ((values == null) || (values.length == 0)){
            if (merged)
                return null;
            else 
                if(values==null)
                    return null;
                else
                    return super.getParameter(name);
        } 
        else
            return values[0];
    }

    @Override
    public Map getParameterMap() {
        if (! merged) {
            Map parameters = new HashMap(super.getParameterMap());
            parameters.putAll(this.params);
            this.params = parameters;
            this.merged = true;
        }
        return this.params;
    }

    @Override
    public Enumeration getParameterNames() {
        return Collections.enumeration(this.getParameterMap().keySet());
    }

    @Override
    public String[] getParameterValues(String name) {
        Collection collection = this.getParameterMap().values();
        return (String[]) collection.toArray(new String[collection.size()]);
    }

    @Override
    public String getMethod () {
        return this.method;
    }
 }
