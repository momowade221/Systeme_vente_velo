package ept.git.dic2.systeme_vente_velo.model;

import jakarta.persistence.*;

@Entity
public class Employe {
    private Integer id;
    private String prenom;
    private String nom;
    private String email;
    private String telephone;
    private Short actif;
    private Integer magasinId;
    private Integer managerId;

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
    @Column(name = "prenom", nullable = false, length = 50)
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Basic
    @Column(name = "nom", nullable = false, length = 50)
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Basic
    @Column(name = "email", nullable = false, length = 255)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "telephone", nullable = true, length = 25)
    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Basic
    @Column(name = "actif", nullable = false)
    public Short getActif() {
        return actif;
    }

    public void setActif(Short actif) {
        this.actif = actif;
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
    @Column(name = "manager_id", nullable = true)
    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employe employe = (Employe) o;

        if (id != null ? !id.equals(employe.id) : employe.id != null) return false;
        if (prenom != null ? !prenom.equals(employe.prenom) : employe.prenom != null) return false;
        if (nom != null ? !nom.equals(employe.nom) : employe.nom != null) return false;
        if (email != null ? !email.equals(employe.email) : employe.email != null) return false;
        if (telephone != null ? !telephone.equals(employe.telephone) : employe.telephone != null) return false;
        if (actif != null ? !actif.equals(employe.actif) : employe.actif != null) return false;
        if (magasinId != null ? !magasinId.equals(employe.magasinId) : employe.magasinId != null) return false;
        if (managerId != null ? !managerId.equals(employe.managerId) : employe.managerId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (prenom != null ? prenom.hashCode() : 0);
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (telephone != null ? telephone.hashCode() : 0);
        result = 31 * result + (actif != null ? actif.hashCode() : 0);
        result = 31 * result + (magasinId != null ? magasinId.hashCode() : 0);
        result = 31 * result + (managerId != null ? managerId.hashCode() : 0);
        return result;
    }
}
