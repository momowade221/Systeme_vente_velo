package ept.git.dic2.systeme_vente_velo.controller;

import ept.git.dic2.systeme_vente_velo.beans.ProduitBean;
import ept.git.dic2.systeme_vente_velo.model.Produit;
import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import java.io.Serializable;

@Named("produitDeleteMbean")
@ViewScoped
public class ProduitDelete implements Serializable {
    @EJB
    private ProduitBean produitFacade;

    private String message = "";

    public ProduitDelete() {
    }

    public String getMessage() {
        return message;
    }

    public String delete(Produit produit) {
        produitFacade.remove(produit);
        message = "Produit supprimé : " + produit.getNom();
        System.out.println("Produit supprimé : " + produit);
        return "produitList.xhtml?faces-redirect=true";
    }
}
