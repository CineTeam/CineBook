/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cineteam.cinebook.provider;

import java.io.InputStream;

/**
 *
 * @author alexis
 */
public interface IProviderSource 
{
    public InputStream getInputStream(String sourcePath);
}
