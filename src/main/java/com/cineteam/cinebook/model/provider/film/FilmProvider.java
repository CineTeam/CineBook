package com.cineteam.cinebook.model.provider.film;

import com.cineteam.cinebook.model.entity.Film;
import com.cineteam.cinebook.model.provider.AllocineApiUrlBuilder;
import com.cineteam.cinebook.model.provider.AllocineApiUrlBuilder.Filtres;
import com.cineteam.cinebook.model.provider.AllocineApiUrlBuilder.Methodes;
import com.cineteam.cinebook.model.provider.AllocineApiUrlBuilder.Ordre;
import com.cineteam.cinebook.model.provider.UrlProviderSource;
import java.util.ArrayList;
import java.util.List;

/** @author alexis */
public class FilmProvider implements IFilmProvider
{
    private FilmXMLParser parser = new FilmXMLParser();
    private UrlProviderSource source = new UrlProviderSource();
    
    public List<Film> getFilmsParNom(String nom) 
    {
        String url = new AllocineApiUrlBuilder(Methodes.RECHERCHE).ajouterLaPage(1).ajouterLeNombreDeResultat(200)
                                                                  .ajouterLeFiltre(Filtres.FILM).ajouterLaRequete(nom).getUrl();
        List<Film> films = parser.parseFilmFromInputStream(source.getInputStream(url));
        List<Film> resultats = new ArrayList<Film>();
        for(Film film : films)
        {
            if(film.getTitre().contains(nom))
            {
                resultats.add(film);
            }
        }
        return resultats;
    }

    public List<Film> getDixDerniersFilms() {
        String url = new AllocineApiUrlBuilder(Methodes.FILMSENSALLE).ajouterLaPage(1).ajouterLeNombreDeResultat(10)
                                                                  .ajouterLeFiltre(Filtres.ENSALLE).ajouterLOrdre(Ordre.DATEDESC).getUrl();
        List<Film> films = parser.parseFilmFromInputStream(source.getInputStream(url));

        return films;
    }
    
}
