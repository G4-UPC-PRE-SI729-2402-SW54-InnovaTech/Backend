package pe.upc.connexbackend.users.application;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.upc.connexbackend.users.domain.model.aggregates.Company;
import pe.upc.connexbackend.users.domain.model.aggregates.User;
import pe.upc.connexbackend.users.domain.model.commands.CreateCompanyCommand;
import pe.upc.connexbackend.users.domain.model.commands.DeleteCompanyCommand;
import pe.upc.connexbackend.users.domain.model.commands.UpdateCompanyCommand;
import pe.upc.connexbackend.users.domain.model.valueobjects.UserType;
import pe.upc.connexbackend.users.domain.services.CompanyCommandService;
import pe.upc.connexbackend.users.domain.model.valueobjects.EmailAddress;
import pe.upc.connexbackend.users.infraestructure.persistance.jpa.repositories.CompanyRepository;
import pe.upc.connexbackend.users.infraestructure.persistance.jpa.repositories.UserRepository;

import java.util.Optional;

/**
 * Servicio para manejar los comandos relacionados con las compañías.
 * Implementa la interfaz CompanyCommandService y proporciona la lógica 
 * para crear, actualizar y eliminar compañías en la base de datos.
 */
@Service
public class CompanyCommandServiceImpl implements CompanyCommandService {
    private final CompanyRepository companyRepository;
    private final UserRepository userRepository;
     /**
     * Constructor que inyecta las dependencias del repositorio de compañías y usuarios.
     */
    public CompanyCommandServiceImpl(CompanyRepository companyRepository, UserRepository userRepository) {
        this.companyRepository = companyRepository;
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public Optional<Company>  handle(CreateCompanyCommand command) {
        var emailAddress = new EmailAddress(command.email());
        userRepository.findByEmail(emailAddress).map(user -> {
            throw new IllegalArgumentException("User with email " + emailAddress.address() + " already exists");
        });
        var user = new User(command.email(), command.passwordHash(), UserType.COMPANY);
        var company = new Company();
        company.setUser(user);
        company.setName(command.name());
        company.setIndustry(command.industry());
        company.setPhoneNumber(command.phoneNumber());
        company.setWebsite(command.website());

        var createdCompany = companyRepository.save(company);

        return Optional.of(createdCompany);
    }

    @Override
    @Transactional
    public void handle(DeleteCompanyCommand command) {
        companyRepository.deleteById(command.companyId());
    }

    @Override
    @Transactional
    public Optional<Company>  handle(UpdateCompanyCommand command) {
        Company company = companyRepository.findById(command.companyId())
                .orElseThrow(() -> new RuntimeException("Company not found"));
        company.setName(command.name());
        company.setIndustry(command.industry());
        company.setPhoneNumber(command.phoneNumber());
        company.setWebsite(command.website());

        return Optional.of(companyRepository.save(company));
    }
}

