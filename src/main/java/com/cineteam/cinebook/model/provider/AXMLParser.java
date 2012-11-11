package com.cineteam.cinebook.model.provider;

import java.io.InputStream;
import org.jdom.Document;
import org.jdom.Namespace;
import org.jdom.input.SAXBuilder;

/** @author alexis */
public abstract class AXMLParser 
{
    protected static String allocineNameSpace = "http://www.allocine.net/v6/ns/";
    protected Namespace defaultNameSpace = Namespace.getNamespace(allocineNameSpace);
    
    protected Document getDocumentFromInputStream(InputStream is)
    {
        SAXBuilder sxb = new SAXBuilder();
        Document document = null;
        try {
           document = sxb.build(is);
        }
        catch(Exception e){}
        
        return document;
    }
}
