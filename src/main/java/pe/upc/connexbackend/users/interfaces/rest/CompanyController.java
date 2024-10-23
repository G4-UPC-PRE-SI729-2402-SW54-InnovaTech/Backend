package pe.upc.connexbackend.users.interfaces.rest;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.upc.connexbackend.users.domain.model.aggregates.Company;
import pe.upc.connexbackend.users.domain.model.commands.DeleteCompanyCommand;
import pe.upc.connexbackend.users.domain.model.commands.UpdateCompanyCommand;
import pe.upc.connexbackend.users.domain.model.queries.GetAllCompaniesQuery;
import pe.upc.connexbackend.users.domain.model.queries.GetCompanyByIdQuery;
import pe.upc.connexbackend.users.domain.services.CompanyCommandService;
import pe.upc.connexbackend.users.domain.services.CompanyQueryService;
import pe.upc.connexbackend.users.interfaces.rest.resources.CompanyResource;
import pe.upc.connexbackend.users.interfaces.rest.resources.CreateCompanyResource;
import pe.upc.connexbackend.users.interfaces.rest.transform.CompanyResourceFromEntityAssembler;
import pe.upc.connexbackend.users.interfaces.rest.transform.CreateCompanyCommandFromResourceAssembler;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/companies")
@Tag(name = "Companies", description = "Company Management Endpoints")
public class CompanyController {

    private final CompanyCommandService companyCommandService;
    private final CompanyQueryService companyQueryService;

    public CompanyController(CompanyCommandService companyCommandService, CompanyQueryService companyQueryService) {
        this.companyCommandService = companyCommandService;
        this.companyQueryService = companyQueryService;
    }

    @PostMapping
    public ResponseEntity<CompanyResource> createCompany(@RequestBody CreateCompanyResource resource) {
        var createCompanyCommand = CreateCompanyCommandFromResourceAssembler.toCommandFromResource(resource);
        var company = companyCommandService.handle(createCompanyCommand);
        if (company.isEmpty()) return ResponseEntity.badRequest().build();
        var companyResource = CompanyResourceFromEntityAssembler.toResourceFromEntity(company.get());

        return new ResponseEntity<>(companyResource, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompany(@PathVariable Integer id) {
        companyCommandService.handle(new DeleteCompanyCommand(id));
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Company> updateCompany(@PathVariable Integer id, @RequestBody UpdateCompanyCommand command) {
        Optional<Company> company = companyCommandService.handle(new UpdateCompanyCommand(id, command.name(), command.industry(), command.phoneNumber(), command.website()));
        if (company.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(company.get());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable Integer id) {
        Optional<Company> company = companyQueryService.handle(new GetCompanyByIdQuery(id));
        return company.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Company>> getAllCompanies() {
        List<Company> companies = companyQueryService.handle(new GetAllCompaniesQuery());
        return ResponseEntity.ok(companies);
    }
}
