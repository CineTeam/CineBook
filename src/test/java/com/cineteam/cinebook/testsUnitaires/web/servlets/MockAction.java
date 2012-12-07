package com.cineteam.cinebook.testsUnitaires.web.servlets;

import com.cineteam.cinebook.web.actions.Action;
import javax.servlet.http.HttpServletRequest;

/** @author Bérangère */
public class MockAction implements Action {

    public String execute(HttpServletRequest request) {
        return "index.jsp";
    }
    
}
