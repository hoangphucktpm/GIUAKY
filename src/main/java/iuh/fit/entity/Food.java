package iuh.fit.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "food")
@NamedQueries({
        @NamedQuery(name = "Food.findAll", query = "SELECT f FROM Food f"),
        @NamedQuery(name = "Food.findByName", query = "SELECT f FROM Food f WHERE f.name = :name"),
        @NamedQuery(name = "Food.findFoodWithMaxServingTime", query = "SELECT f FROM Food f WHERE f.servingTime = (SELECT MAX(f2.servingTime) FROM Food f2)")
})
public class Food extends Item {
    @Enumerated(EnumType.STRING)
    private Type type;
    private int preparationTime;
    private int servingTime;

    public Food(String id, String name, Double price, String description, Boolean onSpecial, Set<Ingredient> ingredients, Type type, int preparationTime, int servingTime) {
        super(id, name, price, description, onSpecial, ingredients);
        this.type = type;
        this.preparationTime = preparationTime;
        this.servingTime = servingTime;
    }

    public Food() {
    }


    @Override
    public String toString() {
        return String.format("id = %s, name = %s, price = %f, description = %s, onSpecial = %b, ingredients = %s, type = %s, preparationTime = %d, servingTime = %d",
                id, name, price, description, onSpecial, ingredients, type, preparationTime, servingTime);
    }
}