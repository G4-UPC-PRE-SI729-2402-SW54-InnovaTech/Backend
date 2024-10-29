package pe.upc.connexbackend.users.domain.model.aggregates;

// Importa anotaciones de JPA y Lombok
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import pe.upc.connexbackend.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

// Marca la clase como una entidad y asigna la tabla "influencer" en la base de datos
@Entity
@Table(name = "influencer")
@Getter
@Setter
public class Influencer extends AuditableAbstractAggregateRoot<Influencer> {

    // Relación uno a uno con la entidad User; eliminación en cascada y garantiza unicidad en "user_id"
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false, unique = true)
    private User user;

    // Define una columna obligatoria "firstName" con un límite de 50 caracteres
    @Column(nullable = false, length = 50)
    private String firstName;

    // Define una columna obligatoria "lastName" con un límite de 50 caracteres
    @Column(nullable = false, length = 50)
    private String lastName;

    // Define una columna opcional "phoneNumber" con un límite de 15 caracteres
    @Column(length = 15)
    private String phoneNumber;

    // Define una columna opcional "socialMediaHandle" con un límite de 50 caracteres
    @Column(length = 50)
    private String socialMediaHandle;

    // Constructor vacío necesario para JPA
    public Influencer() {
    }
}
