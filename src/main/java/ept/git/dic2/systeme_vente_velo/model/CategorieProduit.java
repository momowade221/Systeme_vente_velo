package ept.git.dic2.systeme_vente_velo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "categorie_produit", schema = "public", catalog = "vente_velos_db")
@IdClass(CategorieProduitPK.class)
public class CategorieProduit {
    private Integer categorieId;
    private Integer produitsId;


    @Id
    @Column(name = "categorie_id", nullable = false)
    public Integer getCategorieId() {
        return categorieId;
    }

    public void setCategorieId(Integer categorieId) {
        this.categorieId = categorieId;
    }


    @Id
    @Column(name = "produits_id", nullable = false)
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

        CategorieProduit that = (CategorieProduit) o;

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
