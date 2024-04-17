package iuh.fit.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "ingredient")
@NamedQueries({

        @NamedQuery(name = "Ingredient.findByExpiryDate", query = "SELECT i FROM Ingredient i WHERE i.expiryDate < :currentDate"),
})
public class Ingredient implements Serializable {

    static final long serialVersionUID = -5023340962065349410L;
    @Id
    @Column(name = "ingredien_id", nullable = false)
    private String id;

    private String name;
    private String url;
    private String unit;
    private double price;
    private double quantity;
    private LocalDate manufacturingDate;
    private LocalDate expiryDate;

    @ManyToMany
    @JoinTable(
            name = "supply_by",
            joinColumns = @JoinColumn(name = "ingredient_id"),
            inverseJoinColumns = @JoinColumn(name = "supplier_id")
    )
    private Set<Supplier> suppliers;

    public Ingredient(String id, String name, String url, String unit, double price, double quantity, LocalDate manufacturingDate, LocalDate expiryDate, Set<Supplier> suppliers) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.unit = unit;
        this.price = price;
        this.quantity = quantity;
        this.manufacturingDate = manufacturingDate;
        this.expiryDate = expiryDate;
        this.suppliers = suppliers;
    }

    public Ingredient() {
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", unit='" + unit + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", manufacturingDate=" + manufacturingDate +
                ", expiryDate=" + expiryDate +
                ", suppliers=" + suppliers +
                '}';
    }
}