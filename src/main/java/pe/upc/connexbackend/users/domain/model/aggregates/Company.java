package pe.upc.connexbackend.users.domain.model.aggregates;

// Importa anotaciones de JPA y Lombok
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import pe.upc.connexbackend.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

// Marca la clase como una entidad y asigna la tabla "company" en la base de datos
@Entity
@Table(name = "company")
@Getter
@Setter
public class Company extends AuditableAbstractAggregateRoot<Company> {

    // Relación uno a uno con la entidad User; si la compañía se elimina, también se elimina el usuario asociado
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;

    // Define una columna obligatoria "name" con un límite de 100 caracteres
    @Column(nullable = false, length = 100)
    private String name;

    // Define una columna opcional "industry" con un límite de 50 caracteres
    @Column(length = 50)
    private String industry;

    // Define una columna opcional "phoneNumber" con un límite de 15 caracteres
    @Column(length = 15)
    private String phoneNumber;

    // Define una columna opcional "website" con un límite de 100 caracteres
    @Column(length = 100)
    private String website;

    // Constructor vacío necesario para JPA
    public Company() {
    }
}
