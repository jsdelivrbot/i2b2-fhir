import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path( "/test" )
public class Login {

   @GET
   //@Produces(MediaType.TEXT_HTML)
   public Response login()  {
      return Response.ok( "logged in.." ).build();
   }

}
