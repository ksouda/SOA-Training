package WebServices;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.GET;
import javax.ws.rs.core.MediaType;
@Path("/hello")
public class HelloWS {
    //ws 1: Return a hello msg
    @Path("/hi")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response sayHi(){
        return Response
                .status(200)
                .entity("hello")
                .build();
    }
}