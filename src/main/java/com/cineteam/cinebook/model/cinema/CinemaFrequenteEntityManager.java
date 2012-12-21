package com.cineteam.cinebook.model.cinema;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/** @author Bérangère */
public class CinemaFrequenteEntityManager implements ICinemaFrequenteEntityManager {
    
    private static final long serialVersionUID = 1L;

    private EntityManagerFactory emf;
    private EntityManager em;

    public CinemaFrequenteEntityManager() {
        emf = Persistence.createEntityManagerFactory("JPAPersistence");
        em = emf.createEntityManager();
        em.getTransaction().begin();
    }

    public void enregistrerCinemaFrequente(CinemaFrequente cinemaFrequente) {
        em.persist(cinemaFrequente);
    }

    public List<CinemaFrequente> rechercherCinemasFrequentes(Long id_utilisateur) {
        Query query= em.createQuery("from CinemaFrequente where id_utilisateur = :id_utilisateur").setParameter("id_utilisateur",id_utilisateur);
        return (List<CinemaFrequente>) query.getResultList();
    }

    public void supprimerCinemasFrequentes(Long id_utilisateur) {
        Query query = em.createNativeQuery("DELETE FROM CinemaFrequente WHERE id_utilisateur = :id_utilisateur").setParameter("id_utilisateur", id_utilisateur);
        query.executeUpdate();
    }
}