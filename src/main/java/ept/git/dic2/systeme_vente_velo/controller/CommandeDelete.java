package ept.git.dic2.systeme_vente_velo.controller;

import ept.git.dic2.systeme_vente_velo.beans.CommandeBean;
import ept.git.dic2.systeme_vente_velo.model.Commande;
import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import java.io.Serializable;

@Named("commandeDeleteMbean")
@ViewScoped
public class CommandeDelete implements Serializable {
    @EJB
    private CommandeBean commandeFacade;

    private String message = "";

    // Constructeur par défaut
    public CommandeDelete() {
    }

    public String getMessage() {
        return message;
    }

    public String delete(Commande commande) {
        commandeFacade.remove(commande);
        message = "Commande supprimée : " + commande.getNumero();
        System.out.println("Commande supprimée : " + commande);
        return "commandeList.xhtml?faces-redirect=true";
    }
}
