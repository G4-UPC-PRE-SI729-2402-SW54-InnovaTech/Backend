package pe.upc.connexbackend.users.domain.model.commands;

// Define un comando inmutable para eliminar una entidad de Company
public record DeleteCompanyCommand(Integer companyId) {
    
    // Constructor validado que lanza una excepción si el ID de la empresa es nulo
    public DeleteCompanyCommand {
        if (companyId == null) {
            throw new IllegalArgumentException("Company ID is required");
        }
    }
}

