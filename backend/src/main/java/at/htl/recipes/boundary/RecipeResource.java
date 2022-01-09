package at.htl.recipes.boundary;

import at.htl.recipes.control.RecipeRepository;
import at.htl.recipes.entity.Recipe;
import io.quarkus.qute.Location;
import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;
import org.eclipse.microprofile.graphql.Description;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Query;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@GraphQLApi
@Path("recipes")
public class RecipeResource {

    @Inject
    @Location("recipes/recipeinfo.qute.html")
    Template recipeInfo;

    @Inject
    RecipeRepository recipeRepository;

    @Query("allRecipes")
    @Description("Get all Recipes")
    public List<Recipe> getAllRecipes() {
        return recipeRepository.getAllRecipes();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance recipeInfo(@PathParam long id) {
        var recipe = recipeRepository.getRecipeById(id);
        return this.recipeInfo.data("title", recipe.title, "description", recipe.description, "username", recipe.user.userName);
    }

}
