package ept.git.dic2.systeme_vente_velo.controller;

import ept.git.dic2.systeme_vente_velo.beans.ArticleCommandeBean;
import ept.git.dic2.systeme_vente_velo.model.ArticleCommande;
import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import java.io.Serializable;

@Named("articleCommandeDeleteMbean")
@ViewScoped
public class ArticleCommandeDelete implements Serializable {
    @EJB
    private ArticleCommandeBean articleCommandeFacade;

    private String message = "";

    public ArticleCommandeDelete() {
    }

    public String getMessage() {
        return message;
    }

    public String delete(ArticleCommande articleCommande) {
        articleCommandeFacade.remove(articleCommande);
        message = "Article de Commande supprimé : " + articleCommande.getLigne();
        System.out.println("Article de Commande supprimé : " + articleCommande);
        return "articleCommandeList.xhtml?faces-redirect=true";
    }
}
