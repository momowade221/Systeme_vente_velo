package ept.git.dic2.systeme_vente_velo.service;


import ept.git.dic2.systeme_vente_velo.beans.MagasinBean;
import ept.git.dic2.systeme_vente_velo.model.Magasin;
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

@Path("magasins")
public class MagasinRessource {
    @EJB
    private MagasinBean magasinFacade;
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public List<Magasin> getListMagasins(){
        return  magasinFacade.findAll();
    }


    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Response findMagasinById(@PathParam("id") int id){
        Magasin magasin = magasinFacade.find(id);
        if (magasin == null){
            Reponse reponse = new Reponse("La magasin dont le id est  "+magasin.getId()+"est introuvable");
            return Response.status(Response.Status.NOT_FOUND).entity(reponse).build();
        }
        return  Response.status(Response.Status.OK).entity(magasin).build();
    }


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Magasin addMagasins(Magasin e) {
        // Generate the primary key (numero) by incrementing the counter
        int nextNumero = counter.getAndIncrement();
        e.setId(Integer.valueOf(nextNumero));

        magasinFacade.create(e);
        return e;
    }


    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response editMagasin(@PathParam("id") int id, Magasin updatedMagasin) {
        Magasin magasin = magasinFacade.find(id);
        if (magasin == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        // Update the properties of the existing magasin object if they are modified
        if (updatedMagasin.getNom() != null) {
            magasin.setNom(updatedMagasin.getNom());
        }
        if (updatedMagasin.getTelephone() != null) {
            magasin.setTelephone(updatedMagasin.getTelephone());
        }
        if (updatedMagasin.getEmail() != null) {
            magasin.setEmail(updatedMagasin.getEmail());
        }
        if (updatedMagasin.getAdresse() != null) {
            magasin.setAdresse(updatedMagasin.getAdresse());
        }
        if (updatedMagasin.getVille() != null) {
            magasin.setVille(updatedMagasin.getVille());
        }
        if (updatedMagasin.getEtat() != null) {
            magasin.setEtat(updatedMagasin.getEtat());
        }
        if (updatedMagasin.getCodeZip() != null) {
            magasin.setCodeZip(updatedMagasin.getCodeZip());
        }

        magasinFacade.edit(magasin); // Assuming magasinFacade has an edit method to persist the changes

        return Response.ok().entity(magasin).build();
    }

    @DELETE
    @Path("{id}")
    public  Reponse delete(@PathParam("id") int id){
        Magasin magasin = magasinFacade.find(id);
        if (magasin == null){

            Response.status(Response.Status.NOT_FOUND).build();
        }
        magasinFacade.remove(magasin);
        Reponse reponse = new Reponse("La magasin "+magasin.getNom()+" est supprime avec succes ");
        return reponse;

    }

    private static final AtomicInteger counter = new AtomicInteger(1);
}
