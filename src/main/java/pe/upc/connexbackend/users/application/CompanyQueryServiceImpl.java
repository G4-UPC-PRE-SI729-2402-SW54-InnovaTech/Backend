package pe.upc.connexbackend.users.application;

import org.springframework.stereotype.Service;
import pe.upc.connexbackend.users.domain.model.aggregates.Company;
import pe.upc.connexbackend.users.domain.model.queries.GetAllCompaniesQuery;
import pe.upc.connexbackend.users.domain.model.queries.GetCompanyByIdQuery;
import pe.upc.connexbackend.users.domain.services.CompanyQueryService;
import pe.upc.connexbackend.users.infraestructure.persistance.jpa.repositories.CompanyRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyQueryServiceImpl implements CompanyQueryService {
    private final CompanyRepository companyRepository;

    public CompanyQueryServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public Optional<Company> handle(GetCompanyByIdQuery query) {
        return companyRepository.findById(query.companyId());
    }

    @Override
    public List<Company> handle(GetAllCompaniesQuery query) {
        return companyRepository.findAll();
    }
}
