package com.cineteam.cinebook.web.testActions;

import com.cineteam.cinebook.model.entity.Cinema;
import com.cineteam.cinebook.model.provider.ICinemasProvider;
import java.util.ArrayList;
import java.util.List;

/** @author alexis */
public class MockCinemaProvider implements ICinemasProvider
{
    public List<Cinema> cinemas = new ArrayList<Cinema>();
    
   
    public List<Cinema> getCinemasParNom(String nom)
    {
        List<Cinema> resultat = new ArrayList<Cinema>();
        
        for(Cinema cinema : cinemas)
        {
            if(cinema.getNom().contains(nom))
            {
                resultat.add(cinema);
            }
        }
        
        return resultat;
    }
    
}
