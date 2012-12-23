package com.cineteam.cinebook.model.seance;

import com.cineteam.cinebook.model.cinema.Cinema;
import com.cineteam.cinebook.model.film.Film;
import com.cineteam.cinebook.model.provider.AXMLParser;
import com.cineteam.cinebook.model.cinema.CinemaXMLParser;
import com.cineteam.cinebook.model.film.FilmXMLParser;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jdom.Document;
import org.jdom.Element;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/** @author alexis */
public class SeanceXMLParser extends AXMLParser
{
    private FilmXMLParser filmParser = new FilmXMLParser();
    private CinemaXMLParser cinemaParser = new CinemaXMLParser();
    
    public List<SeancesFilm> parserLesSeancesPourUnCinema(InputStream is) 
    {
         Document document = getDocumentFromInputStream(is);
         List<SeancesFilm> seances = getSeancesPourUnCinema(document);
         return seances;
    }
    
    public List<Cinema> parserLesSeancesPourUnFilm(InputStream is) 
    {
         Document document = getDocumentFromInputStream(is);
         List<Cinema> seances = getSeancesPourUnFilm(document);
         return seances;
    }

    private List<SeancesFilm> getSeancesPourUnCinema(Document document)
    {
        List<SeancesFilm> seancesFilms = new ArrayList<SeancesFilm>();
        
        if(document != null)
        {
            Element racine = document.getRootElement();
            Element seancesCinemaElt = racine.getChild("theaterShowtimes", defaultNameSpace);
            seancesFilms = parserSeancesDunCinema(seancesCinemaElt);
        }
        return seancesFilms;
    }
    
    private List<Cinema> getSeancesPourUnFilm(Document document)
    {
        List<Cinema> cinemas = new ArrayList<Cinema>();
        
        if(document != null)
        {
            Element racine = document.getRootElement();
            List seancesCinemaList = racine.getChildren("theaterShowtimes", defaultNameSpace);
            Iterator i = seancesCinemaList.iterator();
            while(i.hasNext())
            {
                Element courant = (Element)i.next();
                Element place = courant.getChild("place", defaultNameSpace);
                Element cinemaElt = place.getChild("theater", defaultNameSpace);
                Cinema cinema = cinemaParser.parserLeCinema(cinemaElt);
                cinema.setSeances_films(parserSeancesDunCinema(courant));
                cinemas.add(cinema);
            }
           
        }
        return cinemas;
    }

    private String parserLaLangue(Element courant)
    {
        return courant.getChildText("version", defaultNameSpace);
    }

    private String parserFormat(Element courant)
    {
        if(courant.getChildText("screenFormat", defaultNameSpace) != null)
            return courant.getChildText("screenFormat", defaultNameSpace);
        return "";
    }

    private Seance parserSeance(Element courant) {
        Seance seance = new Seance();
        seance.setLangue(parserLaLangue(courant));
        seance.setFormat(parserFormat(courant));
        seance.setHoraires(parserHoraires(courant));
        return seance;
    }

    private boolean seancesFilmsContainsFilm(List<SeancesFilm> seancesFilms, Film film)
    {
        for(SeancesFilm seancesFilm : seancesFilms)
        {
            if(seancesFilm.getFilm().equals(film))
            {
                return true;
            }
        }
        return false;
    }

    private List<Seance> getSeancesForFilm(List<SeancesFilm> seancesFilms, Film film)
    {
        for(SeancesFilm seancesFilm : seancesFilms)
        {
            if(seancesFilm.getFilm() != null && seancesFilm.getFilm().getId().equals(film.getId()))
            {
                return seancesFilm.getSeances();
            }
        }
        
        return createSeanceForFilm(film, seancesFilms);
    }

    private List<Horaire> parserHoraires(Element courant)
    {
        List<Horaire> horaires = new ArrayList<Horaire>();
        Element screenings = courant.getChild("screenings", defaultNameSpace);
        List scrs = screenings.getChildren("scr", defaultNameSpace);
        Iterator i = scrs.iterator();
        while(i.hasNext())
        {
            Element scr = (Element)i.next();
            Horaire horaire = parserHoraire(scr);
            if(horaire != null)
            {
                horaires.add(horaire);
            }
        }
        return horaires;
    }

    private List<Seance> createSeanceForFilm(Film film, List<SeancesFilm> seancesFilms) {
        List<Seance> seances = new ArrayList<Seance>();
        SeancesFilm seancesFilm = new SeancesFilm();
        seancesFilm.setSeances(seances);
        seancesFilm.setFilm(film);
        seancesFilms.add(seancesFilm);
        return seances;
    }

    private Element getMovieElement(Element courant) {
        Element onShow = courant.getChild("onShow", defaultNameSpace);
        Element movie = onShow.getChild("movie", defaultNameSpace);
        return movie;
    }

    private List<String> parserHeures(Element scr) {
        List<String> heuresStr = new ArrayList<String>();
        List heures = scr.getChildren("t", defaultNameSpace);
        Iterator iHeures = heures.iterator();
        while(iHeures.hasNext())
        {
            Element heure = (Element)iHeures.next();
            heuresStr.add(heure.getText());
        }
        return heuresStr;
    }

    private Horaire parserHoraire(Element scr) {
        Horaire horaire = new Horaire();
        String jour = scr.getAttributeValue("d");
        DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd");
        try
        {
            DateTime date = formatter.parseDateTime(jour);
            horaire.setJour(date.toDate());    
        }
        catch (Exception e)
        {
            return null;
        }  
        horaire.setHeures(parserHeures(scr));
        return horaire;
    }

    private List<SeancesFilm> parserSeancesDunCinema(Element seancesCinemaElt) 
    {
        List<SeancesFilm> seancesFilms = new ArrayList<SeancesFilm>();
        Element seancesFilmsElt = seancesCinemaElt.getChild("movieShowtimesList", defaultNameSpace);
        List seancesFilmsList = seancesFilmsElt.getChildren("movieShowtimes", defaultNameSpace);  
        Iterator i = seancesFilmsList.iterator();
        while(i.hasNext())
        {
            Element courant = (Element)i.next();
            Film film = filmParser.parserLeFilm(getMovieElement(courant));
            List<Seance> seances = getSeancesForFilm(seancesFilms, film);
            Seance seance = parserSeance(courant);
            ajouterLaSeanceSiNecessaire(seances, seance);
        }
        return seancesFilms;
    }

    private boolean seancesContientLaSeance(List<Seance> seances, Seance seance) {
        for (Seance s : seances)
        {
            if(s.getFormat().equalsIgnoreCase(seance.getFormat()) && s.getLangue().equalsIgnoreCase(seance.getLangue()))
            {
                return true;
            }
        }
        return false;
    }

    private Seance getSeanceCorrespondante(List<Seance> seances, Seance seance)
    {
        for (Seance s : seances)
        {
            if(s.getFormat().equalsIgnoreCase(seance.getFormat()) && s.getLangue().equalsIgnoreCase(seance.getLangue()))
            {
                return s;
            }
        }
        return null;
    }

    private void ajouterLaSeanceSiNecessaire(List<Seance> seances, Seance seance) {
        if(seancesContientLaSeance(seances, seance))
        {
            Seance seanceExistante = getSeanceCorrespondante(seances,seance);
            copierLesHoraires(seance, seanceExistante); 
        }
        else
        {
            seances.add(seance);
        }
    }

    private void copierLesHoraires(Seance seance, Seance seanceExistante) {
        for (Horaire horaire : seance.getHoraires())
        {
            seanceExistante.getHoraires().add(horaire);
        }
    }

}
