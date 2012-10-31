/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cineteam.cinebook.provider;

import com.cineteam.cinebook.model.Theater;
import java.util.List;

/**
 *
 * @author alexis
 */
public interface ITheatersProvider
{
    public List<Theater> getTheatersByName(String searchName);
}
