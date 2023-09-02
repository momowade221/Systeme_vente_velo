package ept.git.dic2.systeme_vente_velo.controller;

import ept.git.dic2.systeme_vente_velo.beans.CategorieBean;
import ept.git.dic2.systeme_vente_velo.model.Categorie;
import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.List;

@Named("listeCategoriesMbean") // on doit mettre le même nom que la classe avec la premiere lettre en miniscule
@ViewScoped // Pour dire que le managed bean aura une durée de vie de la page : tant que l'utilisateur est sur cette page , le managed bean existe

public class CategoriesList implements Serializable {
    @EJB // Permet de dire au serveur de
    private CategorieBean categorieFacade;

    // C est pour créer des valeurs par défaut pour tout élève comme école: EPT par exemple
    //private Categorie categorie =new Categorie("41","Arauna","Pouye",112.2);
    private Categorie selected_categorie ;
    private List<Categorie> categories;

    public Categorie getSelected_categorie() {
        return selected_categorie;
    }

    public void setSelected_categorie(Categorie selected_categorie) {
        this.selected_categorie = selected_categorie;
    }

    public List<Categorie> getCategories() {
        if (categories==null) {
            categories=categorieFacade.findAll();
        }
        return categories;
    }

    public void setCategories(List<Categorie> categories) {
        this.categories = categories;
    }
}

