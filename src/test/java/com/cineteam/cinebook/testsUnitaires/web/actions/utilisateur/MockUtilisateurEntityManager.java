package com.cineteam.cinebook.testsUnitaires.web.actions.utilisateur;

import com.cineteam.cinebook.model.utilisateur.IUtilisateurEntityManager;
import com.cineteam.cinebook.model.utilisateur.Utilisateur;
import java.util.ArrayList;
import java.util.List;

/** @author Bérangère */
class MockUtilisateurEntityManager implements IUtilisateurEntityManager{

    public List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
    public boolean utilisateurCree = false;
    
    public void creerUtilisateur(Utilisateur utilisateur) {
        utilisateurCree = true;
        utilisateurs.add(utilisateur);
    }

    public Utilisateur rechercherUtilisateur(String login) {
        for(Utilisateur utilisateur : utilisateurs)
            if(utilisateur.getLogin().equals(login))
                return utilisateur;
        return null;     
    }
    
}
