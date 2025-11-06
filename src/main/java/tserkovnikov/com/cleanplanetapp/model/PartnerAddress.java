package tserkovnikov.com.cleanplanetapp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "partner_address")
public class PartnerAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "partner_id")
    private Partner partner;

    @Column(nullable = false)
    private String address;

    private Boolean isMain;

    private String phone;

    public PartnerAddress() {}

    // getters/setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Partner getPartner() { return partner; }
    public void setPartner(Partner partner) { this.partner = partner; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public Boolean getIsMain() { return isMain; }
    public void setIsMain(Boolean isMain) { this.isMain = isMain; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
}
