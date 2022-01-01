package at.htl.recipes.control;

import at.htl.recipes.entity.User;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class UserRepositoryTest {

    @Inject
    UserRepository userRepository;

    @Test
    void addUser() {
        User user = userRepository.save(new User("User", "user@gmail.com", "user"));
        assertThat(user.getId()).isNotNull();
    }

}