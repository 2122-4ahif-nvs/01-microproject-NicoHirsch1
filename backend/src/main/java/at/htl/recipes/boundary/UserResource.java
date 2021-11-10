package at.htl.recipes.boundary;

import at.htl.recipes.entity.User;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("user")
public class UserResource {

    @Inject
    EntityManager em;

    @GET
    @Path("/get/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getAllUsers() {
        TypedQuery<User> query = em.createQuery("select u from User u", User.class);
        List<User> users = query.getResultList();
        return users;
    }
}
