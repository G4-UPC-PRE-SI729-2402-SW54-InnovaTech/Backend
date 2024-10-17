package pe.upc.connexbackend.users.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import pe.upc.connexbackend.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import pe.upc.connexbackend.users.domain.model.valueobjects.UserType;

@Entity
@Getter
@Setter
public class User extends AuditableAbstractAggregateRoot<User> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @Column(unique = true, nullable = false, length = 100)
    private String email;

    @Column(nullable = false, length = 255)
    private String passwordHash;

    @Column(nullable = false, length = 50)
    @Enumerated(EnumType.STRING)
    private UserType userType;

    @Column(nullable = false)
    private Boolean isActive = true;

    public User() {
    }
}