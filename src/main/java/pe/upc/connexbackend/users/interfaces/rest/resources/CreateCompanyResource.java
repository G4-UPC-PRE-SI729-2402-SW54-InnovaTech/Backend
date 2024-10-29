package pe.upc.connexbackend.users.interfaces.rest.resources;

// Recurso REST que representa los datos necesarios para crear una nueva compañía
public record CreateCompanyResource(
        String name,          // Nombre de la compañía
        String industry,      // Industria o sector al que pertenece
        String phoneNumber,   // Número de teléfono de contacto
        String website,       // Sitio web de la compañía
        String email,         // Correo electrónico del usuario de la compañía
        String password       // Contraseña (hash) para el usuario
) {
}
