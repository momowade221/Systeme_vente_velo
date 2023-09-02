package ept.git.dic2.systeme_vente_velo.beans;

import ept.git.dic2.systeme_vente_velo.model.ArticleCommande;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
@Stateless
public class ArticleCommandeBean extends AbstractBean<ArticleCommande> {
    @PersistenceContext(name = "dic2PU")
    private EntityManager entityManager;
    public ArticleCommandeBean() {
        super(ArticleCommande.class);
    }
    protected EntityManager getEntityManager(){
        return entityManager;
    };
}
