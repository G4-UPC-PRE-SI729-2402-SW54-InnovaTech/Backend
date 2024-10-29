package pe.upc.connexbackend.users.interfaces.rest.resources;

// Definición de un recurso REST para representar datos de una compañía
public record CompanyResource(
        Integer id,          // ID único de la compañía
        String email,         // Correo electrónico asociado a la compañía
        String password,      // Contraseña (hash) del usuario de la compañía
        String name,          // Nombre de la compañía
        String industry,      // Industria o sector al que pertenece
        String phoneNumber,   // Número de teléfono de contacto
        String website        // Sitio web de la compañía
) {
}
