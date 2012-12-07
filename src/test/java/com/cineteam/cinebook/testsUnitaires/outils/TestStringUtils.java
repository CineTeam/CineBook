package com.cineteam.cinebook.testsUnitaires.outils;

import com.cineteam.cinebook.outils.StringUtils;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/** @author alexis */
public class TestStringUtils
{
    @Test
    public void retourneUneChaineSansAccent()
    {
        String texte = "éèàêù";
        String resultat = StringUtils.remplacerLesAccents(texte);
        assertEquals("eeaeu", resultat);
    }
    
    @Test 
    public void remplaceLesEspacePourUneUrl()
    {
        String texte = "une url";
        String resultat = StringUtils.remplacerLesEspacesPourUneUrl(texte);
        assertEquals("une%20url", resultat);
    }
    
    @Test
    public void retourneUneUrlFormate()
    {
        String texte = "une url éèàùê";
        String resultat = StringUtils.formaterPourUneUrl(texte);
        assertEquals("une%20url%20eeaue", resultat);
    }
    
    @Test 
    public void retourneFauxSiLaChaineEstNull()
    {
        String test = null;
        assertEquals(true, StringUtils.estVide(test));
    }
    
    @Test 
    public void retourneFauxSiLaChaineEstVide()
    {
        String test = "";
        assertEquals(true, StringUtils.estVide(test));
    }
    
    @Test 
    public void retourneVraiSiLaChaineEstRemplie()
    {
        String test = "test";
        assertEquals(false, StringUtils.estVide(test));
    }
}
