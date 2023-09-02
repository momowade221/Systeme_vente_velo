package ept.git.dic2.systeme_vente_velo.controller;



import ept.git.dic2.systeme_vente_velo.beans.StockBean;
import ept.git.dic2.systeme_vente_velo.model.Stock;
import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import java.io.Serializable;

@Named("addStock") // on doit mettre le même nom que la classe avec la premiere lettre en miniscule
@ViewScoped // Pour dire que le managed bean aura une durée de vie de la page : tant que l'utilisateur est sur cette page , le managed bean existe

public class StockAdd implements Serializable {
    @EJB // Permet de dire au serveur de
    private StockBean stockFacade;

    // C est pour créer des valeurs par défaut pour tout élève comme école: EPT par exemple
    //private Stock stock =new Stock("41","Arauna","Pouye",112.2);
    private Stock stock =new Stock();

    private String message ="";
    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public String getMessage() {
        return message;
    }

    public String save (){
        message="Stock enregistré";
        stockFacade.create(stock);
        System.out.println("Stock enregistré" + stock);
        stock = new Stock();
        return  "stockList.xhtml?faces-redirect=true";
    }
}
