package tserkovnikov.com.cleanplanetapp.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "rating_history")
public class RatingHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "partner_id")
    private Partner partner;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manager_id")
    private Employee manager;

    @Column(precision = 3, scale = 2)
    private BigDecimal oldRating;

    @Column(precision = 3, scale = 2)
    private BigDecimal newRating;

    public RatingHistory() {}

    // getters/setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Partner getPartner() { return partner; }
    public void setPartner(Partner partner) { this.partner = partner; }

    public Employee getManager() { return manager; }
    public void setManager(Employee manager) { this.manager = manager; }

    public BigDecimal getOldRating() { return oldRating; }
    public void setOldRating(BigDecimal oldRating) { this.oldRating = oldRating; }

    public BigDecimal getNewRating() { return newRating; }
    public void setNewRating(BigDecimal newRating) { this.newRating = newRating; }
}
