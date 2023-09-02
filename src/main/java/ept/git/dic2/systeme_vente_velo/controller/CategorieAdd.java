package ept.git.dic2.systeme_vente_velo.controller;



import ept.git.dic2.systeme_vente_velo.beans.CategorieBean;
import ept.git.dic2.systeme_vente_velo.model.Categorie;
import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import java.io.Serializable;

@Named("addCategorie") // on doit mettre le même nom que la classe avec la premiere lettre en miniscule
@ViewScoped // Pour dire que le managed bean aura une durée de vie de la page : tant que l'utilisateur est sur cette page , le managed bean existe

public class CategorieAdd implements Serializable {
    @EJB // Permet de dire au serveur de
    private CategorieBean categorieFacade;

    // C est pour créer des valeurs par défaut pour tout élève comme école: EPT par exemple
    //private Categorie categorie =new Categorie("41","Arauna","Pouye",112.2);
    private Categorie categorie =new Categorie();

    private String message ="";
    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public String getMessage() {
        return message;
    }

    public String save (){
        message="Categorie enregistré";
        categorieFacade.create(categorie);
        System.out.println("Categorie enregistré" + categorie);
        categorie = new Categorie();
        return  "categorieList.xhtml?faces-redirect=true";
    }
}
