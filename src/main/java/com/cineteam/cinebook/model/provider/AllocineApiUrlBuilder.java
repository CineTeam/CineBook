package com.cineteam.cinebook.model.provider;

/** @author alexis */
public class AllocineApiUrlBuilder 
{
    public static enum Methodes
    {
        RECHERCHE ("search"),
        FILMSENSALLE ("movielist"),
        DETAILFILM ("movie"),
        LISTECINEMA ("theaterlist"),
        DETAILCINEMA ("theater");
        
        private final String value;
        
        private Methodes(String value)
        {
            this.value = value;
        }
        
        public String getMethod()
        {
            return value;
        }
    }
    
    public static enum Filtres
    {
        CINEMA ("theater"),
        FILM ("movie"),
        ENSALLE ("nowshowing");
        
        private final String value;
        
        private Filtres(String value)
        {
            this.value = value;
        }
        
        public String getFiltre()
        {
            return value;
        }
    }
    
    public static enum NiveauDetail
    {
        SMALL ("small"),
        MEDIUM ("medium"),
        LARGE ("large");
        
        private final String value;
        
        private NiveauDetail(String value)
        {
            this.value = value;
        }
        
        public String getNiveauDetail()
        {
            return value;
        }
    }
    
    public static enum Ordre
    {
        DATEDESC ("datedesc");
        
        private final String value;
        
        private Ordre(String value)
        {
            this.value = value;
        }
        
        public String getOrdre()
        {
            return value;
        }
    }

    private static String apiUrl = "http://api.allocine.fr/rest/v3/";
    private static String partnerId = "YW5kcm9pZC12M3M";
    private static String format = "xml";
    
    private String url;
    
    public AllocineApiUrlBuilder(Methodes method)
    {
        url = apiUrl + method.getMethod() + "?partner=" + partnerId + "&format=" + format;
    }
    
    public AllocineApiUrlBuilder ajouterLeNombreDeResultat(int count)
    {
        url += "&count=" + count;
        return this;
    }
    
    public AllocineApiUrlBuilder ajouterLaPage(int page)
    {
        url += "&page=" + page;
        return this;
    }
    
    public AllocineApiUrlBuilder ajouterLeFiltre(Filtres filtre)
    {
        url += "&filter=" + filtre.getFiltre();
        return this;
    }
    
    public AllocineApiUrlBuilder ajouterLaRequete(String requete)
    {
        url += "&q=" + requete;
        return this;
    }
    
    public AllocineApiUrlBuilder ajouterLOrdre(Ordre ordre)
    {
        url += "&order=" + ordre.getOrdre();
        return this;
    }
    
    public AllocineApiUrlBuilder ajouterLeNiveauDeDetail(NiveauDetail niveauDetail)
    {
        url += "&profile=" + niveauDetail.getNiveauDetail();
        return this;
    }
     
    public AllocineApiUrlBuilder ajouterLIdentifiant(String id)
    {
        url += "&code=" + id;
        return this;
    }
    
    public AllocineApiUrlBuilder ajouterLaSuppressionDeBaliseHTML()
    {
        url += "&striptags=synopsis";
        return this;
    }
    
    public AllocineApiUrlBuilder ajouterLeCodePostal(String codePostal)
    {
        url += "&zip=" + codePostal;
        return this;
    } 
    
    public String getUrl()
    {
        return url;
    }
}
