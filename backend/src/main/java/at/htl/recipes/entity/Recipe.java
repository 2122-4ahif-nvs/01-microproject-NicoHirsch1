package at.htl.recipes.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;

@Entity
@Table(name = "RECIPES")
public class Recipe extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;

    @ManyToOne(cascade = CascadeType.ALL)
    public User user;

    public String title;

    public String description;

    //region constructors
    public Recipe() {
    }

    public Recipe(User user, String title, String description) {
        this.user = user;
        this.title = title;
        this.description = description;
    }
    //endregion

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", user=" + user +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
