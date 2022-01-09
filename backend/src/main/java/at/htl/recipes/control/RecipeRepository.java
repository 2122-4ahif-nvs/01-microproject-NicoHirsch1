package at.htl.recipes.control;

import at.htl.recipes.entity.Recipe;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;

@ApplicationScoped
public class RecipeRepository implements PanacheRepository<Recipe> {

    public List<Recipe> getAllRecipes() {
        TypedQuery<Recipe> query = getEntityManager().createQuery("select r from Recipe r", Recipe.class);
        return query.getResultList();
    }

    public Recipe getRecipeById(long id) {
        try {
            TypedQuery<Recipe> query = getEntityManager().createQuery("select r from Recipe r where r.id = :ID", Recipe.class);
            query.setParameter("ID", id);
            return query.getSingleResult();
        } catch (NoResultException exception) {
            return null;
        }
    }

}
