package tserkovnikov.com.cleanplanetapp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String fullName;

    @Column(name = "password")
    private String password;

    private String position;

    private String accessCard;

    private Boolean healthOk;

    public Employee() {}

    // getters/setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }

    public String getAccessCard() { return accessCard; }
    public void setAccessCard(String accessCard) { this.accessCard = accessCard; }

    public Boolean getHealthOk() { return healthOk; }
    public void setHealthOk(Boolean healthOk) { this.healthOk = healthOk; }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
