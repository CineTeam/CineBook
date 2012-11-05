package com.cineteam.cinebook.model.testprovider;

import com.cineteam.cinebook.model.provider.FileProviderSource;
import java.io.InputStream;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.Test;

/** @author alexis */
public class FileProviderSourceTest {
    
    @Test
    public void retourneUnInputStreamPourUneURLValide() 
    {
        FileProviderSource source = new FileProviderSource();
        InputStream is = source.getInputStream("TestXml/searchTheater.xml");
        
        assertNotNull(is);
    }
    
    @Test
    public void retourneNullPourUneURLInvalide() 
    {
        FileProviderSource source = new FileProviderSource();
        InputStream is = source.getInputStream("pooom.xml");
        
        assertNull(is);
    }
}
