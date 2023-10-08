package ept.git.dic2.systeme_vente_velo.controller;

import ept.git.dic2.systeme_vente_velo.beans.ArticleCommandeBean;
import ept.git.dic2.systeme_vente_velo.model.ArticleCommande;
import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import java.io.Serializable;

@Named("articleCommandeEditMbean")
@ViewScoped
public class ArticleCommandeEdit implements Serializable {
    @EJB
    private ArticleCommandeBean articleCommandeFacade;

    private ArticleCommande articleCommande;
    private String message = "";

    public ArticleCommandeEdit() {
    }

    public String getMessage() {
        return message;
    }

    public ArticleCommande getArticleCommande() {
        return articleCommande;
    }

    public void setArticleCommande(ArticleCommande articleCommande) {
        this.articleCommande = articleCommande;
    }

    public String edit() {
        articleCommandeFacade.edit(articleCommande);
        message = "Article de commande modifié avec succès : " + articleCommande.getNumeroCommande();
        System.out.println("Article de commande modifié : " + articleCommande);
        return null; // Vous pouvez laisser cette méthode renvoyer null car la mise à jour se fait via la boîte de dialogue.
    }
}
