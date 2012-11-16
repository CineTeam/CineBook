package com.cineteam.cinebook.model.provider.film;

import com.cineteam.cinebook.model.entity.Film;
import com.cineteam.cinebook.model.provider.AXMLParser;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.jdom.Document;
import org.jdom.Element;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/** @author alexis */
public class FilmXMLParser extends AXMLParser
{
    public List<Film> parseFilmFromInputStream(InputStream is)
    {
        Document document = getDocumentFromInputStream(is);
        List<Film> films = parseFilmsFromDocument(document);
        return films;
    }
    
    private List<Film> parseFilmsFromDocument(Document document)
    {
        List<Film> films = new ArrayList<Film>(); 
        if (document != null)
        {
            Element racine = document.getRootElement();

            List listeFilmes = racine.getChildren("movie", defaultNameSpace);

            Iterator i = listeFilmes.iterator();
            while(i.hasNext())
            {
                Element courant = (Element)i.next();

                Film film = new Film();
                film.setId(courant.getAttributeValue("code"));
                film.setTitre(parseTitre(courant));
                film.setDate_sortie(parseDateSortie(courant));
                film.setRealisateur(parseRealisateur(courant));
                film.setActeurs(parseActeurs(courant));
                film.setNote_presse(parseNotePresse(courant));
                film.setNote_utilisateurs(parseNoteUtilisateurs(courant));
                film.setUrl_affiche(parseUrlAffiche(courant));
                
                films.add(film);
            }
        }
        return films;
    }

    private String parseTitre(Element courant) {
        if(courant.getChildText("title", defaultNameSpace) != null)
        {
            return courant.getChildText("title", defaultNameSpace);
        }
        else
        {
            return courant.getChildText("originalTitle", defaultNameSpace);
        }
    }

    private Date parseDateSortie(Element courant) {
        Element release = courant.getChild("release",defaultNameSpace);
        if(release != null)
        {
            String stringDateSortie = release.getChildText("releaseDate", defaultNameSpace);
            if(stringDateSortie != null)
            {
                DateTimeFormatter formatter;
                if(stringDateSortie.length() > 4)
                {
                     formatter = DateTimeFormat.forPattern("yyyy-MM-dd");    
                }
                else
                {
                    formatter = DateTimeFormat.forPattern("yyyy");
                }
                
                Date dateSortie = null;
                try{
                    DateTime dateSortieDt = formatter.parseDateTime(stringDateSortie);
                    dateSortie = dateSortieDt.toDate();
                }
                catch(Exception e){
                }
                
                return dateSortie;
            }
        }
        
        return null;
    }

    private String parseRealisateur(Element courant) {
        Element casting = courant.getChild("castingShort", defaultNameSpace);
        if(casting != null)
        {
            return casting.getChildText("directors", defaultNameSpace);
        }
        
        return null;
    }
    
    private String parseActeurs(Element courant) {
        Element casting = courant.getChild("castingShort", defaultNameSpace);
        if(casting != null)
        {
            return casting.getChildText("actors", defaultNameSpace);
        }
        
        return null;
    }

    private float parseNotePresse(Element courant) {
        Element statistics = courant.getChild("statistics", defaultNameSpace);
        if(statistics != null)
        {
            if(statistics.getChildText("pressRating", defaultNameSpace) != null)
            {
                return Float.parseFloat(statistics.getChildText("pressRating", defaultNameSpace));
            }
        }
        return 0;
    }
    
    private float parseNoteUtilisateurs(Element courant) {
        Element statistics = courant.getChild("statistics", defaultNameSpace);
        if(statistics != null)
        {
            if(statistics.getChildText("userRating", defaultNameSpace) != null)
            {
                return Float.parseFloat(statistics.getChildText("userRating", defaultNameSpace));
            }
        }
        return 0;
    }

    private String parseUrlAffiche(Element courant) {
        Element poster = courant.getChild("poster", defaultNameSpace);
        if(poster != null)
        {
             return poster.getAttributeValue("href");
        }
        return null;
    }
}
