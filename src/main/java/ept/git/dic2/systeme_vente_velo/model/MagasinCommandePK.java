package ept.git.dic2.systeme_vente_velo.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;

public class MagasinCommandePK implements Serializable {
    private Integer magasinId;
    private Integer commandesNumero;

    @Column(name = "magasin_id", nullable = false)
    @Id

    public Integer getMagasinId() {
        return magasinId;
    }

    public void setMagasinId(Integer magasinId) {
        this.magasinId = magasinId;
    }

    @Column(name = "commandes_numero", nullable = false)
    @Id

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

        MagasinCommandePK that = (MagasinCommandePK) o;

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
