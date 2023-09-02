package ept.git.dic2.systeme_vente_velo.beans;

import ept.git.dic2.systeme_vente_velo.model.Magasin;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
@Stateless
public class MagasinBean extends AbstractBean<Magasin> {
    @PersistenceContext(name = "dic2PU")
    private EntityManager entityManager;
    public MagasinBean() {
        super(Magasin.class);
    }
    protected EntityManager getEntityManager(){
        return entityManager;
    };
}
