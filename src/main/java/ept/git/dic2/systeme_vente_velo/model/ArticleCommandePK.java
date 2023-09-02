package ept.git.dic2.systeme_vente_velo.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;

public class ArticleCommandePK implements Serializable {
    private Integer numeroCommande;
    private Integer ligne;

    @Column(name = "numero_commande", nullable = false)
    @Id

    public Integer getNumeroCommande() {
        return numeroCommande;
    }

    public void setNumeroCommande(Integer numeroCommande) {
        this.numeroCommande = numeroCommande;
    }

    @Column(name = "ligne", nullable = false)
    @Id

    public Integer getLigne() {
        return ligne;
    }

    public void setLigne(Integer ligne) {
        this.ligne = ligne;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ArticleCommandePK that = (ArticleCommandePK) o;

        if (numeroCommande != null ? !numeroCommande.equals(that.numeroCommande) : that.numeroCommande != null)
            return false;
        if (ligne != null ? !ligne.equals(that.ligne) : that.ligne != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numeroCommande != null ? numeroCommande.hashCode() : 0;
        result = 31 * result + (ligne != null ? ligne.hashCode() : 0);
        return result;
    }
}
