package pe.upc.connexbackend.users.domain.model.commands;

public record DeleteCompanyCommand(Integer companyId) {
    public DeleteCompanyCommand {
        if (companyId == null) {
            throw new IllegalArgumentException("Company ID is required");
        }
    }
}
