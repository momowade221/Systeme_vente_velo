package ept.git.dic2.systeme_vente_velo.controller;

import ept.git.dic2.systeme_vente_velo.beans.ProduitBean;
import ept.git.dic2.systeme_vente_velo.model.Produit;
import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.List;

@Named("listeProduitsMbean") // on doit mettre le même nom que la classe avec la premiere lettre en miniscule
@ViewScoped // Pour dire que le managed bean aura une durée de vie de la page : tant que l'utilisateur est sur cette page , le managed bean existe

public class ProduitsList implements Serializable {
    @EJB // Permet de dire au serveur de
    private ProduitBean produitFacade;

    // C est pour créer des valeurs par défaut pour tout élève comme école: EPT par exemple
    //private Produit produit =new Produit("41","Arauna","Pouye",112.2);
    private Produit selected_produit ;
    private List<Produit> produits;

    public Produit getSelected_produit() {
        return selected_produit;
    }

    public void setSelected_produit(Produit selected_produit) {
        this.selected_produit = selected_produit;
    }

    public List<Produit> getProduits() {
        if (produits==null) {
            produits=produitFacade.findAll();
        }
        return produits;
    }

    public void setProduits(List<Produit> produits) {
        this.produits = produits;
    }
}

