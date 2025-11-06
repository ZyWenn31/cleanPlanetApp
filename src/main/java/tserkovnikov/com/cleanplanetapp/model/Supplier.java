package tserkovnikov.com.cleanplanetapp.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "supplier")
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String type;

    private String inn;

    @Column(precision = 3, scale = 2)
    private BigDecimal rating;

    public Supplier() {}

    // getters/setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getInn() { return inn; }
    public void setInn(String inn) { this.inn = inn; }

    public BigDecimal getRating() { return rating; }
    public void setRating(BigDecimal rating) { this.rating = rating; }
}
