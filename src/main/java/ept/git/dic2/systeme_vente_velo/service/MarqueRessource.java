package ept.git.dic2.systeme_vente_velo.service;


import ept.git.dic2.systeme_vente_velo.beans.MarqueBean;
import ept.git.dic2.systeme_vente_velo.model.Marque;
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

@Path("marques")
public class MarqueRessource {
    @EJB
    private MarqueBean marqueFacade;

    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public List<Marque> getListMarques(){
        return  marqueFacade.findAll();
    }


    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Response findMarqueById(@PathParam("id") int id){
        Marque marque = marqueFacade.find(id);
        if (marque == null){
            Reponse reponse = new Reponse("La marque dont le id est  "+marque.getId()+"est introuvable");
            return Response.status(Response.Status.NOT_FOUND).entity(reponse).build();
        }
        return  Response.status(Response.Status.OK).entity(marque).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Marque addMarques(Marque e) {
        // Generate the primary key (numero) by incrementing the counter
        int nextNumero = counter.getAndIncrement();
        e.setId(Integer.valueOf(String.valueOf(nextNumero)));

        marqueFacade.create(e);
        return e;
    }


    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response editMarque(@PathParam("id") int id, Marque updatedMarque) {
        Marque marque = marqueFacade.find(id);
        if (marque == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        // Update the properties of the existing marque object if they are modified
        if (updatedMarque.getNom() != null) {
            marque.setNom(updatedMarque.getNom());
        }

        marqueFacade.edit(marque); // Assuming marqueFacade has an edit method to persist the changes

        return Response.ok().entity(marque).build();
    }


    @DELETE
    @Path("{id}")
    public  Reponse delete(@PathParam("id") int id){
        Marque marque = marqueFacade.find(id);
        if (marque == null){

            Response.status(Response.Status.NOT_FOUND).build();
        }
        marqueFacade.remove(marque);
        Reponse reponse = new Reponse("La marque "+marque.getNom()+" est supprime avec succes ");
        return reponse;

    }

    private static final AtomicInteger counter = new AtomicInteger(1);
}
