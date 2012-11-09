package com.cineteam.cinebook.model.testprovider;

import com.cineteam.cinebook.model.provider.UrlProviderSource;
import java.io.InputStream;
import static org.junit.Assert.*;
import org.junit.Test;

/** @author alexis */
public class TestUrlProviderSource
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
