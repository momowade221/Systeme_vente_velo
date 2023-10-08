package ept.git.dic2.systeme_vente_velo.controller;

import ept.git.dic2.systeme_vente_velo.beans.CommandeBean;
import ept.git.dic2.systeme_vente_velo.model.Commande;
import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import java.io.Serializable;

@Named("commandeEditMbean")
@ViewScoped
public class CommandeEdit implements Serializable {
    @EJB
    private CommandeBean commandeFacade;

    private Commande commande;
    private String message = "";

    public CommandeEdit() {
    }

    public String getMessage() {
        return message;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public String edit() {
        commandeFacade.edit(commande);
        message = "Commande modifié avec succès : " + commande.getNumero();
        System.out.println("Commande modifié : " + commande);
        return null; // Vous pouvez laisser cette méthode renvoyer null car la mise à jour se fait via la boîte de dialogue.
    }
}
