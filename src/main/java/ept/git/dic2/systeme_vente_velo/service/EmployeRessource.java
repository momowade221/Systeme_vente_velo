package ept.git.dic2.systeme_vente_velo.service;


import ept.git.dic2.systeme_vente_velo.beans.EmployeBean;
import ept.git.dic2.systeme_vente_velo.model.Employe;
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

@Path("employes")
public class EmployeRessource {
    @EJB
    private EmployeBean employeFacade;
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public List<Employe> getListEmployes(){
        return  employeFacade.findAll();
    }


    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Response findEmployeById(@PathParam("id") int id){
        Employe employe = employeFacade.find(id);
        if (employe == null){
            Reponse reponse = new Reponse("La employe dont le id est  "+employe.getId()+"est introuvable");
            return Response.status(Response.Status.NOT_FOUND).entity(reponse).build();
        }
        return  Response.status(Response.Status.OK).entity(employe).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Employe addEmployes(Employe e) {
        // Generate the primary key (numero) by incrementing the counter
        int nextNumero = counter.getAndIncrement();
        e.setId(Integer.valueOf(String.valueOf(nextNumero)));

        employeFacade.create(e);
        return e;
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response editEmploye(@PathParam("id") int id, Employe updatedEmploye) {
        Employe employe = employeFacade.find(id);
        if (employe == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        // Update the properties of the existing employe object if they are modified
        if (updatedEmploye.getPrenom() != null) {
            employe.setPrenom(updatedEmploye.getPrenom());
        }
        if (updatedEmploye.getNom() != null) {
            employe.setNom(updatedEmploye.getNom());
        }
        if (updatedEmploye.getTelephone() != null) {
            employe.setTelephone(updatedEmploye.getTelephone());
        }
        if (updatedEmploye.getEmail() != null) {
            employe.setEmail(updatedEmploye.getEmail());
        }

        if (updatedEmploye.getActif() != null) {
            employe.setActif(updatedEmploye.getActif());
        }
        if (updatedEmploye.getMagasinId() != null) {
            employe.setMagasinId(updatedEmploye.getMagasinId());
        }
        if (updatedEmploye.getManagerId() != null) {
            employe.setManagerId(updatedEmploye.getManagerId());
        }

        employeFacade.edit(employe); // Assuming employeFacade has an edit method to persist the changes

        return Response.ok().entity(employe).build();
    }
    

    @DELETE
    @Path("{id}")
    public  Reponse delete(@PathParam("id") int id){
        Employe employe = employeFacade.find(id);
        if (employe == null){

            Response.status(Response.Status.NOT_FOUND).build();
        }
        employeFacade.remove(employe);
        Reponse reponse = new Reponse("La employe "+employe.getPrenom()+" "+employe.getNom()+" est supprime avec succes ");
        return reponse;

    }

    private static final AtomicInteger counter = new AtomicInteger(1);
}
