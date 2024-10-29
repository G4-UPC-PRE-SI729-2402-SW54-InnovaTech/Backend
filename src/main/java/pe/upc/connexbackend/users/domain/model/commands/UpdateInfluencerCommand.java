package pe.upc.connexbackend.users.domain.model.commands;

// Define un comando inmutable para actualizar una entidad de Influencer
public record UpdateInfluencerCommand(
        Integer influencerId,          // ID del influencer a actualizar
        String firstName,              // Nombre del influencer
        String lastName,               // Apellido del influencer
        String phoneNumber,            // Número de teléfono del influencer
        String socialMediaHandle       // Manejador de redes sociales del influencer
) {
    // Constructor validado que lanza excepciones si los campos obligatorios están vacíos o nulos
    public UpdateInfluencerCommand {
        if (influencerId == null) {
            throw new IllegalArgumentException("Influencer ID is required");
        }
        if (firstName == null || firstName.isBlank()) {
            throw new IllegalArgumentException("First name is required");
        }
        if (lastName == null || lastName.isBlank()) {
            throw new IllegalArgumentException("Last name is required");
        }
        if (phoneNumber == null || phoneNumber.isBlank()) {
            throw new IllegalArgumentException("Phone number is required");
        }
        if (socialMediaHandle == null || socialMediaHandle.isBlank()) {
            throw new IllegalArgumentException("Social media handle is required");
        }
    }
}
