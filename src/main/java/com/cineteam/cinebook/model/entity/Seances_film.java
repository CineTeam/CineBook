package com.cineteam.cinebook.model.entity;

import java.util.List;

/** @author alexis */
public class Seances_film 
{
    private Film film;
    private List<Seance> seances;

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public List<Seance> getSeances() {
        return seances;
    }

    public void setSeances(List<Seance> seances) {
        this.seances = seances;
    }
}
