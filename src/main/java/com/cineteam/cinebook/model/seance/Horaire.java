package com.cineteam.cinebook.model.seance;

import java.util.Date;
import java.util.List;

/** @author alexis */
public class Horaire 
{
    private Date jour;
    private List<String> heures;

    public Date getJour() {
        return jour;
    }

    public void setJour(Date jour) {
        this.jour = jour;
    }

    public List<String> getHeures() {
        return heures;
    }

    public void setHeures(List<String> heures) {
        this.heures = heures;
    }
}
