package com.cineteam.cinebook.web.actions;

import com.cineteam.cinebook.model.entity.Cinema;
import com.cineteam.cinebook.model.provider.cinema.ICinemaProvider;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/** @author Cedric */
public class ConsulterDetailCinemaAction implements Action {
    
    private ICinemaProvider provider;

    public ConsulterDetailCinemaAction(ICinemaProvider _provider) {
        provider = _provider;
    }

    public String execute(HttpServletRequest request) {
        String index_cinema = (String) request.getParameter("cpt");
        if(!index_cinema.isEmpty()){
            Cinema cinema = provider.getDetailCinema(index_cinema);
            request.setAttribute("cinema", cinema);       
        }    
        
        return "detailCinema.jsp";
    }
    
}
