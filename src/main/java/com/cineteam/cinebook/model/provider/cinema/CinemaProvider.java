package com.cineteam.cinebook.model.provider.cinema;

import com.cineteam.cinebook.model.entity.Cinema;
import com.cineteam.cinebook.model.provider.AllocineApiUrlBuilder;
import com.cineteam.cinebook.model.provider.AllocineApiUrlBuilder.Methodes;
import com.cineteam.cinebook.model.provider.AllocineApiUrlBuilder.Filtres;
import com.cineteam.cinebook.model.provider.UrlProviderSource;
import java.util.List;

/** @author alexis */
public class CinemaProvider implements ICinemaProvider {

    private CinemaXMLParser parser = new CinemaXMLParser();
    private UrlProviderSource source = new UrlProviderSource();
    
    public List<Cinema> getCinemasParNom(String nom) 
    {
        String url = new AllocineApiUrlBuilder(Methodes.RECHERCHE).ajouterLaPage(1).ajouterLeNombreDeResultat(200)
                                                                  .ajouterLeFiltre(Filtres.CINEMA).ajouterLaRequete(nom).getUrl();
        List<Cinema> resultat = parser.parseCinemaFromInputStream(source.getInputStream(url));
        return resultat;
    }
    
}
