package com.cineteam.cinebook.model.testprovider;

import com.cineteam.cinebook.model.provider.AllocineApiUrlBuilder;
import com.cineteam.cinebook.model.provider.AllocineApiUrlBuilder.Filtres;
import com.cineteam.cinebook.model.provider.AllocineApiUrlBuilder.Methodes;
import com.cineteam.cinebook.model.provider.AllocineApiUrlBuilder.NiveauDetail;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/** @author alexis */
public class TestAllocineApiUrlBuilder {
    
    @Test
    public void retourneUrlAPIAvecMethodeALinitialisation()
    {
        String url = new AllocineApiUrlBuilder(Methodes.RECHERCHE).getUrl();
        assertEquals("http://api.allocine.fr/rest/v3/search?partner=YW5kcm9pZC12M3M&format=xml", url);
    }

    @Test
    public void retourneUrlAvecLesBonsParametre()
    {
        String url = new AllocineApiUrlBuilder(Methodes.RECHERCHE).ajouterLaPage(1).ajouterLeNombreDeResultat(200)
                                                                  .ajouterLeFiltre(Filtres.CINEMA).ajouterLaRequete("test").getUrl();
        assertEquals("http://api.allocine.fr/rest/v3/search?partner=YW5kcm9pZC12M3M&format=xml&page=1&count=200&filter=theater&q=test", url);
    }
    
    @Test
    public void retourneUrlDesDixDerniersFilmsAvecLesBonsParametres()
    {
        String url = new AllocineApiUrlBuilder(Methodes.FILMSENSALLE).ajouterLaPage(1).ajouterLeNombreDeResultat(10)
                                                                  .ajouterLeFiltre(Filtres.ENSALLE).ajouterLOrdre(AllocineApiUrlBuilder.Ordre.DATEDESC).getUrl();
        assertEquals("http://api.allocine.fr/rest/v3/movielist?partner=YW5kcm9pZC12M3M&format=xml&page=1&count=10&filter=nowshowing&order=datedesc", url);
    }
    
    @Test
    public void retourneUrlDuDetailDunFilmAvecLesBonsParametres()
    {
        String url = new AllocineApiUrlBuilder(Methodes.DETAILFILM).ajouterLIdentifiant("61282").ajouterLeNiveauDeDetail(NiveauDetail.MEDIUM).ajouterLeFiltre(Filtres.FILM)
                                                                    .ajouterLaSuppressionDeBaliseHTML().getUrl();
        assertEquals("http://api.allocine.fr/rest/v3/movie?partner=YW5kcm9pZC12M3M&format=xml&code=61282&profile=medium&filter=movie&striptags=synopsis", url);
    }
    
    @Test
    public void retourneUrlDesCinemasAuxAlentours()
    {
        String url = new AllocineApiUrlBuilder(Methodes.LISTECINEMA).ajouterLeCodePostal("33000").ajouterLeNombreDeResultat(200).getUrl();
        assertEquals("http://api.allocine.fr/rest/v3/theaterlist?partner=YW5kcm9pZC12M3M&format=xml&zip=33000&count=200", url);
    }
    
    @Test
    public void retourneUrlDUnCinemaAvecLesBonsParemetres()
    {
        String url = new AllocineApiUrlBuilder(Methodes.DETAILCINEMA).ajouterLIdentifiant("W3300").ajouterLeNiveauDeDetail(NiveauDetail.LARGE).getUrl();
        assertEquals("http://api.allocine.fr/rest/v3/theater?partner=YW5kcm9pZC12M3M&format=xml&code=W3300&profile=large", url);
    }
}
