package pe.upc.connexbackend.users.domain.services;


import pe.upc.connexbackend.users.domain.model.aggregates.Company;
import pe.upc.connexbackend.users.domain.model.queries.GetAllCompaniesQuery;
import pe.upc.connexbackend.users.domain.model.queries.GetCompanyByIdQuery;

import java.util.List;
import java.util.Optional;

//Interfaz que define los serivicios de consulta para manejar operaciones con empresas
public interface CompanyQueryService {
    //Maneja la consulta para poder obtener una empresa por su ID 
    Optional<Company> handle(GetCompanyByIdQuery query);
    //Maneja la consulta para obtener todas las empresa 
    List<Company> handle(GetAllCompaniesQuery query);

}
