//package ept.git.dic2.systeme_vente_velo.service;
//
//import ept.git.dic2.systeme_vente_velo.beans.CategorieBean;
//import ept.git.dic2.systeme_vente_velo.model.Categorie;
//import jakarta.ejb.EJB;
//import jakarta.ws.rs.*;
//import jakarta.ws.rs.core.*;
//
//import java.net.URI;
//import java.util.*;
//
//@Path("/tests")
//@Produces(MediaType.APPLICATION_JSON)
//public class TestService {
//
//    static Map<String, Categorie> categories = new HashMap<>();
//
//    @EJB
//    private CategorieBean categorieFacade;
//
//    @GET
//    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
//    public List<Categorie> getListCategories() {
//        return categorieFacade.findAll();
//    }
//
//    @GET()
//    @Path("/{id}")
//    public Response getCategorie(@PathParam("id") int id) {
//        return Optional.ofNullable(categories.get(id))
//                .map(Response::ok)
//                .orElse(Response.status(Response.Status.NOT_FOUND))
//                .build();
//    }
//
//    @OPTIONS
//    public Response httpOptions() {
//        return Response.ok()
//                .header(HttpHeaders.ALLOW, "OPTIONS,HEAD,GET,POST,PUT,DELETE")
//                .build();
//    }
//
//    @POST
//    public Response create(Categorie categorie) {
//        categories.put(categorie.getNom(), categorie);
//        URI uri = UriBuilder.fromMethod(Categorie.class, "getCategorie")
//                .build(categorie.getNom())
//                .normalize();
//        return Response.created(uri).entity(categorie).build();
//    }
//
//    @DELETE
//    @Path("/{id}")
//    public Response delete(@PathParam("id") int id) {
//        return Optional.ofNullable(categories.remove(id))
//                .map(p -> Response.noContent())
//                .orElse(Response.status(Response.Status.NOT_FOUND))
//                .build();
//    }
//    @PUT
//    @Path("/{id}")
//    public Response put(@PathParam("id") int id, Categorie categorie) {
//        return Optional.ofNullable(categories.get(id)).map(ExistingCategorie -> {
//                    ExistingCategorie.setNom(categorie.getNom());
//
//                    URI uri = UriBuilder.fromMethod(CategorieRessource.class, "getCategorie")
//                            .build(ExistingCategorie.getNom())
//                            .normalize();
//                    return Response.created(uri).entity(categorie);
//                })
//                .orElse(Response.status(Response.Status.NOT_FOUND))
//                .build();
//    }
//
//}