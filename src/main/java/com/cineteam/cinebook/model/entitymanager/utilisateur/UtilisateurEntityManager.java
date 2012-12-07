package com.cineteam.cinebook.model.entitymanager.utilisateur;

import com.cineteam.cinebook.model.entity.Utilisateur;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/** @author Bérangère */
public class UtilisateurEntityManager implements IUtilisateurEntityManager {
    
    private static final long serialVersionUID = 1L;

    private EntityManagerFactory emf;
    private EntityManager em;

    public UtilisateurEntityManager() {
        emf = Persistence.createEntityManagerFactory("JPAPersistence");
        em = emf.createEntityManager();
        em.getTransaction().begin();
    }

    public void setEntityManager(String _persistence_unit_name){
        emf = Persistence.createEntityManagerFactory(_persistence_unit_name);
        em = emf.createEntityManager();
        em.getTransaction().begin();
    }
    
    public void creerUtilisateur(Utilisateur utilisateur){
        em.persist(utilisateur);
    }
    
    public Utilisateur rechercherUtilisateur(String login){
        Query query= em.createQuery("from Utilisateur where login = :login").setParameter("login",login);
        if(query.getResultList().isEmpty())
            return null;
        else
            return (Utilisateur) query.getResultList().get(0);
    }
}
