package iuh.fit.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "beverage")
public class Beverage extends Item {
    @Enumerated(EnumType.STRING)
    private Size size;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier suppliers;

    public Beverage(String id, String name, Double price, String description, Boolean onSpecial, Set<Ingredient> ingredients, Size size, Supplier suppliers) {
        super(id, name, price, description, onSpecial, ingredients);
        this.size = size;
        this.suppliers = suppliers;
    }

    public Beverage() {
    }


    @Override
    public String toString() {
        return "Beverage{" +
                "size=" + size +
                ", suppliers=" + suppliers +
                '}';
    }
}