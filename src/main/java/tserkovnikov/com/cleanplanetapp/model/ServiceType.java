package tserkovnikov.com.cleanplanetapp.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "service_type")
public class ServiceType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name; // наименование услуги

    @Column(name = "coefficient", precision = 5, scale = 2, nullable = false)
    private BigDecimal coefficient; // коэффициент типа услуги

    // --- Конструкторы ---
    public ServiceType() {}

    public ServiceType(String name, BigDecimal coefficient) {
        this.name = name;
        this.coefficient = coefficient;
    }

    // --- Геттеры / сеттеры ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public BigDecimal getCoefficient() { return coefficient; }
    public void setCoefficient(BigDecimal coefficient) { this.coefficient = coefficient; }

    @Override
    public String toString() {
        return name;
    }
}

