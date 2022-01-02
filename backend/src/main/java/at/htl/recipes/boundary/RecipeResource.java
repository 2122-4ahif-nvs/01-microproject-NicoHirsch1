package at.htl.recipes.boundary;

import at.htl.recipes.control.RecipeRepository;
import at.htl.recipes.entity.Recipe;
import org.eclipse.microprofile.graphql.Description;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Query;

import javax.inject.Inject;
import java.util.List;

@GraphQLApi
public class RecipeResource {

    @Inject
    RecipeRepository recipeRepository;

    @Query("allRecipes")
    @Description("Get all Recipes")
    public List<Recipe> getAllRecipes() {
        return recipeRepository.getAllRecipes();
    }

}
