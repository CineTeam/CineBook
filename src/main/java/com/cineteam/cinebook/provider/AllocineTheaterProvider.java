/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cineteam.cinebook.provider;

import com.cineteam.cinebook.model.Theater;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alexis
 */
public class AllocineTheaterProvider implements ITheatersProvider
{

    public List<Theater> getTheatersByName(String searchName) 
    {
        List<Theater> results = new ArrayList<Theater>();
        
        results.add(new Theater());
        
        return results;
    }
    
}
