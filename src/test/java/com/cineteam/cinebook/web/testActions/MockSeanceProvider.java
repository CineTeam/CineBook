package com.cineteam.cinebook.web.testActions;

import com.cineteam.cinebook.model.entity.Horaire;
import com.cineteam.cinebook.model.entity.Seance;
import com.cineteam.cinebook.model.entity.Seances_film;
import com.cineteam.cinebook.model.provider.seance.ISeanceProvider;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/** @author Berangere */
public class MockSeanceProvider implements ISeanceProvider
{
    public List<Seances_film> seancesFilms = new ArrayList<Seances_film>();
    
    public List<Seances_film> getSeancesPourUnCinema(String id) {
        Seances_film seancesFilm = new Seances_film();
        if(!id.isEmpty()){
            List<Seance> seances = new ArrayList<Seance>();
            Seance seance = new Seance();
            seance.setFormat("fmt");
            seance.setLangue("fr");
            Horaire horaire = new Horaire();
            horaire.setJour(new Date());
            List<String> heures = new ArrayList<String>();
            heures.add("12:00");
            horaire.setHeures(heures);
            seances.add(seance);
            seancesFilm.setSeances(seances);
            seancesFilms.add(seancesFilm);
        }
        return seancesFilms;
    }
    
}
