package pe.upc.connexbackend.users.domain.services;


import pe.upc.connexbackend.users.domain.model.aggregates.Company;
import pe.upc.connexbackend.users.domain.model.queries.GetAllCompaniesQuery;
import pe.upc.connexbackend.users.domain.model.queries.GetCompanyByIdQuery;

import java.util.List;
import java.util.Optional;

public interface CompanyQueryService {
    Optional<Company> handle(GetCompanyByIdQuery query);
    List<Company> handle(GetAllCompaniesQuery query);

}
