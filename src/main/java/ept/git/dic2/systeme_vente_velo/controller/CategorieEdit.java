package ept.git.dic2.systeme_vente_velo.controller;

import ept.git.dic2.systeme_vente_velo.beans.CategorieBean;
import ept.git.dic2.systeme_vente_velo.model.Categorie;
import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import java.io.Serializable;

@Named("categorieEditMbean")
@ViewScoped
public class CategorieEdit implements Serializable {
    @EJB
    private CategorieBean categorieFacade;

    private Categorie categorie;
    private String message = "";

    public CategorieEdit() {
    }

    public String getMessage() {
        return message;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public String edit() {
        categorieFacade.edit(categorie);
        message = "Catégorie modifiée : " + categorie.getNom();
        System.out.println("Catégorie modifiée : " + categorie);
        return null; // Vous pouvez laisser cette méthode renvoyer null car la mise à jour se fait via la boîte de dialogue.
    }
}
