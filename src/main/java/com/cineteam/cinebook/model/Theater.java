/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cineteam.cinebook.model;

/**
 *
 * @author alexis
 */
public class Theater 
{
    private String name;
    private String id;
    private String address;
    private String zipcode;
    private String city;
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String aName)
    {
        name = aName;
    }
    
    public String getId()
    {
        return id;
    }
    
    public void setId(String anId)
    {
        id = anId;
    }
    
    public String getAddress()
    {
        return address;
    }
    
    public void setAddress(String anAddress)
    {
        address = anAddress;
    }
    public String getZipCode()
    {
        return zipcode;
    }
    
    public void setZipCode(String aZipCode)
    {
        zipcode = aZipCode;
    }
    public String getCity()
    {
        return city;
    }
    
    public void setCity(String aCity)
    {
        city = aCity;
    }
}
