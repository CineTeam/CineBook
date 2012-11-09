package com.cineteam.cinebook.model.provider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/** @author alexis */
public class FileProviderSource implements IProviderSource {

    public InputStream getInputStream(String sourcePath) 
    {
        File file = new File(sourcePath);
        InputStream is = null;
        try {
            is = new FileInputStream(file);
        } 
        catch (FileNotFoundException ex){}
        return is;
    }

}
