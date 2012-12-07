package com.cineteam.cinebook.web.servlets;

import com.cineteam.cinebook.model.entitymanager.commentaire_cinema.Commentaire_CinemaEntityManager;
import com.cineteam.cinebook.model.entitymanager.utilisateur.UtilisateurEntityManager;
import com.cineteam.cinebook.outils.StringUtils;
import com.cineteam.cinebook.web.actions.Action;
import com.cineteam.cinebook.web.actions.cinema.DeposerCommentaireCinemaAction;
import com.cineteam.cinebook.web.actions.utilisateur.SeDeconnecterAction;
import com.cineteam.cinebook.web.actions.utilisateur.SidentifierAction;
import com.cineteam.cinebook.web.actions.utilisateur.SinscrireAction;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ServletMembre extends HttpServlet {

    private String vue = null;

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
            Action classeAction = null;
            if (param_action.equalsIgnoreCase("sinscrireAction")) {
                    classeAction = new SinscrireAction(new UtilisateurEntityManager());
            }
            else if (param_action.equalsIgnoreCase("sidentifierAction")) {
                    classeAction = new SidentifierAction(new UtilisateurEntityManager());
            }
            else if (param_action.equalsIgnoreCase("seDeconnecterAction")) {
                    classeAction = new SeDeconnecterAction();
            }
            else if (param_action.equalsIgnoreCase("deposerCommentaireCinemaAction")) {
                    classeAction = new DeposerCommentaireCinemaAction(new Commentaire_CinemaEntityManager());
            }
            
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
        return "Dispatche les actions membres";
    }
    
}
