package ept.git.dic2.systeme_vente_velo.model;

import jakarta.persistence.*;

@Entity
public class Produit {
    private Integer id;
    private Integer anneeModel;
    private String nom;
    private Double prixDepart;
    private Integer categorieId;
    private Integer marqueId;

    public Produit(String john, String s, long l, long l1, int i, double v) {
    }

    public Produit() {

    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "annee_model", nullable = false)
    public Integer getAnneeModel() {
        return anneeModel;
    }

    public void setAnneeModel(Integer anneeModel) {
        this.anneeModel = anneeModel;
    }

    @Basic
    @Column(name = "nom", nullable = false, length = 255)
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Basic
    @Column(name = "prix_depart", nullable = false, precision = 0)
    public Double getPrixDepart() {
        return prixDepart;
    }

    public void setPrixDepart(Double prixDepart) {
        this.prixDepart = prixDepart;
    }

    @Basic
    @Column(name = "categorie_id", nullable = false)
    public Integer getCategorieId() {
        return categorieId;
    }

    public void setCategorieId(Integer categorieId) {
        this.categorieId = categorieId;
    }

    @Basic
    @Column(name = "marque_id", nullable = false)
    public Integer getMarqueId() {
        return marqueId;
    }

    public void setMarqueId(Integer marqueId) {
        this.marqueId = marqueId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Produit produit = (Produit) o;

        if (id != null ? !id.equals(produit.id) : produit.id != null) return false;
        if (anneeModel != null ? !anneeModel.equals(produit.anneeModel) : produit.anneeModel != null) return false;
        if (nom != null ? !nom.equals(produit.nom) : produit.nom != null) return false;
        if (prixDepart != null ? !prixDepart.equals(produit.prixDepart) : produit.prixDepart != null) return false;
        if (categorieId != null ? !categorieId.equals(produit.categorieId) : produit.categorieId != null) return false;
        if (marqueId != null ? !marqueId.equals(produit.marqueId) : produit.marqueId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (anneeModel != null ? anneeModel.hashCode() : 0);
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + (prixDepart != null ? prixDepart.hashCode() : 0);
        result = 31 * result + (categorieId != null ? categorieId.hashCode() : 0);
        result = 31 * result + (marqueId != null ? marqueId.hashCode() : 0);
        return result;
    }
}
