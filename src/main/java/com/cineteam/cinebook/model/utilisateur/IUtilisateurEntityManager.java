package com.cineteam.cinebook.model.utilisateur;

/** @author Bérangère */
public interface IUtilisateurEntityManager {
    
    public void creerUtilisateur(Utilisateur utilisateur);
    public Utilisateur rechercherUtilisateur(String login);
    public void modifierUtilisateur(Utilisateur utilisateur);

}
