package ept.git.dic2.systeme_vente_velo.controller;



import ept.git.dic2.systeme_vente_velo.beans.ArticleCommandeBean;
import ept.git.dic2.systeme_vente_velo.model.ArticleCommande;
import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import java.io.Serializable;

@Named("addArticleCommande") // on doit mettre le même nom que la classe avec la premiere lettre en miniscule
@ViewScoped // Pour dire que le managed bean aura une durée de vie de la page : tant que l'utilisateur est sur cette page , le managed bean existe

public class ArticleCommandeAdd implements Serializable {
    @EJB // Permet de dire au serveur de
    private ArticleCommandeBean articleCommandeFacade;

    // C est pour créer des valeurs par défaut pour tout élève comme école: EPT par exemple
    //private ArticleCommande articleCommande =new ArticleCommande("41","Arauna","Pouye",112.2);
    private ArticleCommande articleCommande =new ArticleCommande();

    private String message ="";
    public ArticleCommande getArticleCommande() {
        return articleCommande;
    }

    public void setArticleCommande(ArticleCommande articleCommande) {
        this.articleCommande = articleCommande;
    }

    public String getMessage() {
        return message;
    }

    public String save (){
        message="ArticleCommande enregistré";
        articleCommandeFacade.create(articleCommande);
        System.out.println("ArticleCommande enregistré" + articleCommande);
        articleCommande = new ArticleCommande();
        return  "articleCommandeList.xhtml?faces-redirect=true";
    }
}
