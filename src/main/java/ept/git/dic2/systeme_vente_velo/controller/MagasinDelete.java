package ept.git.dic2.systeme_vente_velo.controller;

import ept.git.dic2.systeme_vente_velo.beans.MagasinBean;
import ept.git.dic2.systeme_vente_velo.model.Magasin;
import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import java.io.Serializable;

@Named("magasinDeleteMbean")
@ViewScoped
public class MagasinDelete implements Serializable {
    @EJB
    private MagasinBean magasinFacade;

    private String message = "";

    public MagasinDelete() {
    }

    public String getMessage() {
        return message;
    }

    public String delete(Magasin magasin) {
        magasinFacade.remove(magasin);
        message = "Magasin supprimé : " + magasin.getNom();
        System.out.println("Magasin supprimé : " + magasin);
        return "magasinList.xhtml?faces-redirect=true";
    }
}
