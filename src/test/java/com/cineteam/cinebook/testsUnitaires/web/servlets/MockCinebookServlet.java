package com.cineteam.cinebook.testsUnitaires.web.servlets;

import com.cineteam.cinebook.web.actions.Action;
import com.cineteam.cinebook.web.servlets.CineBookServlet;
import java.util.HashMap;

/** @author alexis */
public class MockCinebookServlet extends CineBookServlet
{
    public MockCinebookServlet()
    {
        actions = new HashMap<String, Action>();
    }
    
    public void addAction(String cle, Action action)
    {
        actions.put(cle, action);
    }
}
