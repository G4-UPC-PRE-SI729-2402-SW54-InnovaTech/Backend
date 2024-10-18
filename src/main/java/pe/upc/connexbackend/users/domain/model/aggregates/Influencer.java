package pe.upc.connexbackend.users.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "influencer")
@Getter
@Setter
public class Influencer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer influencerId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false, unique = true)
    private User user;

    @Column(nullable = false, length = 50)
    private String firstName;

    @Column(nullable = false, length = 50)
    private String lastName;

    @Column(length = 15)
    private String phoneNumber;

    @Column(length = 50)
    private String socialMediaHandle;

    public Influencer() {
    }
}