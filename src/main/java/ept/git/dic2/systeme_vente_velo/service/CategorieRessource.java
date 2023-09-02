package ept.git.dic2.systeme_vente_velo.service;

import ept.git.dic2.systeme_vente_velo.beans.CategorieBean;
import ept.git.dic2.systeme_vente_velo.model.Categorie;
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

@Path("categories")
public class CategorieRessource {
    @EJB
    private CategorieBean categorieFacade;

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Categorie> getListCategories() {
        return categorieFacade.findAll();
    }


    @GET
    @Path("{id}")
    public Response getCategorieById( @PathParam("id") int id) {
        Categorie categorie = categorieFacade.find(id);
        if (categorie == null) {
            Reponse response = new Reponse("Categorie introuvable.");
            return Response.status(Response.Status.NOT_FOUND).entity(response).build();
        }
        return Response.status(Response.Status.OK).entity(categorie).build();
    }
    

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Categorie addCategories(Categorie e) {
        // Generate the primary key (numero) by incrementing the counter
        int nextNumero = counter.getAndIncrement();
        e.setId(Integer.valueOf(nextNumero));

        categorieFacade.create(e);
        return e;
    }
    
    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response editCategorie(@PathParam("id") int id, Categorie updatedCategorie) {
        Categorie categorie = categorieFacade.find(id);
        if (categorie == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        // Update the properties of the existing categorie object if they are modified
        if (updatedCategorie.getNom() != null) {
            categorie.setNom(updatedCategorie.getNom());
        }

        categorieFacade.edit(categorie); // Assuming categorieFacade has an edit method to persist the changes

        return Response.ok().entity(categorie).build();
    }




    @DELETE
    @Path("{id}")
    public  Reponse delete(@PathParam("id") int id){
        Categorie categorie = categorieFacade.find(id);
        if (categorie == null){

            Response.status(Response.Status.NOT_FOUND).build();
        }
        categorieFacade.remove(categorie);
        Reponse reponse = new Reponse("La categorie "+categorie.getNom()+" est supprime avec succes ");
        return reponse;

    }

    private static final AtomicInteger counter = new AtomicInteger(1);
}
