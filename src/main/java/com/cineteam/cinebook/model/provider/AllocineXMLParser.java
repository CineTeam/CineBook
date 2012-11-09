package com.cineteam.cinebook.model.provider;

import com.cineteam.cinebook.model.entity.Cinema;
import java.io.InputStream;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.Namespace;
import org.jdom.input.SAXBuilder;

/** @author alexis */
public class AllocineXMLParser 
{
    
    public List<Cinema> parseCinemaFromInputStream(InputStream is)
    {
        Document document = getDocumentFromInputStream(is);
        
        List<Cinema> cinemas = parseCinemaFromDocument(document);
        
        return cinemas;
    }
    
    private Document getDocumentFromInputStream(InputStream is)
    {
        SAXBuilder sxb = new SAXBuilder();
        Document document = null;
        try
        {
           document = sxb.build(is);
        }
        catch(Exception e)
        {
        }
        
        return document;
    }
    
    private List<Cinema> parseCinemaFromDocument(Document document)
    {
        List<Cinema> cinemas = new ArrayList<Cinema>(); 
        if (document != null)
        {
             Namespace defaultNameSpace = Namespace.getNamespace("http://www.allocine.net/v6/ns/");
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
