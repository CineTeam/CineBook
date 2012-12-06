package com.cineteam.cinebook.web.servlets;

import com.cineteam.cinebook.entitymanager.commentaire_cinema.Commentaire_CinemaEntityManager;
import com.cineteam.cinebook.model.provider.cinema.CinemaProvider;
import com.cineteam.cinebook.model.provider.film.FilmProvider;
import com.cineteam.cinebook.model.provider.seance.SeanceProvider;
import com.cineteam.cinebook.outils.StringUtils;
import com.cineteam.cinebook.web.actions.Action;
import com.cineteam.cinebook.web.actions.cinema.*;
import com.cineteam.cinebook.web.actions.film.*;
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
        if(!StringUtils.estVide(param_vue)){
            vue = dossier_prive+param_vue;    
        }
        if(!StringUtils.estVide(param_action)){
            Action classeAction = null;
            if (param_action.equalsIgnoreCase("rechercherCinemaAction")) {
                    classeAction = new RechercherCinemaAction(new CinemaProvider());
            }
            else if (param_action.equalsIgnoreCase("rechercherFilmAction")) {
                    classeAction = new RechercherFilmAction(new FilmProvider());
            }
            else if(param_action.equalsIgnoreCase("recupererDixDerniersFilmsSortisAction")){    
                    classeAction = new RecupererDixDerniersFilmsSortisAction(new FilmProvider());
            }
            else if (param_action.equalsIgnoreCase("rechercherCinemaParCPAction")) {
                    classeAction = new RechercherCinemaParCPAction(new CinemaProvider());
            }
            else if (param_action.equalsIgnoreCase("consulterDetailCinemaAction")) {
                    classeAction = new ConsulterDetailCinemaAction(new CinemaProvider(),new SeanceProvider(),new Commentaire_CinemaEntityManager());
            }
            else if (param_action.equalsIgnoreCase("consulterDetailFilmAction")) {
                    classeAction = new ConsulterDetailFilmAction(new FilmProvider(), new SeanceProvider());
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
        return "Dispatche les actions visiteurs";
    }
}
