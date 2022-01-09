package at.htl.recipes.control;

import at.htl.recipes.entity.Recipe;
import at.htl.recipes.entity.User;
import io.quarkus.test.junit.QuarkusTest;
import org.jboss.logging.Logger;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import javax.inject.Inject;
import javax.transaction.Transactional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@QuarkusTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class RecipeRepositoryTest {

    @Inject
    Logger LOG;

    @Inject
    RecipeRepository recipeRepository;

    @Order(1)
    @Test
    @Transactional
    void saveRecipe() {
        var recipe = recipeRepository.getEntityManager().merge(new Recipe(new User("TestUser1", "testUser1@gmail.com", "testUser1"), "Salami Pizza", "Just a salami pizza"));
        LOG.info(recipe);
        assertThat(recipe.id).isNotNull();
    }

    @Order(2)
    @Test
    void getAllRecipes() {
        var recipes = recipeRepository.getAllRecipes();
        LOG.info(recipes);
        assertThat(recipes.size()).isEqualTo(1);
    }

    @Order(3)
    @Test
    void getRecipeById() {
        var recipe = recipeRepository.getRecipeById(1);
        LOG.info(recipe);
        assertThat(recipe).isNotNull();
    }

}