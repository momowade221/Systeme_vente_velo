package ept.git.dic2.systeme_vente_velo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "magasin_employe", schema = "public", catalog = "vente_velos_db")
@IdClass(MagasinEmployePK.class)
public class MagasinEmploye {
    private Integer magasinId;
    private Long employesId;


    @Id
    @Column(name = "magasin_id", nullable = false)
    public Integer getMagasinId() {
        return magasinId;
    }

    public void setMagasinId(Integer magasinId) {
        this.magasinId = magasinId;
    }


    @Id
    @Column(name = "employes_id", nullable = false)
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

        MagasinEmploye that = (MagasinEmploye) o;

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
