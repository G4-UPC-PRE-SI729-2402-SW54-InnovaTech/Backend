package pe.upc.connexbackend.users.domain.model.commands;

// Define un comando inmutable para actualizar una entidad de Company
public record UpdateCompanyCommand(
        Integer companyId,
        String name,
        String industry,
        String phoneNumber,
        String website
) {
    // Constructor validado que lanza excepciones si los campos obligatorios están vacíos o nulos
    public UpdateCompanyCommand {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name is required");
        }
        if (industry == null || industry.isBlank()) {
            throw new IllegalArgumentException("Industry is required");
        }
        if (phoneNumber == null || phoneNumber.isBlank()) {
            throw new IllegalArgumentException("Phone number is required");
        }
        if (website == null || website.isBlank()) {
            throw new IllegalArgumentException("Website is required");
        }
    }
}

