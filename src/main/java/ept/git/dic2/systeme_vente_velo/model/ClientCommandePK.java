package ept.git.dic2.systeme_vente_velo.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;

public class ClientCommandePK implements Serializable {
    private Long clientId;
    private Integer commandesNumero;

    @Column(name = "client_id", nullable = false)
    @Id
    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
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

        ClientCommandePK that = (ClientCommandePK) o;

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
