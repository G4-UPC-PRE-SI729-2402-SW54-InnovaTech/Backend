package pe.upc.connexbackend.users.domain.model.valueobjects;

// Indica que esta clase puede ser embebida en otras entidades JPA
import jakarta.persistence.Embeddable;

@Embeddable
public record EmailAddress(String address) {
    
    // Constructor por defecto que inicializa el address como nulo
    public EmailAddress() {
        this(null);
    }

    // Constructor validado que lanza una excepción si la dirección de correo electrónico es nula o está vacía
    public EmailAddress {
        if (address == null || address.isBlank()) {
            throw new IllegalArgumentException("Email address is required");
        }
    }
}
