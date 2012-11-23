package com.cineteam.cinebook.model.provider.seance;

import com.cineteam.cinebook.model.entity.Film;
import com.cineteam.cinebook.model.entity.Horaire;
import com.cineteam.cinebook.model.entity.Seance;
import com.cineteam.cinebook.model.entity.Seances_film;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/** @author alexis */
public class SeanceProvider implements ISeanceProvider
{
    public List<Seances_film> getSeancesPourUnCinema(String id) 
    {
        List<Seances_film> seances_films = new ArrayList<Seances_film>();

        Film f = new Film();
        f.setTitre("ESSSSSAI");
        f.setRealisateur("reaaaaal");
        
        List<String> heures = new ArrayList<String>();
        heures.add("10:00");
        heures.add("12:00");
        heures.add("22:15");
        
        Horaire h1 = new Horaire();
        h1.setHeures(heures);
        
        Calendar c1 = Calendar.getInstance(); // date du jour
        c1.set(Calendar.YEAR, 2012);
        c1.set(Calendar.MONTH, 5);
        c1.set(Calendar.DATE, 2);
        Date d1 = c1.getTime(); 
        
        h1.setJour(d1);
        
        Horaire h2 = new Horaire();
        h2.setHeures(heures);
        
        Calendar c = Calendar.getInstance(); // date du jour
        c.set(Calendar.YEAR, 2007);
        c.set(Calendar.MONTH, 7);
        c.set(Calendar.DATE, 26);
        Date d = c.getTime(); 

        h2.setJour(d);
        
        List<Horaire> horaires = new ArrayList<Horaire>();
        horaires.add(h1);
        horaires.add(h2);
        
        Seance s = new Seance();
        s.setFormat("fmmmmmt");
        s.setLangue("jkdqshsjkjd");
        s.setHoraires(horaires);
        
        List<Seance> seances = new ArrayList<Seance>();
        seances.add(s);
        seances.add(s);

        Seances_film seances_film = new Seances_film();
        seances_film.setFilm(f);
        seances_film.setSeances(seances);

        seances_films.add(seances_film);
        seances_films.add(seances_film);

        return seances_films;
    }
    
}
