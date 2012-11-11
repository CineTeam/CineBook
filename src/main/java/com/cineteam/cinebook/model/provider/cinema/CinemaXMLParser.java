package com.cineteam.cinebook.model.provider.cinema;

import com.cineteam.cinebook.model.entity.Cinema;
import com.cineteam.cinebook.model.provider.AXMLParser;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jdom.Document;
import org.jdom.Element;

/** @author alexis */
public class CinemaXMLParser extends AXMLParser{
    
    public List<Cinema> parseCinemaFromInputStream(InputStream is)
    {
        Document document = getDocumentFromInputStream(is);
        List<Cinema> cinemas = parseCinemaFromDocument(document);
        return cinemas;
    }
 
    private List<Cinema> parseCinemaFromDocument(Document document)
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

                Cinema cinema = new Cinema();
                cinema.setId(courant.getAttributeValue("code"));
                cinema.setNom(courant.getChildText("name", defaultNameSpace));
                cinema.setAdresse(courant.getChildText("address", defaultNameSpace));
                cinema.setCode_postal(courant.getChildText("postalCode", defaultNameSpace));
                cinema.setVille(courant.getChildText("city", defaultNameSpace));

                cinemas.add(cinema);
            }
        }
        return cinemas;
    }
}
