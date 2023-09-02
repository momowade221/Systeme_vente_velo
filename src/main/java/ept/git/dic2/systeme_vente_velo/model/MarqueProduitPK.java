package ept.git.dic2.systeme_vente_velo.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;

public class MarqueProduitPK implements Serializable {
    private Integer marqueId;
    private Integer produitId;

    @Column(name = "marque_id", nullable = false)
    @Id
    public Integer getMarqueId() {
        return marqueId;
    }

    public void setMarqueId(Integer marqueId) {
        this.marqueId = marqueId;
    }

    @Column(name = "produit_id", nullable = false)
    @Id

    public Integer getProduitId() {
        return produitId;
    }

    public void setProduitId(Integer produitId) {
        this.produitId = produitId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MarqueProduitPK that = (MarqueProduitPK) o;

        if (marqueId != null ? !marqueId.equals(that.marqueId) : that.marqueId != null) return false;
        if (produitId != null ? !produitId.equals(that.produitId) : that.produitId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = marqueId != null ? marqueId.hashCode() : 0;
        result = 31 * result + (produitId != null ? produitId.hashCode() : 0);
        return result;
    }
}
