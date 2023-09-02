package ept.git.dic2.systeme_vente_velo.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "article_commande", schema = "public", catalog = "vente_velos_db")
@IdClass(ArticleCommandePK.class)
public class ArticleCommande {
    private Integer numeroCommande;
    private Integer ligne;
    private Integer produitId;
    private Integer quantite;
    private BigDecimal prixDepart;
    private BigDecimal remise;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "numero_commande", nullable = false)
    public Integer getNumeroCommande() {
        return numeroCommande;
    }

    public void setNumeroCommande(Integer numeroCommande) {
        this.numeroCommande = numeroCommande;
    }

    @Id
    @Column(name = "ligne", nullable = false)
    public Integer getLigne() {
        return ligne;
    }

    public void setLigne(Integer ligne) {
        this.ligne = ligne;
    }

    @Basic
    @Column(name = "produit_id", nullable = false)
    public Integer getProduitId() {
        return produitId;
    }

    public void setProduitId(Integer produitId) {
        this.produitId = produitId;
    }

    @Basic
    @Column(name = "quantite", nullable = false)
    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    @Basic
    @Column(name = "prix_depart", nullable = false, precision = 2)
    public BigDecimal getPrixDepart() {
        return prixDepart;
    }

    public void setPrixDepart(BigDecimal prixDepart) {
        this.prixDepart = prixDepart;
    }

    @Basic
    @Column(name = "remise", nullable = false, precision = 2)
    public BigDecimal getRemise() {
        return remise;
    }

    public void setRemise(BigDecimal remise) {
        this.remise = remise;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ArticleCommande that = (ArticleCommande) o;

        if (numeroCommande != null ? !numeroCommande.equals(that.numeroCommande) : that.numeroCommande != null)
            return false;
        if (ligne != null ? !ligne.equals(that.ligne) : that.ligne != null) return false;
        if (produitId != null ? !produitId.equals(that.produitId) : that.produitId != null) return false;
        if (quantite != null ? !quantite.equals(that.quantite) : that.quantite != null) return false;
        if (prixDepart != null ? !prixDepart.equals(that.prixDepart) : that.prixDepart != null) return false;
        if (remise != null ? !remise.equals(that.remise) : that.remise != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numeroCommande != null ? numeroCommande.hashCode() : 0;
        result = 31 * result + (ligne != null ? ligne.hashCode() : 0);
        result = 31 * result + (produitId != null ? produitId.hashCode() : 0);
        result = 31 * result + (quantite != null ? quantite.hashCode() : 0);
        result = 31 * result + (prixDepart != null ? prixDepart.hashCode() : 0);
        result = 31 * result + (remise != null ? remise.hashCode() : 0);
        return result;
    }
}
