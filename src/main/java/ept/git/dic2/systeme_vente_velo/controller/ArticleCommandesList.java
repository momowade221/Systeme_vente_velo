package ept.git.dic2.systeme_vente_velo.controller;

import ept.git.dic2.systeme_vente_velo.beans.ArticleCommandeBean;
import ept.git.dic2.systeme_vente_velo.model.ArticleCommande;
import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.List;

@Named("listeArticleCommandesMbean") // on doit mettre le même nom que la classe avec la premiere lettre en miniscule
@ViewScoped // Pour dire que le managed bean aura une durée de vie de la page : tant que l'utilisateur est sur cette page , le managed bean existe

public class ArticleCommandesList implements Serializable {
    @EJB // Permet de dire au serveur de
    private ArticleCommandeBean articleCommandeFacade;

    // C est pour créer des valeurs par défaut pour tout élève comme école: EPT par exemple
    //private ArticleCommande articleCommande =new ArticleCommande("41","Arauna","Pouye",112.2);
    private ArticleCommande selected_articleCommande ;
    private List<ArticleCommande> articleCommandes;

    public ArticleCommande getSelected_articleCommande() {
        return selected_articleCommande;
    }

    public void setSelected_articleCommande(ArticleCommande selected_articleCommande) {
        this.selected_articleCommande = selected_articleCommande;
    }

    public List<ArticleCommande> getArticleCommandes() {
        if (articleCommandes==null) {
            articleCommandes=articleCommandeFacade.findAll();
        }
        return articleCommandes;
    }

    public void setArticleCommandes(List<ArticleCommande> articleCommandes) {
        this.articleCommandes = articleCommandes;
    }
}

