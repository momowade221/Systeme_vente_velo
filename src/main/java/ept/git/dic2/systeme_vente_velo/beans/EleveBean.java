package ept.git.dic2.systeme_vente_velo.beans;

import ept.git.dic2.systeme_vente_velo.model.Eleve;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
@Stateless
public class EleveBean extends AbstractBean<Eleve> {
    @PersistenceContext(name = "dic2PU")
    private EntityManager entityManager;
    public EleveBean() {
        super(Eleve.class);
    }
    protected EntityManager getEntityManager(){
        return entityManager;
    };
}
