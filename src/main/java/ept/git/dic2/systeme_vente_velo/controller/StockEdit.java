package ept.git.dic2.systeme_vente_velo.controller;

import ept.git.dic2.systeme_vente_velo.beans.StockBean;
import ept.git.dic2.systeme_vente_velo.model.Stock;
import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import java.io.Serializable;

@Named("stockEditMbean")
@ViewScoped
public class StockEdit implements Serializable {
    @EJB
    private StockBean stockFacade;

    private Stock stock;
    private String message = "";

    public StockEdit() {
    }

    public String getMessage() {
        return message;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public String edit() {
        stockFacade.edit(stock);
        message = "Stock modifié avec succès : " + stock.getProduitId();
        System.out.println("Stock modifié : " + stock);
        return null; // Vous pouvez laisser cette méthode renvoyer null car la mise à jour se fait via la boîte de dialogue.
    }
}
