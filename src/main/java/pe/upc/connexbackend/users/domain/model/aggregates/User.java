package pe.upc.connexbackend.users.domain.model.aggregates;

// Importa anotaciones de JPA y Lombok
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import pe.upc.connexbackend.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import pe.upc.connexbackend.users.domain.model.valueobjects.EmailAddress;
import pe.upc.connexbackend.users.domain.model.valueobjects.UserType;

// Marca la clase como una entidad y asigna la tabla "user" en la base de datos
@Entity
@Table(name = "`user`") // Las comillas invertidas se usan para evitar conflictos con "user", que es una palabra reservada en SQL
@Getter
@Setter
public class User extends AuditableAbstractAggregateRoot<User> {

    // Usa un objeto de valor "EmailAddress" embebido en la entidad
    @Embedded
    private EmailAddress email;

    // Columna para almacenar el hash de la contraseña, obligatoria y con un límite de 255 caracteres
    @Column(nullable = false, length = 255)
    private String passwordHash;

    // Columna para el tipo de usuario, obligatoria y con un límite de 50 caracteres, almacenado como texto
    @Column(nullable = false, length = 50)
    @Enumerated(EnumType.STRING)
    private UserType userType;

    // Columna que indica si el usuario está activo, predeterminado en `true`
    @Column(nullable = false)
    private Boolean isActive = true;

    // Constructor con parámetros para crear un usuario con email, hash de contraseña y tipo de usuario
    public User(
            String email,
            String passwordHash,
            UserType userType) {
        this.email = new EmailAddress(email);
        this.passwordHash = passwordHash;
        this.userType = userType;
    }

    // Constructor vacío necesario para JPA
    public User() {
    }

    // Método para obtener la dirección de correo electrónico como cadena de texto
    public String getEmailAddress() { return email.address(); }

    // Método para obtener el tipo de usuario como cadena de texto
    public String getUserType() { return userType.toString(); }

    // Método para obtener el tipo de usuario como objeto `UserType`
    public UserType getUserTypeEnum() { return userType; }
}
