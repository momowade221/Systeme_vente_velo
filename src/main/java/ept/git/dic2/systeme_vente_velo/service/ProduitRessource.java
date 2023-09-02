package ept.git.dic2.systeme_vente_velo.service;


import ept.git.dic2.systeme_vente_velo.beans.ProduitBean;
import ept.git.dic2.systeme_vente_velo.model.Produit;
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

@Path("produits")
public class ProduitRessource {
    @EJB
    private ProduitBean produitFacade;
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public List<Produit> getListProduits(){
        return  produitFacade.findAll();
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Response findProduitById(@PathParam("id") int id){
        Produit produit = produitFacade.find(id);
        if (produit == null){
            Reponse reponse = new Reponse("La produit dont le id est  "+produit.getId()+"est introuvable");
            return Response.status(Response.Status.NOT_FOUND).entity(reponse).build();
        }
        return  Response.status(Response.Status.OK).entity(produit).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Produit addProduits(Produit e) {
        // Generate the primary key (numero) by incrementing the counter
        int nextNumero = counter.getAndIncrement();
        e.setId(Integer.valueOf(String.valueOf(nextNumero)));

        produitFacade.create(e);
        return e;
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response editProduit(@PathParam("id") int id, Produit updatedProduit) {
        Produit produit = produitFacade.find(id);
        if (produit == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        // Update the properties of the existing produit object if they are modified
        if (updatedProduit.getNom() != null) {
            produit.setNom(updatedProduit.getNom());
        }
        if (updatedProduit.getAnneeModel() != null) {
            produit.setAnneeModel(updatedProduit.getAnneeModel());
        }

        if (updatedProduit.getMarqueId() != null) {
            produit.setMarqueId(updatedProduit.getMarqueId());
        }
        if (updatedProduit.getCategorieId() != null) {
            produit.setCategorieId(updatedProduit.getCategorieId());
        }

        produitFacade.edit(produit); // Assuming produitFacade has an edit method to persist the changes

        return Response.ok().entity(produit).build();
    }

    @DELETE
    @Path("{id}")
    public  Reponse delete(@PathParam("id") int id){
        Produit produit = produitFacade.find(id);
        if (produit == null){

            Response.status(Response.Status.NOT_FOUND).build();
        }
        produitFacade.remove(produit);
        Reponse reponse = new Reponse("La produit "+produit.getNom()+" est supprime avec succes ");
        return reponse;

    }

    private static final AtomicInteger counter = new AtomicInteger(1);
}
