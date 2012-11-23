package com.cineteam.cinebook.model.provider.seance;

import com.cineteam.cinebook.model.entity.Film;
import com.cineteam.cinebook.model.entity.Seance;
import java.util.ArrayList;
import java.util.List;

/** @author alexis */
public class SeanceProvider implements ISeanceProvider
{
    public List<Seance> getSeancesPourUnCinema(String id) 
    {
       /*List<Seance> seances = new ArrayList<Seance>();
        Film f = new Film();
        f.setTitre("ESSSSSAI");
        f.setRealisateur("reaaaaal");
        Seance s = new Seance();
        s.setFilm(f);
        s.setFormat("fmmmmmt");
        s.setLangue("jkdqshsjkjd");
        seances.add(s);
        seances.add(s);
        return seances;*/
        return new ArrayList<Seance>();
    }
    
}
