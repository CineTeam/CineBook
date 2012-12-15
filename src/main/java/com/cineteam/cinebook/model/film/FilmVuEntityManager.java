package com.cineteam.cinebook.model.film;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/** @author Bérangère */
public class FilmVuEntityManager implements IFilmVuEntityManager {
    
    private static final long serialVersionUID = 1L;

    private EntityManagerFactory emf;
    private EntityManager em;

    public FilmVuEntityManager() {
        emf = Persistence.createEntityManagerFactory("JPAPersistence");
        em = emf.createEntityManager();
        em.getTransaction().begin();
    }

    public void enregistrerFilmVu(FilmVu filmVu){
        em.persist(filmVu);
    }
    
    public List<FilmVu> rechercherFilmsVus(int id_utilisateur){
        Query query= em.createQuery("from FilmVu where id_utilisateur = :id_utilisateur").setParameter("id_utilisateur",id_utilisateur);
        return (List<FilmVu>) query.getResultList();
    }
    
}