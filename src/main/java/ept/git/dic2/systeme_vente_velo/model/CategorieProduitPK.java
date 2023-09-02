package ept.git.dic2.systeme_vente_velo.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;

public class CategorieProduitPK implements Serializable {
    private Integer categorieId;
    private Integer produitsId;

    @Column(name = "categorie_id", nullable = false)
    @Id

    public Integer getCategorieId() {
        return categorieId;
    }

    public void setCategorieId(Integer categorieId) {
        this.categorieId = categorieId;
    }

    @Column(name = "produits_id", nullable = false)
    @Id

    public Integer getProduitsId() {
        return produitsId;
    }

    public void setProduitsId(Integer produitsId) {
        this.produitsId = produitsId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CategorieProduitPK that = (CategorieProduitPK) o;

        if (categorieId != null ? !categorieId.equals(that.categorieId) : that.categorieId != null) return false;
        if (produitsId != null ? !produitsId.equals(that.produitsId) : that.produitsId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = categorieId != null ? categorieId.hashCode() : 0;
        result = 31 * result + (produitsId != null ? produitsId.hashCode() : 0);
        return result;
    }
}
