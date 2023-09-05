package ept.git.dic2.systeme_vente_velo.controller;

import ept.git.dic2.systeme_vente_velo.beans.ProduitBean;
import ept.git.dic2.systeme_vente_velo.model.Produit;
import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import java.io.Serializable;

@Named("produitEditMbean")
@ViewScoped
public class ProduitEdit implements Serializable {
    @EJB
    private ProduitBean produitFacade;

    private Produit produit;
    private String message = "";

    public ProduitEdit() {
    }

    public String getMessage() {
        return message;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public String edit() {
        produitFacade.edit(produit);
        message = "Produit modifié avec succès : " + produit.getNom();
        System.out.println("Produit modifié : " + produit);
        return null; // Vous pouvez laisser cette méthode renvoyer null car la mise à jour se fait via la boîte de dialogue.
    }
}
