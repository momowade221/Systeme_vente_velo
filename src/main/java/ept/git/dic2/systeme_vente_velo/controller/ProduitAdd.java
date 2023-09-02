package ept.git.dic2.systeme_vente_velo.controller;



import ept.git.dic2.systeme_vente_velo.beans.ProduitBean;
import ept.git.dic2.systeme_vente_velo.model.Produit;
import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import java.io.Serializable;

@Named("addProduit") // on doit mettre le même nom que la classe avec la premiere lettre en miniscule
@ViewScoped // Pour dire que le managed bean aura une durée de vie de la page : tant que l'utilisateur est sur cette page , le managed bean existe

public class ProduitAdd implements Serializable {
    @EJB // Permet de dire au serveur de
    private ProduitBean produitFacade;

    // C est pour créer des valeurs par défaut pour tout élève comme école: EPT par exemple
    //private Produit produit =new Produit("41","Arauna","Pouye",112.2);
    private Produit produit =new Produit();

    private String message ="";
    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public String getMessage() {
        return message;
    }

    public String save (){
        message="Produit enregistré";
        produitFacade.create(produit);
        System.out.println("Produit enregistré" + produit);
        produit = new Produit();
        return  "produitList.xhtml?faces-redirect=true";
    }
}
