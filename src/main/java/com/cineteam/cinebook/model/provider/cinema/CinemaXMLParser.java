package com.cineteam.cinebook.model.provider.cinema;

import com.cineteam.cinebook.model.entity.Cinema;
import com.cineteam.cinebook.model.provider.AXMLParser;
import com.cineteam.cinebook.model.entity.Geolocalisation;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom.DataConversionException;
import org.jdom.Document;
import org.jdom.Element;

/** @author alexis */
public class CinemaXMLParser extends AXMLParser{
    
    public List<Cinema> parserLesCinemasAPartirDeInputStream(InputStream is)
    {
        Document document = getDocumentFromInputStream(is);
        List<Cinema> cinemas = parserLesCinemasAPartirDuDocument(document);
        return cinemas;
    }
 
    private List<Cinema> parserLesCinemasAPartirDuDocument(Document document)
    {
        List<Cinema> cinemas = new ArrayList<Cinema>(); 
        if (document != null)
        {
            Element racine = document.getRootElement();

            List listeCinemas = racine.getChildren("theater", defaultNameSpace);

            Iterator i = listeCinemas.iterator();
            while(i.hasNext())
            {
                Element courant = (Element)i.next();

                Cinema cinema = parserLeCinema(courant);

                cinemas.add(cinema);
            }
        }
        return cinemas;
    }
    
    public Cinema parserLeCinemaAPartirDeInputStream(InputStream is)
    {
        Document document = getDocumentFromInputStream(is);
        Cinema cinema = parserLeCinemaAPartirDuDocument(document);
        return cinema;
    }
 
    private Cinema parserLeCinemaAPartirDuDocument(Document document)
    {
        if (document != null)
        {
            Element racine = document.getRootElement();

            Cinema cinema = parserLeCinema(racine);
            
            return cinema;
        }
        return null;
    }
    
    private Cinema parserLeCinema (Element courant)
    {
        Cinema cinema = new Cinema();
        cinema.setId(parseLId(courant));
        cinema.setNom(parseLeNom(courant));
        cinema.setAdresse(parseLAdresse(courant));
        cinema.setCode_postal(parseLeCodePostal(courant));
        cinema.setVille(parseLaVille(courant));
        cinema.setNombre_salles(parseLEcran(courant));
        cinema.setPosition(parseLaPosition(courant));
        cinema.setUrl_image(parseLUrlDeLImage(courant));

        return cinema;
    }
    
    private String parseLId (Element courant)
    {
        return courant.getAttributeValue("code");
    }
    
    private String parseLeNom (Element courant)
    {
        return courant.getChildText("name", defaultNameSpace);
    }
    
    private String parseLAdresse (Element courant)
    {
        return courant.getChildText("address", defaultNameSpace);
    }
    
    private String parseLeCodePostal (Element courant)
    {
        return courant.getChildText("postalCode", defaultNameSpace);
    }
    
    private String parseLaVille (Element courant)
    {
        return courant.getChildText("city", defaultNameSpace);
    }
    
    private int parseLEcran (Element courant)
    {
        if (courant.getChildText("screenCount", defaultNameSpace) != null)
        {
            return Integer.parseInt(courant.getChildText("screenCount", defaultNameSpace));
        }
        return -1;
    }
    
    private Geolocalisation parseLaPosition (Element courant)
    {
        if (courant.getChildText("geoloc", defaultNameSpace) != null)
        {
            Geolocalisation position = new Geolocalisation();
            Element geoloc = courant.getChild("geoloc", defaultNameSpace);
            try {
                position.setLatitude(geoloc.getAttribute("lat").getFloatValue());
                position.setLongitude(geoloc.getAttribute("long").getFloatValue());
                return position;
            } catch (DataConversionException ex) {
            }
        }
        return null;
    }
    
    private String parseLUrlDeLImage (Element courant)
    {
        Element image = courant.getChild("picture", defaultNameSpace);
        if(image != null)
        {
             return image.getAttributeValue("href");
        }
        return null;
    }
}

