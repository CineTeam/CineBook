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
import org.joda.time.Period;
import org.joda.time.Seconds;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.PeriodFormatter;
import org.joda.time.format.PeriodFormatterBuilder;

/** @author alexis */
public class FilmXMLParser extends AXMLParser
{
    public List<Film> parserLesFilmsAPartirDeLInputStream(InputStream is)
    {
        Document document = getDocumentFromInputStream(is);
        List<Film> films = parserLesFilmsAPartirDuDocument(document);
        return films;
    }
    
     public Film parserLeFilmAPartirDeLInputStream(InputStream is)
    {
        Document document = getDocumentFromInputStream(is);
        Film film = parserLeFilmAPartirDuDocument(document);
        return film;
    }
    
    private List<Film> parserLesFilmsAPartirDuDocument(Document document)
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
                Film film = parserLeFilm(courant);        
                films.add(film);
            }
        }
        return films;
    }
    
    private Film parserLeFilmAPartirDuDocument(Document document) {
        Film film = null; 
        if (document != null)
        {
            Element racine = document.getRootElement();
            film = parserLeFilm(racine);
        }
        return film;
    }

    public Film parserLeFilm(Element courant) {
        Film film = new Film();
        film.setId(courant.getAttributeValue("code"));
        film.setTitre(parseTitre(courant));
        film.setDate_sortie(parseDateSortie(courant));
        film.setRealisateur(parseRealisateur(courant));
        film.setActeurs(parseActeurs(courant));
        film.setNote_presse(parseNotePresse(courant));
        film.setNote_utilisateurs(parseNoteUtilisateurs(courant));
        film.setUrl_affiche(parseUrlAffiche(courant));
        film.setUrl_bande_annonce(parseUrlBandeAnnonce(courant));
        film.setDuree(parseDuree(courant));
        film.setGenres(parseGenre(courant));
        film.setPays(parsePays(courant));
        film.setSynopsis(parseSynopsis(courant));
        return film;
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
    
    private String parseUrlBandeAnnonce(Element courant) {
        Element bandeAnnonce = courant.getChild("trailer", defaultNameSpace);
        if(bandeAnnonce != null)
        {
             return bandeAnnonce.getAttributeValue("href");
        }
        return null;
    }
   
    private String parseDuree(Element courant) {
        String duree = courant.getChildText("runtime", defaultNameSpace);
        if(duree != null)
        {
           Seconds secondes = Seconds.seconds(Integer.parseInt(duree));
           Period p1 = new Period(secondes);
           PeriodFormatter dhm = new PeriodFormatterBuilder().appendHours().appendSuffix("h").appendMinutes().toFormatter();
           return dhm.print(p1.normalizedStandard());
        }
        return null;
    }
    
      private List<String> parsePays(Element courant) {
        Element element_pays = courant.getChild("nationalityList", defaultNameSpace);
        if(element_pays != null)
        {
            List<String> pays = new ArrayList();
            List list_pays = element_pays.getChildren("nationality", defaultNameSpace);
            
            Iterator i = list_pays.iterator();
            while(i.hasNext())
            {
                Element pays_courant = (Element)i.next();
                pays.add(pays_courant.getText());
            }
            return pays;
        }
        return null;
    }
    
      private List<String> parseGenre(Element courant) {
        Element element_genre = courant.getChild("genreList", defaultNameSpace);
        if(element_genre != null)
        {
            List<String> genres = new ArrayList();
            List list_genre = element_genre.getChildren("genre", defaultNameSpace);
            
            Iterator i = list_genre.iterator();
            while(i.hasNext())
            {
                Element genre_courant = (Element)i.next();
                genres.add(genre_courant.getText());
            }
            return genres;
        }
        return null;
    }
      
     private String parseSynopsis(Element courant) 
     {
        return courant.getChildText("synopsis", defaultNameSpace);
    }
  
      
}
