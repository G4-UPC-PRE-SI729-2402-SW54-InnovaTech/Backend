package pe.upc.connexbackend.users.domain.model.queries;

// Importa la clase EmailAddress del modelo de valor
import pe.upc.connexbackend.users.domain.model.valueobjects.EmailAddress;

// Define un registro inmutable para consultar una entidad de User por su dirección de correo electrónico
public record GetUserByEmailQuery(EmailAddress emailAddress) {
    
    // Constructor validado que lanza una excepción si la dirección de correo electrónico es nula
    public GetUserByEmailQuery {
        if (emailAddress == null) {
            throw new IllegalArgumentException("emailAddress is required");
        }
    }
}
