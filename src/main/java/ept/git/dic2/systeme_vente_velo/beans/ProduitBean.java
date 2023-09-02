package ept.git.dic2.systeme_vente_velo.beans;

import ept.git.dic2.systeme_vente_velo.model.Produit;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
@Stateless
public class ProduitBean extends AbstractBean<Produit> {
    @PersistenceContext(name = "dic2PU")
    private EntityManager entityManager;
    public ProduitBean() {
        super(Produit.class);
    }
    protected EntityManager getEntityManager(){
        return entityManager;
    };
}
