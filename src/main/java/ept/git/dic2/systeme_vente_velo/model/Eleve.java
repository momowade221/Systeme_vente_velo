package ept.git.dic2.systeme_vente_velo.model;

import jakarta.persistence.*;

@Entity
public class Eleve {
    private String numero;
    private String prenom;
    private String nom;
    private Double poids;

    public Eleve(String numero, String prenom, String nom, double poids) {
    }

    public Eleve() {

    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "numero", nullable = false, length = 255)
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Basic
    @Column(name = "prenom", nullable = true, length = 255)
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Basic
    @Column(name = "nom", nullable = true, length = 2555)
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Basic
    @Column(name = "poids", nullable = true, precision = 0)
    public Double getPoids() {
        return poids;
    }

    public void setPoids(Double poids) {
        this.poids = poids;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Eleve eleve = (Eleve) o;

        if (numero != null ? !numero.equals(eleve.numero) : eleve.numero != null) return false;
        if (prenom != null ? !prenom.equals(eleve.prenom) : eleve.prenom != null) return false;
        if (nom != null ? !nom.equals(eleve.nom) : eleve.nom != null) return false;
        if (poids != null ? !poids.equals(eleve.poids) : eleve.poids != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numero != null ? numero.hashCode() : 0;
        result = 31 * result + (prenom != null ? prenom.hashCode() : 0);
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + (poids != null ? poids.hashCode() : 0);
        return result;
    }
}
