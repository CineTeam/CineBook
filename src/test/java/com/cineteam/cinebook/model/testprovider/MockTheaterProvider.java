package com.cineteam.cinebook.model.testprovider;

import com.cineteam.cinebook.model.entity.Cinema;
import com.cineteam.cinebook.model.provider.ICinemasProvider;
import java.util.ArrayList;
import java.util.List;

/** @author alexis */
public class MockTheaterProvider implements ICinemasProvider
{
    List<Cinema> cinemas;
    
    public MockTheaterProvider (List<Cinema> _cinemas)
    {
        cinemas = _cinemas;
    }
    
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
