/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cineteam.cinebook.testprovider;

import com.cineteam.cinebook.provider.UrlProviderSource;
import java.io.InputStream;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author alexis
 */
public class UrlProviderSourceTest
{
    
    @Test
    public void returnInputStreamForValidUrl() 
    {
        UrlProviderSource source = new UrlProviderSource();
        InputStream is = source.getInputStream("http://www.google.com");
        
        assertNotNull(is);
    }
    
    @Test
    public void returnNullForInvalidUrl() 
    {
        UrlProviderSource source = new UrlProviderSource();
        InputStream is = source.getInputStream("saer://www.gooooogle.com");
        
        assertNull(is);
    }
}
