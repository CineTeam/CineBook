package com.cineteam.cinebook.web.servlets;

import com.cineteam.cinebook.outils.StringUtils;
import java.io.IOException;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** @author alexis */
public abstract class CineBookServlet extends HttpServlet {
     
    protected String vue = null;
    protected Map<String, Action> actions;

    public String getVue() {
        return vue;
    }
    
    public void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        String dossier_prive = "/WEB-INF/";
        request.setCharacterEncoding("UTF-8");
        String param_vue = (String) request.getParameter("vue");
        String param_action = (String) request.getParameter("action");
        if(!StringUtils.estVide(param_vue)){
            vue = dossier_prive+param_vue;    
        }
        if(!StringUtils.estVide(param_action)){
            Action classeAction = actions.get(param_action);
            String reponse_action = classeAction.execute(request);
            if(reponse_action.contains(".jsp")){
                vue = dossier_prive+reponse_action;
            }
            else{
                vue = reponse_action;
            }
        }
        
        if (vue != null) {
            RequestDispatcher rd = request.getRequestDispatcher(vue);
            rd.forward(request, response);
        }
        
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Dispatche les actions et les vues";
    }
}
