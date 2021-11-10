package at.htl.recipes.entity;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@QuarkusTest
class UserTest {

    @Inject
    EntityManager em;

    @Test
    @Transactional
    void createUser() {
        em.persist(new User("Nico", "email@gmail.com", "nico"));
    }
}