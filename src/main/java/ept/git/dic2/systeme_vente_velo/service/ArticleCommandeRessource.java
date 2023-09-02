package ept.git.dic2.systeme_vente_velo.service;


import ept.git.dic2.systeme_vente_velo.beans.ArticleCommandeBean;
import ept.git.dic2.systeme_vente_velo.model.ArticleCommande;
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

@Path("articleCommandes")
public class ArticleCommandeRessource {
    @EJB
    private ArticleCommandeBean articleCommandeFacade;
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public List<ArticleCommande> getListArticleCommandes(){
        return  articleCommandeFacade.findAll();
    }


    @GET
    @Path("{ligne}")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Response findArticleCommandeById(@PathParam("ligne") int ligne){
        ArticleCommande articleCommande = articleCommandeFacade.find(ligne);
        if (articleCommande == null){
            Reponse reponse = new Reponse("La articleCommande dont le id est  "+articleCommande.getNumeroCommande()+"est introuvable");
            return Response.status(Response.Status.NOT_FOUND).entity(reponse).build();
        }
        return  Response.status(Response.Status.OK).entity(articleCommande).build();
    }


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public ArticleCommande addArticleCommandes(ArticleCommande e) {
        // Generate the primary key (numero) by incrementing the counter
        int nextNumero = counter.getAndIncrement();
        e.setNumeroCommande(Integer.valueOf(String.valueOf(nextNumero)));

        articleCommandeFacade.create(e);
        return e;
    }

    @PUT
    @Path("{numeroCommande}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response editArticleCommande(@PathParam("numeroCommande") String numeroCommande, ArticleCommande updatedArticleCommande) {
        ArticleCommande articleCommande = articleCommandeFacade.find(numeroCommande);
        if (articleCommande == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        // Update the properties of the existing articleCommande object if they are modified
        if (updatedArticleCommande.getLigne() != null) {
            articleCommande.setLigne(updatedArticleCommande.getLigne());
        }
        if (updatedArticleCommande.getProduitId() != null) {
            articleCommande.setProduitId(updatedArticleCommande.getProduitId());
        }
        if (updatedArticleCommande.getQuantite() != null) {
            articleCommande.setQuantite(updatedArticleCommande.getQuantite());
        }
        if (updatedArticleCommande.getPrixDepart() != null) {
            articleCommande.setPrixDepart(updatedArticleCommande.getPrixDepart());
        }
        if (updatedArticleCommande.getRemise() != null) {
            articleCommande.setRemise(updatedArticleCommande.getRemise());
        }

        articleCommandeFacade.edit(articleCommande); // Assuming articleCommandeFacade has an edit method to persist the changes

        return Response.ok().entity(articleCommande).build();
    }


    @DELETE
    @Path("{id}")
    public  Reponse delete(@PathParam("id") int id){
        ArticleCommande articleCommande = articleCommandeFacade.find(id);
        if (articleCommande == null){

            Response.status(Response.Status.NOT_FOUND).build();
        }
        articleCommandeFacade.remove(articleCommande);
        Reponse reponse = new Reponse("La articleCommande "+articleCommande.getNumeroCommande()+" est supprime avec succes ");
        return reponse;

    }

    private static final AtomicInteger counter = new AtomicInteger(1);
}
