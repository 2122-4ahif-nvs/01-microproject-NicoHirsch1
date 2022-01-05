package at.htl.recipes.control;

import at.htl.recipes.entity.User;
import io.quarkus.test.junit.QuarkusTest;
import org.jboss.logging.Logger;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import javax.inject.Inject;
import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@QuarkusTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserRepositoryTest {

    @Inject
    Logger LOG;

    @Inject
    UserRepository userRepository;

    @Order(1)
    @Test
    @Transactional
    void saveUser() {
        var user = userRepository.getEntityManager().merge(new User("TestUser2", "testUser2@gmail.com", "testUser2"));
        LOG.info(user);
        assertThat(user.id).isNotNull();
    }

}