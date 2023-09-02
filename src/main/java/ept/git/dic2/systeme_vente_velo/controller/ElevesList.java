package ept.git.dic2.systeme_vente_velo.controller;

import ept.git.dic2.systeme_vente_velo.beans.EleveBean;
import ept.git.dic2.systeme_vente_velo.model.Eleve;
import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.List;

@Named("listeElevesMbean") // on doit mettre le même nom que la classe avec la premiere lettre en miniscule
@ViewScoped // Pour dire que le managed bean aura une durée de vie de la page : tant que l'utilisateur est sur cette page , le managed bean existe

public class ElevesList implements Serializable {
    @EJB // Permet de dire au serveur de
    private EleveBean eleveFacade;

    // C est pour créer des valeurs par défaut pour tout élève comme école: EPT par exemple
    //private Eleve eleve =new Eleve("41","Arauna","Pouye",112.2);
    private Eleve selected_eleve ;
    private List<Eleve> eleves;

    public Eleve getSelected_eleve() {
        return selected_eleve;
    }

    public void setSelected_eleve(Eleve selected_eleve) {
        this.selected_eleve = selected_eleve;
    }

    public List<Eleve> getEleves() {
        if (eleves==null) {
            eleves=eleveFacade.findAll();
        }
        return eleves;
    }

    public void setEleves(List<Eleve> eleves) {
        this.eleves = eleves;
    }
}

