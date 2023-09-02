package ept.git.dic2.systeme_vente_velo.model;

import jakarta.persistence.*;

@Entity
@IdClass(StockPK.class)
public class Stock {
    private Integer quantite;
    private Integer produitId;
    private Integer magasinId;

    @Basic
    @Column(name = "quantite", nullable = false)
    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    @Id
    @Column(name = "produit_id", nullable = false)
    public Integer getProduitId() {
        return produitId;
    }

    public void setProduitId(Integer produitId) {
        this.produitId = produitId;
    }


    @Id
    @Column(name = "magasin_id", nullable = false)
    public Integer getMagasinId() {
        return magasinId;
    }

    public void setMagasinId(Integer magasinId) {
        this.magasinId = magasinId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Stock stock = (Stock) o;

        if (quantite != null ? !quantite.equals(stock.quantite) : stock.quantite != null) return false;
        if (produitId != null ? !produitId.equals(stock.produitId) : stock.produitId != null) return false;
        if (magasinId != null ? !magasinId.equals(stock.magasinId) : stock.magasinId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = quantite != null ? quantite.hashCode() : 0;
        result = 31 * result + (produitId != null ? produitId.hashCode() : 0);
        result = 31 * result + (magasinId != null ? magasinId.hashCode() : 0);
        return result;
    }
}
