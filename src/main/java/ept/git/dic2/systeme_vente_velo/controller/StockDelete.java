package ept.git.dic2.systeme_vente_velo.controller;

import ept.git.dic2.systeme_vente_velo.beans.StockBean;
import ept.git.dic2.systeme_vente_velo.model.Stock;
import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import java.io.Serializable;

@Named("stockDeleteMbean")
@ViewScoped
public class StockDelete implements Serializable {
    @EJB
    private StockBean stockFacade;

    private String message = "";

    public StockDelete() {
    }

    public String getMessage() {
        return message;
    }

    public String delete(Stock stock) {
        stockFacade.remove(stock);
        message = "Stock supprimé : " + stock.getProduitId();
        System.out.println("Stock supprimé : " + stock);
        return "stockList.xhtml?faces-redirect=true";
    }
}
