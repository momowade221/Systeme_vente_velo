package ept.git.dic2.systeme_vente_velo.controller;

import ept.git.dic2.systeme_vente_velo.beans.MarqueBean;
import ept.git.dic2.systeme_vente_velo.model.Marque;
import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import java.io.Serializable;

@Named("marqueDeleteMbean")
@ViewScoped
public class MarqueDelete implements Serializable {
    @EJB
    private MarqueBean marqueFacade;

    private String message = "";

    public MarqueDelete() {
    }

    public String getMessage() {
        return message;
    }

    public String delete(Marque marque) {
        marqueFacade.remove(marque);
        message = "Marque supprimée : " + marque.getNom();
        System.out.println("Marque supprimée : " + marque);
        return "marqueList.xhtml?faces-redirect=true";
    }
}
