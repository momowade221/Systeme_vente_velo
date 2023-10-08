package ept.git.dic2.systeme_vente_velo.controller;

import ept.git.dic2.systeme_vente_velo.beans.EmployeBean;
import ept.git.dic2.systeme_vente_velo.model.Employe;
import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import java.io.Serializable;

@Named("employeDeleteMbean")
@ViewScoped
public class EmployeDelete implements Serializable {
    @EJB
    private EmployeBean employeFacade;

    private String message = "";

    // Constructeur par défaut
    public EmployeDelete() {
    }

    public String getMessage() {
        return message;
    }

    public String delete(Employe employe) {
        employeFacade.remove(employe);
        message = "Employé supprimé : " + employe.getNom() + " " + employe.getPrenom();
        System.out.println("Employé supprimé : " + employe);
        return "employeList.xhtml?faces-redirect=true";
    }
}
