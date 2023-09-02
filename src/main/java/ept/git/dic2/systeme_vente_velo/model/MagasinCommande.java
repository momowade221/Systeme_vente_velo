package ept.git.dic2.systeme_vente_velo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "magasin_commande", schema = "public", catalog = "vente_velos_db")
@IdClass(MagasinCommandePK.class)
public class MagasinCommande {
    private Integer magasinId;
    private Integer commandesNumero;


    @Id
    @Column(name = "magasin_id", nullable = false)
    public Integer getMagasinId() {
        return magasinId;
    }

    public void setMagasinId(Integer magasinId) {
        this.magasinId = magasinId;
    }


    @Id
    @Column(name = "commandes_numero", nullable = false)
    public Integer getCommandesNumero() {
        return commandesNumero;
    }

    public void setCommandesNumero(Integer commandesNumero) {
        this.commandesNumero = commandesNumero;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MagasinCommande that = (MagasinCommande) o;

        if (magasinId != null ? !magasinId.equals(that.magasinId) : that.magasinId != null) return false;
        if (commandesNumero != null ? !commandesNumero.equals(that.commandesNumero) : that.commandesNumero != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = magasinId != null ? magasinId.hashCode() : 0;
        result = 31 * result + (commandesNumero != null ? commandesNumero.hashCode() : 0);
        return result;
    }
}
