package ept.git.dic2.systeme_vente_velo.controller;



import ept.git.dic2.systeme_vente_velo.beans.CommandeBean;
import ept.git.dic2.systeme_vente_velo.model.Commande;
import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import java.io.Serializable;

@Named("addCommande") // on doit mettre le même nom que la classe avec la premiere lettre en miniscule
@ViewScoped // Pour dire que le managed bean aura une durée de vie de la page : tant que l'utilisateur est sur cette page , le managed bean existe

public class CommandeAdd implements Serializable {
    @EJB // Permet de dire au serveur de
    private CommandeBean commandeFacade;

    // C est pour créer des valeurs par défaut pour tout élève comme école: EPT par exemple
    //private Commande commande =new Commande("41","Arauna","Pouye",112.2);
    private Commande commande =new Commande();

    private String message ="";
    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public String getMessage() {
        return message;
    }

    public String save (){
        message="Commande enregistré";
        commandeFacade.create(commande);
        System.out.println("Commande enregistré" + commande);
        commande = new Commande();
        return  "commandeList.xhtml?faces-redirect=true";
    }
}
