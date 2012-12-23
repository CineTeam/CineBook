package com.cineteam.cinebook.web.utilisateur;

import com.cineteam.cinebook.outils.StringUtils;
import com.cineteam.cinebook.web.servlets.Action;
import javax.servlet.http.HttpServletRequest;

/** @author Berangere */
public class RedirigerAction implements Action
{

    public String execute(HttpServletRequest request) 
    {
        String page_courante = request.getParameter("page_courante");
        if(!StringUtils.estVide(page_courante)){
            page_courante = page_courante.substring(9, page_courante.length());
            if(page_courante.equals("accueilFilm.jsp")){
                page_courante = "ServletVisiteur?action=recupererDixDerniersFilmsSortisAction";
            }
            if(page_courante.equals("listeFilms.jsp")){
                page_courante = "ServletVisiteur?action=rechercherFilmAction&recherche="+request.getParameter("recherche");
            }
            if(page_courante.equals("detailFilm.jsp")){
                page_courante = "ServletVisiteur?action=consulterDetailFilmAction&cpt="+request.getParameter("idFilm") +"&recherche="+request.getParameter("code_postal");
            }
            if(page_courante.equals("listeCinemas.jsp")){
                page_courante = "ServletVisiteur?action=rechercherCinemaAction&recherche="+request.getParameter("recherche");
            }
            if(page_courante.equals("detailCinema.jsp")){
                page_courante = "ServletVisiteur?action=consulterDetailCinemaAction&cpt="+request.getParameter("idCinema");
            }
        }
        return page_courante;
    }
    
}
