package com.cineteam.cinebook.model.provider;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/** @author alexis */
public class UrlProviderSource implements IProviderSource {

    public InputStream getInputStream(String sourcePath)
    {
        sourcePath = StringUtils.formaterPourUneUrl(sourcePath);
        URL url = null;
        InputStream is = null;
        try {
            url = new URL(sourcePath);
            is = url.openStream();
        } 
        catch (MalformedURLException ex) {}
        catch (IOException ex) {}

        return is;
    }
    
}
