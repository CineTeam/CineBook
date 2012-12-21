package com.cineteam.cinebook.model.cinema;

import com.cineteam.cinebook.model.provider.AllocineApiUrlBuilder;
import com.cineteam.cinebook.model.provider.AllocineApiUrlBuilder.Filtres;
import com.cineteam.cinebook.model.provider.AllocineApiUrlBuilder.Methodes;
import com.cineteam.cinebook.model.provider.AllocineApiUrlBuilder.NiveauDetail;
import com.cineteam.cinebook.model.provider.UrlProviderSource;
import java.util.ArrayList;
import java.util.List;

/** @author alexis */
public class CinemaProvider implements ICinemaProvider {

    private CinemaXMLParser parser = new CinemaXMLParser();
    private UrlProviderSource source = new UrlProviderSource();
    
    public List<Cinema> rechercherCinemasParMotCle(String nom) 
    {
        String url = new AllocineApiUrlBuilder(Methodes.RECHERCHE).ajouterLaPage(1).ajouterLeNombreDeResultat(200)
                                                                  .ajouterLeFiltre(Filtres.CINEMA).ajouterLaRequete(nom).getUrl();
        List<Cinema> resultat = parser.parserLesCinemasAPartirDeInputStream(source.getInputStream(url));
        return resultat;
    }
    
    public List<Cinema> rechercherCinemasParCodePostal(String codePostal) 
    {
        String url = new AllocineApiUrlBuilder(Methodes.LISTECINEMA).ajouterLeNombreDeResultat(200).ajouterLeCodePostal(codePostal).getUrl();
        List<Cinema> resultat = parser.parserLesCinemasAPartirDeInputStream(source.getInputStream(url));
        return resultat;
    }
    
    public Cinema getDetailCinema (String id)
    {
        String url = new AllocineApiUrlBuilder(Methodes.DETAILCINEMA).ajouterLIdentifiant(id).ajouterLeNiveauDeDetail(NiveauDetail.LARGE).getUrl();
        Cinema resultat = parser.parserLeCinemaAPartirDeInputStream(source.getInputStream(url));
        return resultat; 
    }
    
    public List<Cinema> getCinemasParIds(List<CinemaFrequente> idsCinemas)
    {
        List<Cinema> cinemasFrequentes = new ArrayList<Cinema>();
        if(idsCinemas != null)
        {
            for(int i =0; i< idsCinemas.size(); i++)
            {
                Cinema cinema = getDetailCinema(idsCinemas.get(i).getId_cinema());
                cinemasFrequentes.add(cinema);
            }
        }
        return cinemasFrequentes;
    }
    
}
