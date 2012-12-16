package com.cineteam.cinebook.web.film;

import com.cineteam.cinebook.model.film.Film;
import com.cineteam.cinebook.model.film.FilmVu;
import com.cineteam.cinebook.model.film.IFilmProvider;
import com.cineteam.cinebook.model.film.IFilmVuEntityManager;
import com.cineteam.cinebook.model.utilisateur.Utilisateur;
import com.cineteam.cinebook.web.servlets.Action;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/** @author Ikram */
public class RecupererFilmsVusActions implements Action {

    private IFilmProvider provider;
    private IFilmVuEntityManager em;
        
    public RecupererFilmsVusActions(IFilmProvider _provider, IFilmVuEntityManager _em) {
        provider = _provider;
        em = _em;
    }

    public String execute(HttpServletRequest request) {
        List<Film> filmsVus = new ArrayList<Film>();
        Utilisateur utilisateur = (Utilisateur) request.getSession().getAttribute("utilisateur");
               
        if(utilisateur!=null){
            List<FilmVu> filmsVusParIds = em.rechercherFilmsVus(utilisateur.getId());
            if(!filmsVusParIds.isEmpty())
            {
                List<String> IdsFilmsVus = new ArrayList<String>();
                for(int i=0; i<filmsVusParIds.size();i++)
                {
                    IdsFilmsVus.add(filmsVusParIds.get(i).getId_film());
                }
                filmsVus = provider.getFilmsParIds(IdsFilmsVus);
            }
        }
        request.setAttribute("filmsVus", filmsVus);           
        return "filmsVus.jsp";   
    }

    
     
}
