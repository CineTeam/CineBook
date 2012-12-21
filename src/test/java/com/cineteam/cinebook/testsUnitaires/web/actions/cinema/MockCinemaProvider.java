package com.cineteam.cinebook.testsUnitaires.web.actions.cinema;

import com.cineteam.cinebook.model.cinema.Cinema;
import com.cineteam.cinebook.model.cinema.CinemaFrequente;
import com.cineteam.cinebook.model.cinema.ICinemaProvider;
import java.util.ArrayList;
import java.util.List;

/** @author alexis */
public class MockCinemaProvider implements ICinemaProvider
{
    public List<Cinema> cinemas = new ArrayList<Cinema>();
    
    public List<Cinema> rechercherCinemasParMotCle(String nom)
    {
        List<Cinema> resultat = new ArrayList<Cinema>();
        if(!cinemas.isEmpty()){
            for(Cinema cinema : cinemas){
                if(cinema.getNom().contains(nom))
                    resultat.add(cinema);
            }
        }
        return resultat;
    }

    public List<Cinema> rechercherCinemasParCodePostal(String codePostal) 
    {
        List<Cinema> resultat = new ArrayList<Cinema>();
        if(!cinemas.isEmpty()){
            for(Cinema cinema : cinemas){
                if(cinema.getCode_postal().equals(codePostal))
                    resultat.add(cinema);
            }
        }
        return resultat;
    }

    public Cinema getDetailCinema(String id) 
    {
        Cinema cinema = null;
        if(!id.isEmpty()){
            cinema = new Cinema();
            cinema.setId(id);
            cinema.setNombre_salles(40);
        }
        return cinema;
    }

    public List<Cinema> getCinemasParIds(List<CinemaFrequente> idsCinemas) 
    {
        List<Cinema> resultat = new ArrayList<Cinema>();
        if(idsCinemas !=null)
        {
            for(int i =0; i< idsCinemas.size(); i++)
            {
                Cinema cinema = getDetailCinema(idsCinemas.get(i).getId_cinema());
                resultat.add(cinema);
            }
        }
        return resultat;
    }
    
}
