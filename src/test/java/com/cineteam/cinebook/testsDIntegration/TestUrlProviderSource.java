package com.cineteam.cinebook.testsDIntegration;

import com.cineteam.cinebook.model.provider.UrlProviderSource;
import java.io.InputStream;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
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
