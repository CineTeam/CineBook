package com.cineteam.cinebook.model.provider.seance;

import com.cineteam.cinebook.model.entity.Film;
import com.cineteam.cinebook.model.entity.Seance;
import com.cineteam.cinebook.model.entity.SeancesFilm;
import com.cineteam.cinebook.model.provider.AXMLParser;
import com.cineteam.cinebook.model.provider.film.FilmXMLParser;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jdom.Document;
import org.jdom.Element;

/** @author alexis */
public class SeanceXMLParser extends AXMLParser
{
    private FilmXMLParser filmParser = new FilmXMLParser();
    
    public List<SeancesFilm> parserLesSeancesPourUnCinema(InputStream is) 
    {
         Document document = getDocumentFromInputStream(is);
         List<SeancesFilm> seances = getSeancesPourUnCinema(document);
         return seances;
    }

    private List<SeancesFilm> getSeancesPourUnCinema(Document document)
    {
        List<SeancesFilm> seancesFilms = new ArrayList<SeancesFilm>();
        
        if(document != null)
        {
            Element racine = document.getRootElement();
            Element seancesCinemaElt = racine.getChild("theaterShowtimes", defaultNameSpace);
            Element seancesFilmsElt = seancesCinemaElt.getChild("movieShowtimesList", defaultNameSpace);
            
            List seancesFilmsList = seancesFilmsElt.getChildren("movieShowtimes", defaultNameSpace);
            
            Iterator i = seancesFilmsList.iterator();
            while(i.hasNext())
            {
                Element courant = (Element)i.next();
                Element onShow = courant.getChild("onShow", defaultNameSpace);
                Element movie = onShow.getChild("movie", defaultNameSpace);
                Film film = filmParser.parserLeFilm(movie);
                List<Seance> seances = getSeancesForFilm(seancesFilms, film);
                if(seances == null)
                {
                    seances = new ArrayList<Seance>();
                    SeancesFilm seancesFilm = new SeancesFilm();
                    seancesFilm.setSeances(seances);
                    seancesFilm.setFilm(film);
                    seancesFilms.add(seancesFilm);
                }
                Seance seance = parserSeance(courant);
                seances.add(seance);  
            }
        }
        return seancesFilms;
    }

    private String parserLaLangue(Element courant)
    {
        return courant.getChildText("version", defaultNameSpace);
    }

    private String parserFormat(Element courant)
    {
        return courant.getChildText("format", defaultNameSpace);
    }

    private Seance parserSeance(Element courant) {
        Seance seance = new Seance();
        seance.setLangue(parserLaLangue(courant));
        seance.setFormat(parserFormat(courant));
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
            if(seancesFilm.getFilm() != null && seancesFilm.getFilm().equals(film))
            {
                return seancesFilm.getSeances();
            }
        }
        return null;
    }
    
}
