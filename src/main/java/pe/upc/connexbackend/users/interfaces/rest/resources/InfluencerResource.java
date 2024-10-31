package pe.upc.connexbackend.users.interfaces.rest.resources;

// Recurso REST que representa los datos de un influencer
public record InfluencerResource(
        Integer id,               // ID único del influencer
        String email,              // Correo electrónico del influencer
        String password,           // Contraseña (hash) del usuario
        String firstName,          // Nombre del influencer
        String lastName,           // Apellido del influencer
        String phoneNumber,        // Número de teléfono de contacto
        String socialMediaHandle   // Usuario o identificador en redes sociales
) {
}
