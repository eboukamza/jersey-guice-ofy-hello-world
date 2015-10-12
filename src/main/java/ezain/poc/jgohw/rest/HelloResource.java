package ezain.poc.jgohw.rest;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.google.inject.Inject;
import ezain.poc.jgohw.dao.HelloDao;
import ezain.poc.jgohw.domain.Hello;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

@Path("/hello")
public class HelloResource {

    private final HelloDao helloDAO;

    private final UserService userService = UserServiceFactory.getUserService();

    @Inject
    public HelloResource(HelloDao helloDAO) {
        this.helloDAO = helloDAO;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Hello> fetch() {
        return helloDAO.getEntities();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Hello getById(@PathParam("id") final Long id) {
        return helloDAO.getEntityById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response saveItem(Hello hello) {
        hello.setUser(userService.getCurrentUser());
        helloDAO.insertEntity(hello);
        return Response.created(URI.create(hello.getId().toString())).entity(hello).build();
    }
}
