package ept.git.dic2.systeme_vente_velo.service;


import ept.git.dic2.systeme_vente_velo.beans.CommandeBean;
import ept.git.dic2.systeme_vente_velo.model.Commande;
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

@Path("commandes")
public class CommandeRessource {
    @EJB
    private CommandeBean commandeFacade;

    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public List<Commande> getListCommandes(){
        return  commandeFacade.findAll();
    }


    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Response findCommandeById(@PathParam("id") int id){
        Commande commande = commandeFacade.find(id);
        if (commande == null){
            Reponse reponse = new Reponse("La commande dont le id est  "+commande.getNumero()+"est introuvable");
            return Response.status(Response.Status.NOT_FOUND).entity(reponse).build();
        }
        return  Response.status(Response.Status.OK).entity(commande).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Commande addCommandes(Commande e) {
        // Generate the primary key (numero) by incrementing the counter
        int nextNumero = counter.getAndIncrement();
        e.setNumero(Integer.valueOf(String.valueOf(nextNumero)));

        commandeFacade.create(e);
        return e;
    }

    @PUT
    @Path("{numero}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response editCommande(@PathParam("numero") String numero, Commande updatedCommande) {
        Commande commande = commandeFacade.find(numero);
        if (commande == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        // Update the properties of the existing commande object if they are modified
        if (updatedCommande.getClientId() != null) {
            commande.setClientId(updatedCommande.getClientId());
        }
        if (updatedCommande.getStatut() != null) {
            commande.setStatut(updatedCommande.getStatut());
        }
        if (updatedCommande.getDateCommande() != null) {
            commande.setDateCommande(updatedCommande.getDateCommande());
        }
        if (updatedCommande.getDateLivraisonVoulue() != null) {
            commande.setDateLivraisonVoulue(updatedCommande.getDateLivraisonVoulue());
        }
        if (updatedCommande.getDateLivraison() != null) {
            commande.setDateLivraison(updatedCommande.getDateLivraison());
        }
        if (updatedCommande.getVendeurId() != null) {
            commande.setVendeurId(updatedCommande.getVendeurId());
        }
        if (updatedCommande.getMagasinId() != null) {
            commande.setMagasinId(updatedCommande.getMagasinId());
        }

        commandeFacade.edit(commande); // Assuming commandeFacade has an edit method to persist the changes

        return Response.ok().entity(commande).build();
    }

    @DELETE
    @Path("{id}")
    public  Reponse delete(@PathParam("id") int id){
        Commande commande = commandeFacade.find(id);
        if (commande == null){

            Response.status(Response.Status.NOT_FOUND).build();
        }
        commandeFacade.remove(commande);
        Reponse reponse = new Reponse("La commande "+commande.getNumero()+" est supprime avec succes ");
        return reponse;

    }

    private static final AtomicInteger counter = new AtomicInteger(1);
}
