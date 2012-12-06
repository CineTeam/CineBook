package com.cineteam.cinebook.entitymanager.commentaire_cinema;

import com.cineteam.cinebook.model.entity.Commentaire_cinema;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/** @author Bérangère */
public class Commentaire_CinemaEntityManager implements ICommentaire_CinemaEntityManager {
    
    private static final long serialVersionUID = 1L;

    private EntityManagerFactory emf;
    private EntityManager em;

    public Commentaire_CinemaEntityManager() {
        emf = Persistence.createEntityManagerFactory("JPAPersistence");
        em = emf.createEntityManager();
        em.getTransaction().begin();
    }

    public void setEntityManager(String _persistence_unit_name){
        emf = Persistence.createEntityManagerFactory(_persistence_unit_name);
        em = emf.createEntityManager();
        em.getTransaction().begin();
    }
    
    public void creerCommentaire_Cinema(Commentaire_cinema commentaire_cinema) {
        em.persist(commentaire_cinema);
    }
        
    public List<Commentaire_cinema> rechercherCommentaires_cinema(String id_cinema){
        Query query= em.createQuery("from Commentaire_cinema where id_cinema = :id_cinema order by date desc").setParameter("id_cinema",id_cinema);
        return (List<Commentaire_cinema>) query.getResultList();
    }
}
