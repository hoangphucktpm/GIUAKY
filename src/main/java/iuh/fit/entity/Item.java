package iuh.fit.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "item")
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQueries({
        @NamedQuery(name = "Item.findItemBySpecialAndSupplierName", query = "SELECT i FROM Item i INNER JOIN i.ingredients ig INNER JOIN ig.suppliers s WHERE i.onSpecial = :onSpecial and s.name = :name"),
})
public abstract class Item implements Serializable {
    static final long serialVersionUID = -5023340962065349410L;
    @Id
    @Column(name = "item_id", nullable = false)
    protected String id;
    protected String name;
    protected Double price;
    protected String description;
    protected Boolean onSpecial;

    @ManyToMany
    @JoinTable(
            name = "made_of",
            joinColumns = @JoinColumn(name = "item_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id")
    )
    protected Set<Ingredient> ingredients;


    public Item(String id, String name, Double price, String description, Boolean onSpecial, Set<Ingredient> ingredients) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.onSpecial = onSpecial;
        this.ingredients = ingredients;
    }

    public Item() {
    }

    @Override
    public String toString() {
        return "Item{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", onSpecial=" + onSpecial +
                ", ingredients=" + ingredients +
                '}';
    }
}