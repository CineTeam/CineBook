package com.cineteam.cinebook.model.provider;

import java.io.InputStream;

/** @author alexis */
public interface IProviderSource 
{
    public InputStream getInputStream(String sourcePath);
}
