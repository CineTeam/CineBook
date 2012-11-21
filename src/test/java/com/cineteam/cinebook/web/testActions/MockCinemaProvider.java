package com.cineteam.cinebook.web.testActions;

import com.cineteam.cinebook.model.entity.Cinema;
import com.cineteam.cinebook.model.provider.cinema.ICinemaProvider;
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
    
}
