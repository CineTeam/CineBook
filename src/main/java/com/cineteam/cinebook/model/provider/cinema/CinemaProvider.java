package com.cineteam.cinebook.model.provider.cinema;

import com.cineteam.cinebook.model.entity.Cinema;
import com.cineteam.cinebook.model.provider.UrlProviderSource;
import java.util.List;

/** @author alexis */
public class CinemaProvider implements ICinemaProvider {
    
    private static String apiUrl = "http://api.allocine.fr/rest/v3/";
    private static String searchCinemaPath = "search?partner=YW5kcm9pZC12M3M&filter=theater&count=200&page=1&format=xml&q=";
    
    private CinemaXMLParser parser = new CinemaXMLParser();
    private UrlProviderSource source = new UrlProviderSource();
    
    public List<Cinema> getCinemasParNom(String nom) 
    {
        List<Cinema> resultat = parser.parseCinemaFromInputStream(source.getInputStream(apiUrl + searchCinemaPath + nom));
        return resultat;
    }
    
}
