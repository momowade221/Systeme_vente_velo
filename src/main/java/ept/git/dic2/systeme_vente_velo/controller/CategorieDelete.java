package ept.git.dic2.systeme_vente_velo.controller;

import ept.git.dic2.systeme_vente_velo.beans.CategorieBean;
import ept.git.dic2.systeme_vente_velo.model.Categorie;
import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import java.io.Serializable;

@Named("categorieDeleteMbean")
@ViewScoped
public class CategorieDelete implements Serializable {
    @EJB
    private CategorieBean categorieFacade;

    private String message = "";

    // Constructeur par défaut
    public CategorieDelete() {
    }

    public String getMessage() {
        return message;
    }

    public String delete(Categorie categorie) {
        categorieFacade.remove(categorie);
        message = "Catégorie supprimée : " + categorie.getNom();
        System.out.println("Catégorie supprimée : " + categorie);
        return "categorieList.xhtml?faces-redirect=true";
    }
}
