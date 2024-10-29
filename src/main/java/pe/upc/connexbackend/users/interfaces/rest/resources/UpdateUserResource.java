package pe.upc.connexbackend.users.interfaces.rest.resources;

// Recurso REST que representa los datos necesarios para actualizar un usuario
public record UpdateUserResource(
        String email,        // Correo electrónico del usuario
        String passwordHash  // Contraseña (hash) actualizada del usuario
) {
}
