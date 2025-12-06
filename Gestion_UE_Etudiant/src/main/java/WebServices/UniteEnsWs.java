package WebServices;

import entities.UniteEnseignement;
import metiers.UniteEnseignementBusiness;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/ue")
public class UniteEnsWs {
    static UniteEnseignementBusiness helper=new UniteEnseignementBusiness();
    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(){
        return Response
                .status(200)
                .entity(helper.getListeUE())
                .build();
    }
    @Path("/add")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response addUE(UniteEnseignement ue){
        if (helper.addUniteEnseignement(ue)){
            return Response.status(201).entity("Object added").build();
        }
        else return Response.status(400).entity("Object not added").build();
    }
    @Path("/delete/{id}")
    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    public Response deleteUE(@PathParam("id") int code){
        if (helper.deleteUniteEnseignement(code)){
            return Response.status(200).entity("Object deleted").build();
        }
        else return Response.status(400).entity("Object not deleted").build();
    }
    @Path("/update/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response updateUE(@PathParam("id") int code, UniteEnseignement ue){
        if (helper.updateUniteEnseignement(code,ue)){
            return Response.status(200).entity("Object updated").build();
        }
        else return Response.status(400).entity("Object not updated").build();
    }
}