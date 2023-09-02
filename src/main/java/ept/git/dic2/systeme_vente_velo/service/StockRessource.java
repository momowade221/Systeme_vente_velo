package ept.git.dic2.systeme_vente_velo.service;


import ept.git.dic2.systeme_vente_velo.beans.StockBean;
import ept.git.dic2.systeme_vente_velo.model.Stock;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.ejb.EJB;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;


@Path("stocks")
public class StockRessource {
    @EJB
    private StockBean stockFacade;

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Stock> getListStocks() {
        return stockFacade.findAll();
    }


    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response findStockById(@PathParam("id") int id) {
        Stock stock = stockFacade.find(id);
        if (stock == null) {
            Reponse reponse = new Reponse("La stock dont le id est  " + stock.getProduitId() + "est introuvable");
            return Response.status(Response.Status.NOT_FOUND).entity(reponse).build();
        }
        return Response.status(Response.Status.OK).entity(stock).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Stock addStocks(Stock e) {
        // Generate the primary key (numero) by incrementing the counter

        stockFacade.create(e);
        return e;
    }

    @PUT
    @Path("{produitId}/{magasinId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response editStock(@PathParam("produitId") int produitId, @PathParam("magasinId") int magasinId, Stock updatedStock) {
        Stock stock = stockFacade.find(produitId);
//        Stock stock = stockFacade.find(magasinId);
        if (stock == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        // Update the properties of the existing stock object if they are modified
        if (updatedStock.getQuantite() != null) {
            stock.setQuantite(updatedStock.getQuantite());
        }

        stockFacade.edit(stock); // Assuming stockFacade has an edit method to persist the changes

        return Response.ok().entity(stock).build();
    }

    @DELETE
    @Path("{id}")
    public Reponse delete(@PathParam("id") int id) {
        Stock stock = stockFacade.find(id);
        if (stock == null) {

            Response.status(Response.Status.NOT_FOUND).build();
        }
        stockFacade.remove(stock);
        Reponse reponse = new Reponse("La stock " + stock.getProduitId() + " est supprime avec succes ");
        return reponse;

    }

}
