package at.htl.recipes.control;

import at.htl.recipes.entity.Recipe;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.TypedQuery;
import java.util.List;

@ApplicationScoped
public class RecipeRepository implements PanacheRepository<Recipe> {

    public List<Recipe> getAllRecipes() {
        TypedQuery<Recipe> query = getEntityManager().createQuery("select r from Recipe r", Recipe.class);
        return query.getResultList();
    }

}
