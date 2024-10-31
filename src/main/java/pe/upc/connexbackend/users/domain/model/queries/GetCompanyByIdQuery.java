package pe.upc.connexbackend.users.domain.model.queries;

// Define un registro inmutable para consultar una entidad de Company por su ID
public record GetCompanyByIdQuery(Integer companyId) {
    
    // Constructor validado que lanza una excepción si el ID de la empresa es nulo
    public GetCompanyByIdQuery {
        if (companyId == null) {
            throw new IllegalArgumentException("Company ID is required");
        }
    }
}
