package ept.git.dic2.systeme_vente_velo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "client_commande", schema = "public", catalog = "vente_velos_db")
@IdClass(ClientCommandePK.class)
public class ClientCommande {
    private Long clientId;
    private Integer commandesNumero;


    @Id
    @Column(name = "client_id", nullable = false)
    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
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

        ClientCommande that = (ClientCommande) o;

        if (clientId != null ? !clientId.equals(that.clientId) : that.clientId != null) return false;
        if (commandesNumero != null ? !commandesNumero.equals(that.commandesNumero) : that.commandesNumero != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = clientId != null ? clientId.hashCode() : 0;
        result = 31 * result + (commandesNumero != null ? commandesNumero.hashCode() : 0);
        return result;
    }
}
