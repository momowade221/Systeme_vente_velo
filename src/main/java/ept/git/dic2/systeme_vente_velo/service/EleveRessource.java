package ept.git.dic2.systeme_vente_velo.service;


import ept.git.dic2.systeme_vente_velo.beans.EleveBean;
import ept.git.dic2.systeme_vente_velo.model.Eleve;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.ejb.EJB;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.concurrent.atomic.AtomicInteger;

import java.util.List;



@Path("eleves")
public class EleveRessource {
    @EJB
    private EleveBean eleveFacade;
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public List<Eleve> getListEleves(){
        return  eleveFacade.findAll();
    }


    @GET
    @Path("{numero}")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Operation(
            summary="Rechercher un eleve",
            description = "Permet de rechercher un eleve",
            responses = {
                    @ApiResponse(
                            responseCode = "404",
                            description = "L'eleve correspondant au numéro indiqué est introuvable",
                            content = {
                                    @Content(
                                          mediaType = MediaType.APPLICATION_JSON,
                                          examples={@ExampleObject(name="Eleve introuvable")}

                                    )
                            }
                    ),

                    @ApiResponse(responseCode = "200", description = "L'eleve correspondant au numéro indiqué est bien présent")
            }
    )
    public Response findEleveByNumero(@PathParam("numero") String numero){
        Eleve eleve = eleveFacade.find(numero);
        if (eleve == null){
            Reponse reponse = new Reponse("L' eleve dont le numero est  "+eleve.getNumero()+"est introuvable");
            return Response.status(Response.Status.NOT_FOUND).entity(reponse).build();
        }
        return  Response.status(Response.Status.OK).entity(eleve).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Eleve addEleves(Eleve e) {
        // Generate the primary key (numero) by incrementing the counter
        int nextNumero = counter.getAndIncrement();
        e.setNumero(String.valueOf(nextNumero));

        eleveFacade.create(e);
        return e;
    }

    @PUT
    @Path("{numero}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("numero") String numero, Eleve updatedEleve) {
        Eleve eleve = eleveFacade.find(numero);
        if (eleve == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        // Update the properties of the existing eleve object
        if (updatedEleve.getPrenom() != null) {
            eleve.setPrenom(updatedEleve.getPrenom());
        }
        if (updatedEleve.getNom() != null) {
            eleve.setNom(updatedEleve.getNom());
        }
        if (updatedEleve.getPoids() != null) {
            eleve.setPoids(updatedEleve.getPoids());
        }

        eleveFacade.edit(eleve); // Assuming eleveFacade has an update method to persist the changes

        return Response.ok().entity(eleve).build();
    }


    @DELETE
    @Path("{numero}")
    public Reponse delete(@PathParam("numero") String numero){
        Eleve eleve = eleveFacade.find(numero);
        if (eleve == null){

            Response.status(Response.Status.NOT_FOUND).build();
        }
        eleveFacade.remove(eleve);
        Reponse reponse = new Reponse("L' eleve "+eleve.getPrenom()+" "+eleve.getNom()+" "+ "est supprime avec succes ");
        return reponse;

    }


    private static final AtomicInteger counter = new AtomicInteger(1);
}

