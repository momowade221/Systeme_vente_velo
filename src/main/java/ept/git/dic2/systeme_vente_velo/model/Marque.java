package ept.git.dic2.systeme_vente_velo.model;

import jakarta.persistence.*;

@Entity
public class Marque {
    private Integer id;
    private String nom;

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
    @Column(name = "nom", nullable = true, length = 255)
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Marque marque = (Marque) o;

        if (id != null ? !id.equals(marque.id) : marque.id != null) return false;
        if (nom != null ? !nom.equals(marque.nom) : marque.nom != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        return result;
    }
}
