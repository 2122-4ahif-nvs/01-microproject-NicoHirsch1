package at.htl.recipes.control;

import at.htl.recipes.entity.User;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.TypedQuery;
import java.util.List;

@ApplicationScoped
public class UserRepository implements PanacheRepository<User> {

    public List<User> getAllUsers() {
        TypedQuery<User> query = getEntityManager().createQuery("select u from User u", User.class);
        return query.getResultList();
    }

}
