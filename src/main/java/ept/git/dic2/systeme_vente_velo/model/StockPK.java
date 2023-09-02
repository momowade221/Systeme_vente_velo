package ept.git.dic2.systeme_vente_velo.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;

public class StockPK implements Serializable {
    private Integer produitId;
    private Integer magasinId;

    @Column(name = "produit_id", nullable = false)
    @Id
    public Integer getProduitId() {
        return produitId;
    }

    public void setProduitId(Integer produitId) {
        this.produitId = produitId;
    }

    @Column(name = "magasin_id", nullable = false)
    @Id

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

        StockPK stockPK = (StockPK) o;

        if (produitId != null ? !produitId.equals(stockPK.produitId) : stockPK.produitId != null) return false;
        if (magasinId != null ? !magasinId.equals(stockPK.magasinId) : stockPK.magasinId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = produitId != null ? produitId.hashCode() : 0;
        result = 31 * result + (magasinId != null ? magasinId.hashCode() : 0);
        return result;
    }
}
