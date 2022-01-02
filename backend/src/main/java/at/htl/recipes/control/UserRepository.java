package at.htl.recipes.control;

import at.htl.recipes.entity.User;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@ApplicationScoped
public class UserRepository {

    @Inject
    EntityManager em;

    @Transactional
    public User save(User user) {
        return em.merge(user);
    }

}
