package at.htl.recipes.entity;

import javax.persistence.*;

@Entity
@Table(name = "RECIPES")
public class Recipe {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private User user;

    private String title;

    private String description;

    //region constructors
    public Recipe() {
    }

    public Recipe(long id, User user, String title, String description) {
        this.id = id;
        this.user = user;
        this.title = title;
        this.description = description;
    }
    //endregion

    //region getter and setter
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
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
