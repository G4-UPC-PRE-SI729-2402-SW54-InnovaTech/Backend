package pe.upc.connexbackend.users.interfaces.rest.resources;

// Recurso REST que representa los datos necesarios para crear un nuevo usuario
public record CreateUserResource(
        String email,    // Correo electrónico del usuario
        String password, // Contraseña (hash) para la cuenta del usuario
        String userType  // Tipo de usuario (e.g., COMPANY, INFLUENCER)
) {
}
