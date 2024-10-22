package pe.upc.connexbackend.users.interfaces.rest.transform;

import pe.upc.connexbackend.users.domain.model.commands.CreateCompanyCommand;
import pe.upc.connexbackend.users.interfaces.rest.resources.CreateCompanyResource;

public class CreateCompanyCommandFromResourceAssembler {
    public static CreateCompanyCommand toCommandFromResource(CreateCompanyResource resource) {
        return new CreateCompanyCommand(
                resource.name(),
                resource.industry(),
                resource.phoneNumber(),
                resource.website(),
                resource.email(),
                resource.password()
        );
    }
}
