package com.cineteam.cinebook.model.provider.seance;

import com.cineteam.cinebook.model.entity.Cinema;
import com.cineteam.cinebook.model.entity.Seances_film;
import com.cineteam.cinebook.model.provider.AllocineApiUrlBuilder;
import com.cineteam.cinebook.model.provider.AllocineApiUrlBuilder.Methodes;
import com.cineteam.cinebook.model.provider.UrlProviderSource;
import java.util.List;

/** @author alexis */
public class SeanceProvider implements ISeanceProvider
{
    private SeanceXMLParser parser = new SeanceXMLParser();
    private UrlProviderSource source = new UrlProviderSource();
    
    public List<Seances_film> getSeancesPourUnCinema(String id) 
    {
        String url = new AllocineApiUrlBuilder(Methodes.SEANCES).ajouterLesCinemas(id).getUrl();
        System.out.println(url);
        List<Seances_film> seances_films = parser.parserLesSeancesPourUnCinema(source.getInputStream(url));
        return seances_films;
    }
    
    public List<Cinema> getSeancesPourUnFilm(String id, String codePostal) 
    {
        String url = new AllocineApiUrlBuilder(Methodes.SEANCES).ajouterLeFilm(id).ajouterLeCodePostal(codePostal).getUrl();
        List<Cinema> cinemas = parser.parserLesSeancesPourUnFilm(source.getInputStream(url));
        return cinemas;
    }
}
