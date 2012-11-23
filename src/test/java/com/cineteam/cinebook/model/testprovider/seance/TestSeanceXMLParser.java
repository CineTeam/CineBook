package com.cineteam.cinebook.model.testprovider.seance;

import com.cineteam.cinebook.model.entity.Seance;
import com.cineteam.cinebook.model.provider.FileProviderSource;
import com.cineteam.cinebook.model.provider.seance.SeanceXMLParser;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

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
        List<Seance> seances = parser.parserLesSeancesPourUnCinema(source.getInputStream("TestXml/seanceCinema.xml"));
        
        assertNotNull(seances);
        assertTrue(seances.size() > 0);
    }
    
}
