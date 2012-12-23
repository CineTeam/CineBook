package com.cineteam.cinebook.testsUnitaires.web.actions;

import com.cineteam.cinebook.model.cinema.Cinema;
import com.cineteam.cinebook.model.seance.Horaire;
import com.cineteam.cinebook.model.seance.Seance;
import com.cineteam.cinebook.model.seance.SeancesFilm;
import com.cineteam.cinebook.model.seance.ISeanceProvider;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/** @author Berangere */
public class MockSeanceProvider implements ISeanceProvider
{
    public List<SeancesFilm> seancesFilms = new ArrayList<SeancesFilm>();
    public List<Cinema> seancesCinemas = new ArrayList<Cinema>();
    
    public List<SeancesFilm> getSeancesPourUnCinema(String id) {
        SeancesFilm seancesFilm = new SeancesFilm();
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

    public List<Cinema> getSeancesPourUnFilm(String id, String codePostal) {
        if(!codePostal.isEmpty()){
            Cinema cinema = new Cinema();
            cinema.setId(id);
            List<SeancesFilm> seancesFilmsDuCinema = this.getSeancesPourUnCinema(id);
            cinema.setSeances_films(seancesFilmsDuCinema);
            seancesCinemas.add(cinema);
        }
        return seancesCinemas;
    }
    
}
