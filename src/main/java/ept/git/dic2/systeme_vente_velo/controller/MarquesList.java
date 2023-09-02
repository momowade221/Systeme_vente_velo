package ept.git.dic2.systeme_vente_velo.controller;

import ept.git.dic2.systeme_vente_velo.beans.MarqueBean;
import ept.git.dic2.systeme_vente_velo.model.Marque;
import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.List;

@Named("listeMarquesMbean") // on doit mettre le même nom que la classe avec la premiere lettre en miniscule
@ViewScoped // Pour dire que le managed bean aura une durée de vie de la page : tant que l'utilisateur est sur cette page , le managed bean existe

public class MarquesList implements Serializable {
    @EJB // Permet de dire au serveur de
    private MarqueBean marqueFacade;

    // C est pour créer des valeurs par défaut pour tout élève comme école: EPT par exemple
    //private Marque marque =new Marque("41","Arauna","Pouye",112.2);
    private Marque selected_marque ;
    private List<Marque> marques;

    public Marque getSelected_marque() {
        return selected_marque;
    }

    public void setSelected_marque(Marque selected_marque) {
        this.selected_marque = selected_marque;
    }

    public List<Marque> getMarques() {
        if (marques==null) {
            marques=marqueFacade.findAll();
        }
        return marques;
    }

    public void setMarques(List<Marque> marques) {
        this.marques = marques;
    }
}

