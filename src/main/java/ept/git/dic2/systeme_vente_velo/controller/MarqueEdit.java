package ept.git.dic2.systeme_vente_velo.controller;

import ept.git.dic2.systeme_vente_velo.beans.MarqueBean;
import ept.git.dic2.systeme_vente_velo.model.Marque;
import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import java.io.Serializable;

@Named("marqueEditMbean")
@ViewScoped
public class MarqueEdit implements Serializable {
    @EJB
    private MarqueBean marqueFacade;

    private Marque marque;
    private String message = "";

    public MarqueEdit() {
    }

    public String getMessage() {
        return message;
    }

    public Marque getMarque() {
        return marque;
    }

    public void setMarque(Marque marque) {
        this.marque = marque;
    }

    public String edit() {
        marqueFacade.edit(marque);
        message = "Marque modifié avec succès : " + marque.getNom();
        System.out.println("Marque modifié : " + marque);
        return null; // Vous pouvez laisser cette méthode renvoyer null car la mise à jour se fait via la boîte de dialogue.
    }
}
