package pe.upc.connexbackend.users.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import pe.upc.connexbackend.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

@Entity
@Table(name = "company")
@Getter
@Setter
public class Company extends AuditableAbstractAggregateRoot<Company> {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(length = 50)
    private String industry;

    @Column(length = 15)
    private String phoneNumber;

    @Column(length = 100)
    private String website;

    public Company() {
    }
}