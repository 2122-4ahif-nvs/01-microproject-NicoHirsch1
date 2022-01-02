package at.htl.recipes.control;

import at.htl.recipes.entity.Recipe;
import at.htl.recipes.entity.User;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class RecipeRepositoryTest {

    @Inject
    RecipeRepository recipeRepository;

    @Inject
    UserRepository userRepository;

    @Test
    void saveRecipe() {
        User user = userRepository.save(new User("RecipeUser1", "recipeUser1@gmail.com", "recipeUser1"));
        Recipe recipe = recipeRepository.save(new Recipe(user, "Pizza", "Salami Pizza"));
        assertThat(recipe.getId()).isNotNull();
    }

}