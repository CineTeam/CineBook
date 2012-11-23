package com.cineteam.cinebook.model.provider.seance;

import com.cineteam.cinebook.model.entity.SeancesFilm;
import java.util.ArrayList;
import java.util.List;

/** @author alexis */
public class SeanceProvider implements ISeanceProvider
{
    public List<SeancesFilm> getSeancesPourUnCinema(String id) 
    {
       /*List<SeancesFilm> seances = new ArrayList<SeancesFilm>();
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
        return new ArrayList<SeancesFilm>();
    }
    
}
