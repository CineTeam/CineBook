package com.cineteam.cinebook.model.commentaire;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/** @author Bérangère */
public class CommentaireCinemaEntityManager implements ICommentaireCinemaEntityManager {
    
    private static final long serialVersionUID = 1L;

    private EntityManagerFactory emf;
    private EntityManager em;

    public CommentaireCinemaEntityManager()
    {
        emf = Persistence.createEntityManagerFactory("JPAPersistence");
        em = emf.createEntityManager();
        em.getTransaction().begin();
    }
    
    public void creerCommentaire_Cinema(CommentaireCinema commentaire_cinema) {
        em.persist(commentaire_cinema);
    }
        
    public List<CommentaireCinema> rechercherCommentaires_cinema(String id_cinema){
        Query query= em.createQuery("from CommentaireCinema where id_cinema = :id_cinema order by date desc").setParameter("id_cinema",id_cinema);
        return (List<CommentaireCinema>) query.getResultList();
    }
}
