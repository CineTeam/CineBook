package com.cineteam.cinebook.model.provider.seance;

import com.cineteam.cinebook.model.entity.Film;
import com.cineteam.cinebook.model.entity.Seance;
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
    
    public List<Seance> parserLesSeancesPourUnCinema(InputStream is) 
    {
         Document document = getDocumentFromInputStream(is);
         List<Seance> seances = getSeancesPourUnCinema(document);
         return seances;
    }

    private List<Seance> getSeancesPourUnCinema(Document document)
    {
        List<Seance> seances = new ArrayList<Seance>();
        if(document != null)
        {
            Element racine = document.getRootElement();
            Element seancesCinema = racine.getChild("theaterShowtimes", defaultNameSpace);
            Element seancesFilms = seancesCinema.getChild("movieShowtimesList", defaultNameSpace);
            
            List seancesFilmsList = seancesFilms.getChildren("movieShowtimes", defaultNameSpace);
            
            Iterator i = seancesFilmsList.iterator();
            while(i.hasNext())
            {
                Element courant = (Element)i.next();
                Element onShow = courant.getChild("onShow", defaultNameSpace);
                Film film = filmParser.parserLeFilm(onShow);
                Seance seance = parserSeance(courant);
                seance.setFilm(film);
                
                seances.add(seance);
            }
        }
        return seances;
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
    
}
