/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cineteam.cinebook.testprovider;

import com.cineteam.cinebook.model.Theater;
import com.cineteam.cinebook.provider.ITheatersProvider;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alexis
 */
public class MockTheaterProvider implements ITheatersProvider
{
    List<Theater> theaters;
    
    public MockTheaterProvider (List<Theater> _theaters)
    {
        theaters = _theaters;
    }
    
    public List<Theater> getTheatersByName(String searchName)
    {
        List<Theater> results = new ArrayList<Theater>();
        
        for(Theater theater : theaters)
        {
            if(theater.getName().contains(searchName))
            {
                results.add(theater);
            }
        }
        
        return results;
    }
    
}
