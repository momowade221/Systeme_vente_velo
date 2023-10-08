package ept.git.dic2.systeme_vente_velo.controller;

import ept.git.dic2.systeme_vente_velo.beans.EleveBean;
import ept.git.dic2.systeme_vente_velo.model.Eleve;
import jakarta.ejb.EJB;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import java.io.Serializable;

@Named("eleveDeleteMbean")
@ViewScoped
public class EleveDelete implements Serializable {
    @EJB
    private EleveBean eleveFacade;

    private String message = "";

    // Ajoutez un constructeur par défaut
    public EleveDelete() {
    }

    public String getMessage() {
        return message;
    }

    public String delete(Eleve eleve) {
        eleveFacade.remove(eleve);
        message = "Élève supprimé : " + eleve.getNom() + " " + eleve.getPrenom();

        // Ajouter un message de succès
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Succès", message));

        return "listeEleves.xhtml?faces-redirect=true";
    }
}
