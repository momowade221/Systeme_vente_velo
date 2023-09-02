package ept.git.dic2.systeme_vente_velo.service;


import ept.git.dic2.systeme_vente_velo.beans.ClientBean;
import ept.git.dic2.systeme_vente_velo.model.Client;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.ejb.EJB;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Path("clients")
public class ClientRessource {
    @EJB
    private ClientBean clientFacade;

    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public List<Client> getListClients(){
        return  clientFacade.findAll();
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Response findClientById(@PathParam("id") int id){
        Client client = clientFacade.find(id);
        if (client == null){
            Reponse reponse = new Reponse("La client dont le id est  "+client.getId()+"est introuvable");
            return Response.status(Response.Status.NOT_FOUND).entity(reponse).build();
        }
        return  Response.status(Response.Status.OK).entity(client).build();
    }


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Client addClients(Client e) {
        // Generate the primary key (numero) by incrementing the counter
        int nextNumero = counter.getAndIncrement();
        e.setId(Integer.valueOf(Integer.valueOf(nextNumero)));

        clientFacade.create(e);
        return e;
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response editClient(@PathParam("id") int id, Client updatedClient) {
        Client client = clientFacade.find(id);
        if (client == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        // Update the properties of the existing client object if they are modified
        if (updatedClient.getPrenom() != null) {
            client.setPrenom(updatedClient.getPrenom());
        }
        if (updatedClient.getNom() != null) {
            client.setNom(updatedClient.getNom());
        }
        if (updatedClient.getTelephone() != null) {
            client.setTelephone(updatedClient.getTelephone());
        }
        if (updatedClient.getEmail() != null) {
            client.setEmail(updatedClient.getEmail());
        }
        if (updatedClient.getAdresse() != null) {
            client.setAdresse(updatedClient.getAdresse());
        }
        if (updatedClient.getVille() != null) {
            client.setVille(updatedClient.getVille());
        }
        if (updatedClient.getEtat() != null) {
            client.setEtat(updatedClient.getEtat());
        }
        if (updatedClient.getCodeZip() != null) {
            client.setCodeZip(updatedClient.getCodeZip());
        }

        clientFacade.edit(client); // Assuming clientFacade has an edit method to persist the changes

        return Response.ok().entity(client).build();
    }


    @DELETE
    @Path("{id}")
    public  Reponse delete(@PathParam("id") int id){
        Client client = clientFacade.find(id);
        if (client == null){

            Response.status(Response.Status.NOT_FOUND).build();
        }
        clientFacade.remove(client);
        Reponse reponse = new Reponse("La client "+client.getNom()+" est supprime avec succes ");
        return reponse;

    }
    private static final AtomicInteger counter = new AtomicInteger(1);

}
