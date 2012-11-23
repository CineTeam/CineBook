package com.cineteam.cinebook.model.testprovider.seance;

import com.cineteam.cinebook.model.entity.Seances_film;
import com.cineteam.cinebook.model.provider.FileProviderSource;
import com.cineteam.cinebook.model.provider.seance.SeanceXMLParser;
import java.util.List;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/** @author alexis */
public class TestSeanceXMLParser 
{
    private SeanceXMLParser parser;
    private FileProviderSource source;
   
    @Before
    public void setUp()
    {
        parser = new SeanceXMLParser();
        source = new FileProviderSource();
    }
    
    @Test
    public void retourneDesSeancePourUnCinema()
    {
        List<Seances_film> seances = parser.parserLesSeancesPourUnCinema(source.getInputStream("TestXml/seanceCinema.xml"));
        
        assertNotNull(seances);
        assertTrue(seances.size() > 0);
    }
    
}
