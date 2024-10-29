package pe.upc.connexbackend.users.interfaces.rest.resources;

// Recurso REST que representa los datos de un usuario
public record UserResource(
        String email,    // Correo electrónico del usuario
        String password  // Contraseña (hash) del usuario
) {
}
