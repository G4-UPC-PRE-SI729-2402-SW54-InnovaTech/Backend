package pe.upc.connexbackend.users.domain.model.commands;

// Importa el tipo de usuario definido en el dominio
import pe.upc.connexbackend.users.domain.model.valueobjects.UserType;

// Define un comando inmutable para actualizar una entidad de User
public record UpdateUserCommand(Integer id, String email, String passwordHash, UserType userType) {
    
    // Constructor validado que lanza excepciones si los campos obligatorios están vacíos o nulos
    public UpdateUserCommand {
        if (id == null) {
            throw new IllegalArgumentException("id is required");
        }
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("email is required");
        }
        if (passwordHash == null || passwordHash.isBlank()) {
            throw new IllegalArgumentException("passwordHash is required");
        }
        if (userType == null) {
            throw new IllegalArgumentException("userType is required");
        }
    }
}
