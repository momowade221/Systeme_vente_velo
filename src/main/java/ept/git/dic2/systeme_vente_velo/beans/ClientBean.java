package ept.git.dic2.systeme_vente_velo.beans;

import ept.git.dic2.systeme_vente_velo.model.Client;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
@Stateless
public class ClientBean extends AbstractBean<Client> {
    @PersistenceContext(name = "dic2PU")
    private EntityManager entityManager;
    public ClientBean() {
        super(Client.class);
    }
    protected EntityManager getEntityManager(){
        return entityManager;
    };
}
