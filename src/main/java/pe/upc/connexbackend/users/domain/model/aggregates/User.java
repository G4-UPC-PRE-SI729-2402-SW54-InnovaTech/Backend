package pe.upc.connexbackend.users.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import pe.upc.connexbackend.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import pe.upc.connexbackend.users.domain.model.valueobjects.EmailAddress;
import pe.upc.connexbackend.users.domain.model.valueobjects.UserType;

@Entity
@Table(name = "`user`")
@Getter
@Setter
public class User extends AuditableAbstractAggregateRoot<User> {

    @Embedded
    private EmailAddress email;

    @Column(nullable = false, length = 255)
    private String passwordHash;

    @Column(nullable = false, length = 50)
    @Enumerated(EnumType.STRING)
    private UserType userType;

    @Column(nullable = false)
    private Boolean isActive = true;

    public User(
            String email,
            String passwordHash,
            UserType userType) {
        this.email = new EmailAddress(email);
        this.passwordHash = passwordHash;
        this.userType = userType;
    }

    public User() {
    }

    public String getEmailAddress() { return email.address();  }

    public String getUserType() { return userType.toString(); }

}