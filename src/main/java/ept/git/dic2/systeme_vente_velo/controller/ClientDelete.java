package ept.git.dic2.systeme_vente_velo.controller;

import ept.git.dic2.systeme_vente_velo.beans.ClientBean;
import ept.git.dic2.systeme_vente_velo.model.Client;
import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import java.io.Serializable;

@Named("clientDeleteMbean")
@ViewScoped
public class ClientDelete implements Serializable {
    @EJB
    private ClientBean clientFacade;

    private String message = "";

    // Constructeur par défaut
    public ClientDelete() {
    }

    public String getMessage() {
        return message;
    }

    public String delete(Client client) {
        clientFacade.remove(client);
        message = "Client supprimé : " + client.getNom() + " " + client.getPrenom();
        System.out.println("Client supprimé : " + client);
        return "clientList.xhtml?faces-redirect=true";
    }
}
