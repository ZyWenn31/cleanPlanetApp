package tserkovnikov.com.cleanplanetapp.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "partner_service_history")
public class PartnerServiceHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "partner_id", nullable = false)
    private Partner partner;

    @ManyToOne(optional = false)
    @JoinColumn(name = "service_type_id", nullable = false)
    private ServiceType serviceType;

    private Integer quantity;

    @Column(name = "service_date", nullable = false)
    private LocalDate serviceDate;

    // --- Конструкторы ---
    public PartnerServiceHistory() {}

    public PartnerServiceHistory(Partner partner, ServiceType serviceType, Integer quantity, LocalDate serviceDate) {
        this.partner = partner;
        this.serviceType = serviceType;
        this.quantity = quantity;
        this.serviceDate = serviceDate;
    }

    // --- Геттеры / сеттеры ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Partner getPartner() { return partner; }
    public void setPartner(Partner partner) { this.partner = partner; }

    public ServiceType getServiceType() { return serviceType; }
    public void setServiceType(ServiceType serviceType) { this.serviceType = serviceType; }

    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }

    public LocalDate getServiceDate() { return serviceDate; }
    public void setServiceDate(LocalDate serviceDate) { this.serviceDate = serviceDate; }

    // Вспомогательный метод для TableView в JavaFX
    public String getServiceName() {
        return serviceType != null ? serviceType.getName() : "";
    }


}
