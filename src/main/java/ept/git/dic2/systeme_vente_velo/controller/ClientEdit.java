package ept.git.dic2.systeme_vente_velo.controller;

import ept.git.dic2.systeme_vente_velo.beans.ClientBean;
import ept.git.dic2.systeme_vente_velo.model.Client;
import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import java.io.Serializable;

@Named("clientEditMbean")
@ViewScoped
public class ClientEdit implements Serializable {
    @EJB
    private ClientBean clientFacade;

    private Client client;
    private String message = "";

    public ClientEdit() {
    }

    public String getMessage() {
        return message;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String edit() {
        clientFacade.edit(client);
        message = "Client modifié avec succès : " + client.getNom();
        System.out.println("Client modifié : " + client);
        return null; // Vous pouvez laisser cette méthode renvoyer null car la mise à jour se fait via la boîte de dialogue.
    }
}
