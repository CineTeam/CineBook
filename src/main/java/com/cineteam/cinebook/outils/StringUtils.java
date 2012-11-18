package com.cineteam.cinebook.outils;

import java.text.Normalizer;

/** @author alexis */
public class StringUtils 
{
    public static String remplacerLesAccents(String texte)
    {
        return Normalizer.normalize(texte, Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
    }
    
    public static String remplacerLesEspacesPourUneUrl(String url)
    {
        return url.replace(" ", "%20");
    }
    
    public static String formaterPourUneUrl(String url)
    {
        url = remplacerLesAccents(url);
        url = remplacerLesEspacesPourUneUrl(url);
        return url;
    }
}
