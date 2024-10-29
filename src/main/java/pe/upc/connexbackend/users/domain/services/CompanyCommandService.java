package pe.upc.connexbackend.users.domain.services;

import pe.upc.connexbackend.users.domain.model.aggregates.Company;
import pe.upc.connexbackend.users.domain.model.commands.CreateCompanyCommand;
import pe.upc.connexbackend.users.domain.model.commands.DeleteCompanyCommand;
import pe.upc.connexbackend.users.domain.model.commands.UpdateCompanyCommand;

import java.util.Optional;

//Interfaz que define los servicios de comandos para manejar operaciones de una empresa
public interface CompanyCommandService {
    //Maneja la creación de una nueva empresa
    Optional<Company> handle(CreateCompanyCommand command);
    //Maneja la actualización de una empresa existente 
    Optional<Company> handle(UpdateCompanyCommand command);
    //Maneja la eliminación de una empresa
    void handle(DeleteCompanyCommand command);
}
