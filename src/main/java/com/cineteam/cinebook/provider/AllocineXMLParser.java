/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cineteam.cinebook.provider;

import com.cineteam.cinebook.model.Theater;
import java.io.InputStream;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.Namespace;
import org.jdom.input.SAXBuilder;

/**
 *
 * @author alexis
 */
public class AllocineXMLParser 
{
    
    public List<Theater> parseTheaterFromInputStream(InputStream is)
    {
        Document document = getDocumentFromInputStream(is);
        
        List<Theater> theaters = parseTheaterFromDocument(document);
        
        return theaters;
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
    
    private List<Theater> parseTheaterFromDocument(Document document)
    {
        List<Theater> theaters = new ArrayList<Theater>(); 
        Namespace defaultNameSpace = Namespace.getNamespace("http://www.allocine.net/v6/ns/");
        Element racine = document.getRootElement();
        
        List listTheater = racine.getChildren("theater", defaultNameSpace);
        
        Iterator i = listTheater.iterator();
        while(i.hasNext())
        {
            Element courant = (Element)i.next();
            
            Theater theater = new Theater();
            theater.setId(courant.getAttributeValue("code"));
            theater.setName(courant.getChildText("name", defaultNameSpace));
            theater.setAddress(courant.getChildText("address", defaultNameSpace));
            theater.setZipCode(courant.getChildText("postalCode", defaultNameSpace));
            theater.setCity(courant.getChildText("city", defaultNameSpace));
            
            theaters.add(theater);
        }
        
        return theaters;
    }
}
