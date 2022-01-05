package at.htl.recipes.control;

import at.htl.recipes.entity.User;
import io.quarkus.test.junit.QuarkusTest;
import org.jboss.logging.Logger;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@QuarkusTest
class UserRepositoryTest {

    @Inject
    Logger LOG;

    @Inject
    UserRepository userRepository;

    @Transactional
    @Test
    void saveUser() {
        var user = userRepository.getEntityManager().merge(new User("TestUser1", "testUser1@gmail.com", "testUser1"));
        LOG.info(user);
        assertThat(user.id).isNotNull();
    }

}