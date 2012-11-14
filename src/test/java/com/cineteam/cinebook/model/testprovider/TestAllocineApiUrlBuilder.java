package com.cineteam.cinebook.model.testprovider;

import com.cineteam.cinebook.model.provider.AllocineApiUrlBuilder;
import com.cineteam.cinebook.model.provider.AllocineApiUrlBuilder.Methodes;
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
                                                                  .ajouterLeFiltre(AllocineApiUrlBuilder.Filtres.CINEMA).ajouterLaRequete("test").getUrl();
        assertEquals("http://api.allocine.fr/rest/v3/search?partner=YW5kcm9pZC12M3M&format=xml&page=1&count=200&filter=theater&q=test", url);
    }
    
    @Test
    public void retourneUrlDesDixDerniersFilmsAvecLesBonsParametres()
    {
        String url = new AllocineApiUrlBuilder(Methodes.FILMSENSALLE).ajouterLaPage(1).ajouterLeNombreDeResultat(10)
                                                                  .ajouterLeFiltre(AllocineApiUrlBuilder.Filtres.ENSALLE).ajouterLOrdre(AllocineApiUrlBuilder.Ordre.DATEDESC).getUrl();
        assertEquals("http://api.allocine.fr/rest/v3/movielist?partner=YW5kcm9pZC12M3M&format=xml&page=1&count=10&filter=nowshowing&order=datedesc", url);
    }
}
