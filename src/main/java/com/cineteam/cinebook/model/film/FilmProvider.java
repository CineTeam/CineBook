package com.cineteam.cinebook.model.film;

import com.cineteam.cinebook.model.provider.AllocineApiUrlBuilder;
import com.cineteam.cinebook.model.provider.AllocineApiUrlBuilder.Filtres;
import com.cineteam.cinebook.model.provider.AllocineApiUrlBuilder.Methodes;
import com.cineteam.cinebook.model.provider.AllocineApiUrlBuilder.NiveauDetail;
import com.cineteam.cinebook.model.provider.AllocineApiUrlBuilder.Ordre;
import com.cineteam.cinebook.model.provider.UrlProviderSource;
import java.util.ArrayList;
import java.util.List;

/** @author alexis */
public class FilmProvider implements IFilmProvider
{
    private FilmXMLParser parser = new FilmXMLParser();
    private UrlProviderSource source = new UrlProviderSource();
    
    public List<Film> rechercherFilmParMotCle(String mot_cle) 
    {
        String url = new AllocineApiUrlBuilder(Methodes.RECHERCHE).ajouterLaPage(1).ajouterLeNombreDeResultat(200)
                                                                  .ajouterLeFiltre(Filtres.FILM).ajouterLaRequete(mot_cle).getUrl();
        List<Film> films = parser.parserLesFilmsAPartirDeLInputStream(source.getInputStream(url));
        return films;
    }

    public List<Film> getDixDerniersFilms() {
        String url = new AllocineApiUrlBuilder(Methodes.FILMSENSALLE).ajouterLaPage(1).ajouterLeNombreDeResultat(10)
                                                                  .ajouterLeFiltre(Filtres.ENSALLE).ajouterLOrdre(Ordre.DATEDESC).getUrl();
        List<Film> films = parser.parserLesFilmsAPartirDeLInputStream(source.getInputStream(url));

        return films;
    }

    public Film getDetailFilm(String id) {
         String url =new AllocineApiUrlBuilder(Methodes.DETAILFILM).ajouterLIdentifiant(id).ajouterLeNiveauDeDetail(NiveauDetail.MEDIUM)
                                                                    .ajouterLeFiltre(Filtres.FILM).ajouterLaSuppressionDeBaliseHTML().getUrl();
        Film film = parser.parserLeFilmAPartirDeLInputStream(source.getInputStream(url));

        return film;
    }
    
    public List<Film> getFilmsParIds(List<FilmVu> idsFilms)
    {
        List<Film> filmsVus = new ArrayList<Film>();
        if(idsFilms != null)
        {
            for(int i =0; i< idsFilms.size(); i++)
            {
                Film film = getDetailFilm(idsFilms.get(i).getId_film());
                filmsVus.add(film);
            }
        }
        return filmsVus;
    }
}
