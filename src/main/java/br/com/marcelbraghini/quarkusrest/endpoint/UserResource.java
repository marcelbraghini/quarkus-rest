package br.com.marcelbraghini.quarkusrest.endpoint;

import br.com.marcelbraghini.quarkusrest.model.User;
import br.com.marcelbraghini.quarkusrest.service.UserService;
import org.bson.types.ObjectId;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.jboss.logging.Logger;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;

@Path("/v1/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {

    private static final Logger logger = Logger.getLogger(UserResource.class);

    @Inject
    public UserService userService;

    @GET
    public Response index() {
        return Response.ok(userService.getAll()).build();
    }

    @GET
    @Path("/{_id}")
    public Response read(@PathParam("_id") final String _id) {
        try {
            final User user = userService.findById(new ObjectId(_id));
            return Response.ok(user).build();
        } catch (final Exception e) {
            logger.errorf("Usuário não encontrado: [HTTP-404] ");
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    public Response create(@RequestBody @Valid final User user) {
        try {
            final User model = userService.save(user);
            return Response.created(URI.create(model.get_id().toHexString())).build();
        } catch (final Exception e) {
            logger.errorf("Houve um erro ao criar um novo usuário: [HTTP-400] ");
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @PUT
    @Path("/{_id}")
    public Response edit(@PathParam("_id") final String _id, @RequestBody @Valid final User user) {
        try {
            final User userEdited = userService.findById(new ObjectId(_id));
            userEdited.setLogin(user.getLogin());
            userEdited.setName(user.getName());
            userEdited.setBlog(user.getBlog());
            userEdited.setLocation(user.getLocation());
            userEdited.setBio(user.getBio());
            userService.update(userEdited);
            return Response.status(Response.Status.OK).build();
        } catch (final Exception e) {
            logger.errorf("Usuário não encontrado: [HTTP-404] ");
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("/{_id}")
    public Response delete(@PathParam("_id") final String _id) {
        try {
            userService.remove(_id);
            return Response.status(Response.Status.OK).build();
        } catch (Exception e) {
            logger.errorf("Usuário não encontrado: [HTTP-404] ");
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}