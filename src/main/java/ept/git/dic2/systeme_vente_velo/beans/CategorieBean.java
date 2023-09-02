package ept.git.dic2.systeme_vente_velo.beans;

import ept.git.dic2.systeme_vente_velo.model.Categorie;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
@Stateless
public class CategorieBean extends AbstractBean<Categorie> {
    @PersistenceContext(name = "dic2PU")
    private EntityManager entityManager;
    public CategorieBean() {
        super(Categorie.class);
    }
    protected EntityManager getEntityManager(){
        return entityManager;
    };
}
