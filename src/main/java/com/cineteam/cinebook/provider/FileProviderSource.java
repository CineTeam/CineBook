/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cineteam.cinebook.provider;

import java.io.File;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alexis
 */
public class FileProviderSource implements IProviderSource
{

    public InputStream getInputStream(String sourcePath) 
    {
        File file = new File(sourcePath);
        
        InputStream is = null;
        
        try 
        {
            is = new FileInputStream(file);
        } 
        catch (FileNotFoundException ex) 
        {
            Logger.getLogger(FileProviderSource.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return is;
    }

}
