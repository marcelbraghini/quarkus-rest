package br.com.marcelbraghini.quarkusrest.endpoint;

import br.com.marcelbraghini.quarkusrest.model.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {

    private Set<User> users = Collections.synchronizedSet(new LinkedHashSet<>());

    public UserResource() {
        users.add(new User("marcelbraghini",
                "Marcel Braghini",
                "https://www.linkedin.com/in/marcel-braghini-8b5210b6/",
                "Chapecó-SC-Brasil",
                "Desenvolvedor"));
    }

    @GET
    public Response index() {
        return Response.ok(users).build();
    }

}