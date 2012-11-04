/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cineteam.cinebook.testprovider;

import com.cineteam.cinebook.provider.FileProviderSource;
import java.io.InputStream;
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
public class FileProviderSourceTest {
    
    @Test
    public void returnInputStreamForValidUrl() 
    {
        FileProviderSource source = new FileProviderSource();
        InputStream is = source.getInputStream("TestXml/searchTheater.xml");
        
        assertNotNull(is);
    }
    
    @Test
    public void returnNullForInvalidUrl() 
    {
        FileProviderSource source = new FileProviderSource();
        InputStream is = source.getInputStream("pooom.xml");
        
        assertNull(is);
    }
}
