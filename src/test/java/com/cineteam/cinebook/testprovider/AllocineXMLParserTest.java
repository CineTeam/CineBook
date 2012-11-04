/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cineteam.cinebook.testprovider;

import com.cineteam.cinebook.model.Theater;
import com.cineteam.cinebook.provider.AllocineXMLParser;
import com.cineteam.cinebook.provider.FileProviderSource;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author alexis
 */
public class AllocineXMLParserTest {
    
    public AllocineXMLParserTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void parserReturnListOfTheater() 
    {
        AllocineXMLParser parser = new AllocineXMLParser();
        FileProviderSource source = new FileProviderSource();
        
        List<Theater> theaters = parser.parseTheaterFromInputStream(source.getInputStream("TestXml/searchTheater.xml"));
        
        assertNotNull(theaters);
    }
    
    @Test
    public void parserReturnTheatersFromTestXml()
    {
        AllocineXMLParser parser = new AllocineXMLParser();
        FileProviderSource source = new FileProviderSource();
        
        List<Theater> theaters = parser.parseTheaterFromInputStream(source.getInputStream("TestXml/searchTheater.xml"));
        
        assertNotNull(theaters);
        assertTrue(theaters.size() > 0);
    }
    
    @Test
    public void parserReturnCompleteTheatersFromTestXml()
    {
        AllocineXMLParser parser = new AllocineXMLParser();
        FileProviderSource source = new FileProviderSource();
        
        List<Theater> theaters = parser.parseTheaterFromInputStream(source.getInputStream("TestXml/searchTheater.xml"));
        Theater theater = theaters.get(0);
        
        assertNotNull(theaters);
        assertEquals("W3300", theater.getId());
        assertEquals("Mega CGR Français - Bordeaux", theater.getName());
        assertEquals("9 rue Montesquieu  ", theater.getAddress());
        assertEquals("33000", theater.getZipCode());
        assertEquals("Bordeaux", theater.getCity());
    }
}
