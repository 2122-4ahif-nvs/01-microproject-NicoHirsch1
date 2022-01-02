package at.htl.recipes.control;

import at.htl.recipes.entity.Recipe;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@ApplicationScoped
public class RecipeRepository {

    @Inject
    EntityManager em;

    @Transactional
    public Recipe save(Recipe recipe) {
        return em.merge(recipe);
    }

}
