package ept.git.dic2.systeme_vente_velo.controller;

import ept.git.dic2.systeme_vente_velo.beans.MagasinBean;
import ept.git.dic2.systeme_vente_velo.model.Magasin;
import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.List;

@Named("listeMagasinsMbean") // on doit mettre le même nom que la classe avec la premiere lettre en miniscule
@ViewScoped // Pour dire que le managed bean aura une durée de vie de la page : tant que l'utilisateur est sur cette page , le managed bean existe

public class MagasinsList implements Serializable {
    @EJB // Permet de dire au serveur de
    private MagasinBean magasinFacade;

    // C est pour créer des valeurs par défaut pour tout élève comme école: EPT par exemple
    //private Magasin magasin =new Magasin("41","Arauna","Pouye",112.2);
    private Magasin selected_magasin ;
    private List<Magasin> magasins;

    public Magasin getSelected_magasin() {
        return selected_magasin;
    }

    public void setSelected_magasin(Magasin selected_magasin) {
        this.selected_magasin = selected_magasin;
    }

    public List<Magasin> getMagasins() {
        if (magasins==null) {
            magasins=magasinFacade.findAll();
        }
        return magasins;
    }

    public void setMagasins(List<Magasin> magasins) {
        this.magasins = magasins;
    }
}

