package ept.git.dic2.systeme_vente_velo.controller;

import ept.git.dic2.systeme_vente_velo.beans.MagasinBean;
import ept.git.dic2.systeme_vente_velo.model.Magasin;
import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import java.io.Serializable;

@Named("magasinEditMbean")
@ViewScoped
public class MagasinEdit implements Serializable {
    @EJB
    private MagasinBean magasinFacade;

    private Magasin magasin;
    private String message = "";

    public MagasinEdit() {
    }

    public String getMessage() {
        return message;
    }

    public Magasin getMagasin() {
        return magasin;
    }

    public void setMagasin(Magasin magasin) {
        this.magasin = magasin;
    }

    public String edit() {
        magasinFacade.edit(magasin);
        message = "Magasin modifié avec succès : " + magasin.getNom();
        System.out.println("Magasin modifié : " + magasin);
        return null; // Vous pouvez laisser cette méthode renvoyer null car la mise à jour se fait via la boîte de dialogue.
    }
}
