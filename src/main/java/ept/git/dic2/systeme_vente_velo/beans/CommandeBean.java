package ept.git.dic2.systeme_vente_velo.beans;

import ept.git.dic2.systeme_vente_velo.model.Commande;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
@Stateless
public class CommandeBean extends AbstractBean<Commande> {
    @PersistenceContext(name = "dic2PU")
    private EntityManager entityManager;
    public CommandeBean() {
        super(Commande.class);
    }
    protected EntityManager getEntityManager(){
        return entityManager;
    };
}
