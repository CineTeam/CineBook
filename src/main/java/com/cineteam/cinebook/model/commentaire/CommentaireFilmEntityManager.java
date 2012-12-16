package com.cineteam.cinebook.model.commentaire;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/** @author alexis */

public class CommentaireFilmEntityManager implements ICommentaireFilmEntityManager 
{
    private static final long serialVersionUID = 1L;

    private EntityManagerFactory emf;
    private EntityManager em;

    public CommentaireFilmEntityManager()
    {
        emf = Persistence.createEntityManagerFactory("JPAPersistence");
        em = emf.createEntityManager();
        em.getTransaction().begin();
    }
    
    public void creerCommentaireFilm(CommentaireFilm commentaireFilm)
    {
        em.persist(commentaireFilm);
    }

    public List<CommentaireFilm> rechercherCommentairesFilm(String idFilm)
    {
        Query query= em.createQuery("from CommentaireFilm where id_film = :id_film order by date desc").setParameter("id_film",idFilm);
        return (List<CommentaireFilm>) query.getResultList();
    }

    public void supprimerCommentaireFilmDeLUtilisateur(Long id_utilisateur) {
        Query query = em.createNativeQuery("DELETE FROM commentairefilm WHERE id_utilisateur = :id_utilisateur").setParameter("id_utilisateur", id_utilisateur);
        query.executeUpdate();
    }   
}
