package ept.git.dic2.systeme_vente_velo.model;

import jakarta.persistence.*;

@Entity
public class Client {
    private Integer id;
    private String prenom;
    private String nom;
    private String adresse;
    private String telephone;
    private String email;
    private String ville;
    private String etat;
    private String codeZip;

    public Client(String john, String doe, String s, String s1, String s2) {

    }

    public Client() {

    }

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
    @Column(name = "prenom", nullable = false, length = 255)
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Basic
    @Column(name = "nom", nullable = false, length = 255)
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Basic
    @Column(name = "adresse", nullable = true, length = 255)
    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
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
    @Column(name = "email", nullable = false, length = 255)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "ville", nullable = true, length = 50)
    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    @Basic
    @Column(name = "etat", nullable = true, length = 25)
    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    @Basic
    @Column(name = "code_zip", nullable = true, length = 5)
    public String getCodeZip() {
        return codeZip;
    }

    public void setCodeZip(String codeZip) {
        this.codeZip = codeZip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        if (id != null ? !id.equals(client.id) : client.id != null) return false;
        if (prenom != null ? !prenom.equals(client.prenom) : client.prenom != null) return false;
        if (nom != null ? !nom.equals(client.nom) : client.nom != null) return false;
        if (adresse != null ? !adresse.equals(client.adresse) : client.adresse != null) return false;
        if (telephone != null ? !telephone.equals(client.telephone) : client.telephone != null) return false;
        if (email != null ? !email.equals(client.email) : client.email != null) return false;
        if (ville != null ? !ville.equals(client.ville) : client.ville != null) return false;
        if (etat != null ? !etat.equals(client.etat) : client.etat != null) return false;
        if (codeZip != null ? !codeZip.equals(client.codeZip) : client.codeZip != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (prenom != null ? prenom.hashCode() : 0);
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + (adresse != null ? adresse.hashCode() : 0);
        result = 31 * result + (telephone != null ? telephone.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (ville != null ? ville.hashCode() : 0);
        result = 31 * result + (etat != null ? etat.hashCode() : 0);
        result = 31 * result + (codeZip != null ? codeZip.hashCode() : 0);
        return result;
    }
}
