package ept.git.dic2.systeme_vente_velo.beans;

import ept.git.dic2.systeme_vente_velo.model.Stock;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
@Stateless
public class StockBean extends AbstractBean<Stock> {
    @PersistenceContext(name = "dic2PU")
    private EntityManager entityManager;
    public StockBean() {
        super(Stock.class);
    }
    protected EntityManager getEntityManager(){
        return entityManager;
    };
}
