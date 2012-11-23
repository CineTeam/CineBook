package com.cineteam.cinebook.web.servlets;

import com.cineteam.cinebook.model.provider.cinema.CinemaProvider;
import com.cineteam.cinebook.model.provider.film.FilmProvider;
import com.cineteam.cinebook.model.provider.seance.SeanceProvider;
import com.cineteam.cinebook.web.actions.*;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** @author Bérangère */
public class ServletVisiteur extends HttpServlet {

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
        if(param_vue!=null && !param_vue.isEmpty()){
            vue = dossier_prive+param_vue;    
        }
        if(param_action!=null && !param_action.isEmpty()){
            Action classeAction = null;
            if (param_action.equalsIgnoreCase("rechercherCinemaAction")) {
                    classeAction = new RechercherCinemaAction(new CinemaProvider());
            }
            if (param_action.equalsIgnoreCase("rechercherFilmAction")) {
                    classeAction = new RechercherFilmAction(new FilmProvider());
            }
            if(param_action.equalsIgnoreCase("recupererDixDerniersFilmsSortisAction")){    
                    classeAction = new RecupererDixDerniersFilmsSortisAction(new FilmProvider());
            }
            if (param_action.equalsIgnoreCase("rechercherCinemaParCPAction")) {
                    classeAction = new RechercherCinemaParCPAction(new CinemaProvider());
            }
            if (param_action.equalsIgnoreCase("consulterDetailCinemaAction")) {
                    classeAction = new ConsulterDetailCinemaAction(new CinemaProvider(),new SeanceProvider());
            }
            if (param_action.equalsIgnoreCase("consulterDetailFilmAction")) {
                    classeAction = new ConsulterDetailFilmAction(new FilmProvider());
            }
            
            vue = dossier_prive+classeAction.execute(request);
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
        return "Dispatche les actions visiteurs";
    }
}
