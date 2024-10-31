package pe.upc.connexbackend.users.interfaces.rest.resources;

// Recurso REST que representa los datos necesarios para crear un nuevo influencer
public record CreateInfluencerResource(
        String email,              // Correo electrónico del influencer
        String password,           // Contraseña (hash) para la cuenta del influencer
        String firstName,          // Nombre del influencer
        String lastName,           // Apellido del influencer
        String phoneNumber,        // Número de teléfono de contacto
        String socialMediaHandle   // Usuario o identificador en redes sociales
) {
}
