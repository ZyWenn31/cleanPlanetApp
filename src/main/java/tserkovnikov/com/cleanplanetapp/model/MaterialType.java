package tserkovnikov.com.cleanplanetapp.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "material_type")
public class MaterialType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name; // название материала

    @Column(name = "waste_percent", precision = 5, scale = 2, nullable = false)
    private BigDecimal wastePercent; // процент перерасхода материала

    // --- Конструкторы ---
    public MaterialType() {}

    public MaterialType(String name, BigDecimal wastePercent) {
        this.name = name;
        this.wastePercent = wastePercent;
    }

    // --- Геттеры / сеттеры ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public BigDecimal getWastePercent() { return wastePercent; }
    public void setWastePercent(BigDecimal wastePercent) { this.wastePercent = wastePercent; }

    @Override
    public String toString() {
        return name;
    }
}

