package com.cineteam.cinebook.web.testActions;

import com.cineteam.cinebook.model.entity.Seance;
import com.cineteam.cinebook.model.entity.SeancesFilm;
import com.cineteam.cinebook.model.provider.seance.ISeanceProvider;
import java.util.ArrayList;
import java.util.List;

/** @author Berangere */
public class MockSeanceProvider implements ISeanceProvider
{
    public List<SeancesFilm> seancesFilms = new ArrayList<SeancesFilm>();
    
    public List<SeancesFilm> getSeancesPourUnCinema(String id) {
        SeancesFilm seancesFilm = new SeancesFilm();
        if(!id.isEmpty()){
            List<Seance> seances = new ArrayList<Seance>();
            Seance seance = new Seance();
            seance.setFormat("fmt");
            seances.add(seance);
            seancesFilm.setSeances(seances);
            seancesFilms.add(seancesFilm);
        }
        return seancesFilms;
    }
    
}
