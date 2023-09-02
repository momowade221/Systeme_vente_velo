package ept.git.dic2.systeme_vente_velo.model;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class Commande {
    private Integer numero;
    private Integer clientId;
    private Short statut;
    private Date dateCommande;
    private Date dateLivraisonVoulue;
    private Date dateLivraison;
    private Integer magasinId;
    private Integer vendeurId;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "numero", nullable = false)
    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    @Basic
    @Column(name = "client_id", nullable = true)
    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    @Basic
    @Column(name = "statut", nullable = false)
    public Short getStatut() {
        return statut;
    }

    public void setStatut(Short statut) {
        this.statut = statut;
    }

    @Basic
    @Column(name = "date_commande", nullable = false)
    public Date getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }

    @Basic
    @Column(name = "date_livraison_voulue", nullable = true)
    public Date getDateLivraisonVoulue() {
        return dateLivraisonVoulue;
    }

    public void setDateLivraisonVoulue(Date dateLivraisonVoulue) {
        this.dateLivraisonVoulue = dateLivraisonVoulue;
    }

    @Basic
    @Column(name = "date_livraison", nullable = true)
    public Date getDateLivraison() {
        return dateLivraison;
    }

    public void setDateLivraison(Date dateLivraison) {
        this.dateLivraison = dateLivraison;
    }

    @Basic
    @Column(name = "magasin_id", nullable = false)
    public Integer getMagasinId() {
        return magasinId;
    }

    public void setMagasinId(Integer magasinId) {
        this.magasinId = magasinId;
    }

    @Basic
    @Column(name = "vendeur_id", nullable = false)
    public Integer getVendeurId() {
        return vendeurId;
    }

    public void setVendeurId(Integer vendeurId) {
        this.vendeurId = vendeurId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Commande commande = (Commande) o;

        if (numero != null ? !numero.equals(commande.numero) : commande.numero != null) return false;
        if (clientId != null ? !clientId.equals(commande.clientId) : commande.clientId != null) return false;
        if (statut != null ? !statut.equals(commande.statut) : commande.statut != null) return false;
        if (dateCommande != null ? !dateCommande.equals(commande.dateCommande) : commande.dateCommande != null)
            return false;
        if (dateLivraisonVoulue != null ? !dateLivraisonVoulue.equals(commande.dateLivraisonVoulue) : commande.dateLivraisonVoulue != null)
            return false;
        if (dateLivraison != null ? !dateLivraison.equals(commande.dateLivraison) : commande.dateLivraison != null)
            return false;
        if (magasinId != null ? !magasinId.equals(commande.magasinId) : commande.magasinId != null) return false;
        if (vendeurId != null ? !vendeurId.equals(commande.vendeurId) : commande.vendeurId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numero != null ? numero.hashCode() : 0;
        result = 31 * result + (clientId != null ? clientId.hashCode() : 0);
        result = 31 * result + (statut != null ? statut.hashCode() : 0);
        result = 31 * result + (dateCommande != null ? dateCommande.hashCode() : 0);
        result = 31 * result + (dateLivraisonVoulue != null ? dateLivraisonVoulue.hashCode() : 0);
        result = 31 * result + (dateLivraison != null ? dateLivraison.hashCode() : 0);
        result = 31 * result + (magasinId != null ? magasinId.hashCode() : 0);
        result = 31 * result + (vendeurId != null ? vendeurId.hashCode() : 0);
        return result;
    }
}
