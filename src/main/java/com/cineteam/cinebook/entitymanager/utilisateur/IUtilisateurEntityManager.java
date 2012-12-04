package com.cineteam.cinebook.entitymanager.utilisateur;

import com.cineteam.cinebook.model.entity.Utilisateur;

/** @author Bérangère */
public interface IUtilisateurEntityManager {
    
    public void creerUtilisateur(Utilisateur utilisateur);
    public Utilisateur rechercherUtilisateur(String login);

}
