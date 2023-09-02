package ept.git.dic2.systeme_vente_velo.beans;

import ept.git.dic2.systeme_vente_velo.model.Employe;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
@Stateless
public class EmployeBean extends AbstractBean<Employe> {
    @PersistenceContext(name = "dic2PU")
    private EntityManager entityManager;
    public EmployeBean() {
        super(Employe.class);
    }
    protected EntityManager getEntityManager(){
        return entityManager;
    };
}
