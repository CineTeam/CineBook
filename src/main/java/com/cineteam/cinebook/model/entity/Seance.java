package com.cineteam.cinebook.model.entity;

import java.util.List;

/**@author alexis */
public class Seance 
{
    private String langue;
    private String format;
    private List<Horaire> horaires;

    public String getLangue() {
        return langue;
    }

    public void setLangue(String langue) {
        this.langue = langue;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public List<Horaire> getHoraires() {
        return horaires;
    }

    public void setHoraires(List<Horaire> horaires) {
        this.horaires = horaires;
    }
}
