package com.cineteam.cinebook.model.provider;

import com.cineteam.cinebook.model.entity.Cinema;
import java.util.List;

/** @author alexis */
public class AllocineCinemaProvider implements ICinemasProvider
{
    private static String apiUrl = "http://api.allocine.fr/rest/v3/";
    private static String searchCinemaPath = "search?partner=YW5kcm9pZC12M3M&filter=theater&count=200&page=1&format=xml&q=";
    
    private AllocineXMLParser parser = new AllocineXMLParser();
    private UrlProviderSource source = new UrlProviderSource();
    
    public List<Cinema> getCinemasParNom(String nom) 
    {
        List<Cinema> resultat = parser.parseCinemaFromInputStream(source.getInputStream(apiUrl + searchCinemaPath + nom));
        
        return resultat;
    }
    
}
