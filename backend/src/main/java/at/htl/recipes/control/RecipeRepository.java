package at.htl.recipes.control;

import at.htl.recipes.entity.Recipe;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class RecipeRepository {

    @Inject
    EntityManager em;

    @Transactional
    public Recipe save(Recipe recipe) {
        return em.merge(recipe);
    }

    public List<Recipe> getAllRecipes() {
        TypedQuery<Recipe> query = em.createQuery("select r from Recipe r", Recipe.class);
        return query.getResultList();
    }

}
