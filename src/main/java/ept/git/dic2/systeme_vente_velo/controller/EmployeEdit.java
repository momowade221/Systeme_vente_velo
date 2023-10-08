package ept.git.dic2.systeme_vente_velo.controller;

import ept.git.dic2.systeme_vente_velo.beans.EmployeBean;
import ept.git.dic2.systeme_vente_velo.model.Employe;
import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import java.io.Serializable;

@Named("employeEditMbean")
@ViewScoped
public class EmployeEdit implements Serializable {
    @EJB
    private EmployeBean employeFacade;

    private Employe employe;
    private String message = "";

    public EmployeEdit() {
    }

    public String getMessage() {
        return message;
    }

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    public String edit() {
        employeFacade.edit(employe);
        message = "Employe modifié avec succès : " +employe.getPrenom() +" "+ employe.getNom();
        System.out.println("Employe modifié : " + employe);
        return null; // Vous pouvez laisser cette méthode renvoyer null car la mise à jour se fait via la boîte de dialogue.
    }
}
