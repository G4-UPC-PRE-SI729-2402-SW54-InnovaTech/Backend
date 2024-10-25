package pe.upc.connexbackend.profiles.domain.model.aggregates;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;
import pe.upc.connexbackend.profiles.domain.model.valueobjects.Location;
import pe.upc.connexbackend.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import pe.upc.connexbackend.users.domain.model.aggregates.User;

@Entity
@Table(name = "profile")
@Getter
@Setter
public class Profile extends AuditableAbstractAggregateRoot<Profile> {

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false, unique = true)
    private User user;

    @Column(length = 255)
    private String brandName;

    @Column(length = 255)
    private String bio;

    @Column(length = 255)
    private String profilePictureUrl;

    @Embedded
    private Location location;

    public Profile() {
    }

}