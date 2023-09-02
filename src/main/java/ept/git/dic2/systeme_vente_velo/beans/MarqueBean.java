package ept.git.dic2.systeme_vente_velo.beans;

import ept.git.dic2.systeme_vente_velo.model.Marque;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
@Stateless
public class MarqueBean extends AbstractBean<Marque> {
    @PersistenceContext(name = "dic2PU")
    private EntityManager entityManager;
    public MarqueBean() {
        super(Marque.class);
    }
    protected EntityManager getEntityManager(){
        return entityManager;
    };
}
