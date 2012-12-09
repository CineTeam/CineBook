package com.cineteam.cinebook.model.utilisateur;

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
    
    public void modifierUtilisateur(Utilisateur utilisateur){
        Utilisateur uti = em.find(Utilisateur.class, utilisateur.getId());
        uti.setAdresse(utilisateur.getAdresse());
        uti.setCode_postal(utilisateur.getCode_postal());
        uti.setVille(utilisateur.getVille());
        em.getTransaction().commit();
    }
    
    
}
