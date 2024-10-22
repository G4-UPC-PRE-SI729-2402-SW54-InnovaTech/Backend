package pe.upc.connexbackend.users.domain.services;

import pe.upc.connexbackend.users.domain.model.aggregates.Company;
import pe.upc.connexbackend.users.domain.model.commands.CreateCompanyCommand;
import pe.upc.connexbackend.users.domain.model.commands.DeleteCompanyCommand;
import pe.upc.connexbackend.users.domain.model.commands.UpdateCompanyCommand;

import java.util.Optional;

public interface CompanyCommandService {
    Optional<Company> handle(CreateCompanyCommand command);
    Optional<Company> handle(UpdateCompanyCommand command);
    void handle(DeleteCompanyCommand command);
}
