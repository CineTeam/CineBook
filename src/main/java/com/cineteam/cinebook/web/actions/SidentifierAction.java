package com.cineteam.cinebook.web.actions;

import javax.servlet.http.HttpServletRequest;

/** @author Bérangère */
public class SidentifierAction implements Action{
    
    public SidentifierAction() 
    { }
    
    public String execute(HttpServletRequest request) {

        return "index.jsp";
    }
    
}
