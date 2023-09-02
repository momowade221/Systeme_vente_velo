package ept.git.dic2.systeme_vente_velo.controller;



import ept.git.dic2.systeme_vente_velo.beans.MagasinBean;
import ept.git.dic2.systeme_vente_velo.model.Magasin;
import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import java.io.Serializable;

@Named("addMagasin") // on doit mettre le même nom que la classe avec la premiere lettre en miniscule
@ViewScoped // Pour dire que le managed bean aura une durée de vie de la page : tant que l'utilisateur est sur cette page , le managed bean existe

public class MagasinAdd implements Serializable {
    @EJB // Permet de dire au serveur de
    private MagasinBean magasinFacade;

    // C est pour créer des valeurs par défaut pour tout élève comme école: EPT par exemple
    //private Magasin magasin =new Magasin("41","Arauna","Pouye",112.2);
    private Magasin magasin =new Magasin();

    private String message ="";
    public Magasin getMagasin() {
        return magasin;
    }

    public void setMagasin(Magasin magasin) {
        this.magasin = magasin;
    }

    public String getMessage() {
        return message;
    }

    public String save (){
        message="Magasin enregistré";
        magasinFacade.create(magasin);
        System.out.println("Magasin enregistré" + magasin);
        magasin = new Magasin();
        return  "magasinList.xhtml?faces-redirect=true";
    }
}
