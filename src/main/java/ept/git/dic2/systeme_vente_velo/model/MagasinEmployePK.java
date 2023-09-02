package ept.git.dic2.systeme_vente_velo.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;

public class MagasinEmployePK implements Serializable {
    private Integer magasinId;
    private Long employesId;

    @Column(name = "magasin_id", nullable = false)
    @Id

    public Integer getMagasinId() {
        return magasinId;
    }

    public void setMagasinId(Integer magasinId) {
        this.magasinId = magasinId;
    }

    @Column(name = "employes_id", nullable = false)
    @Id

    public Long getEmployesId() {
        return employesId;
    }

    public void setEmployesId(Long employesId) {
        this.employesId = employesId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MagasinEmployePK that = (MagasinEmployePK) o;

        if (magasinId != null ? !magasinId.equals(that.magasinId) : that.magasinId != null) return false;
        if (employesId != null ? !employesId.equals(that.employesId) : that.employesId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = magasinId != null ? magasinId.hashCode() : 0;
        result = 31 * result + (employesId != null ? employesId.hashCode() : 0);
        return result;
    }
}
