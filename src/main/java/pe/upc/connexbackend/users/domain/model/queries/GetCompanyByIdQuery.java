package pe.upc.connexbackend.users.domain.model.queries;

public record GetCompanyByIdQuery( Integer companyId) {
    public GetCompanyByIdQuery {
        if (companyId == null) {
            throw new IllegalArgumentException("Company ID is required");
        }
    }
}
