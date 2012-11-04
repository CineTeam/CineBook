/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cineteam.cinebook.provider;

import com.cineteam.cinebook.model.Theater;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alexis
 */
public class AllocineTheaterProvider implements ITheatersProvider
{
    private static String apiUrl = "http://api.allocine.fr/rest/v3/";
    private static String searchTheatersPath = "search?partner=YW5kcm9pZC12M3M&filter=theater&count=200&page=1&format=xml&q=";
    
    private AllocineXMLParser parser = new AllocineXMLParser();
    private UrlProviderSource source = new UrlProviderSource();
    
    public List<Theater> getTheatersByName(String searchName) 
    {
        List<Theater> results = parser.parseTheaterFromInputStream(source.getInputStream(apiUrl + searchTheatersPath + searchName));
        
        return results;
    }
    
}
