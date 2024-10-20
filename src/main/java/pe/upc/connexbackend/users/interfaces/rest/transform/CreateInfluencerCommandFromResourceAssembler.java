package pe.upc.connexbackend.users.interfaces.rest.transform;

import pe.upc.connexbackend.users.domain.model.commands.CreateInfluencerCommand;
import pe.upc.connexbackend.users.interfaces.rest.resources.CreateInfluencerResource;

public class CreateInfluencerCommandFromResourceAssembler {
    public static CreateInfluencerCommand toCommandFromResource(CreateInfluencerResource resource) {
        return new CreateInfluencerCommand(
                resource.firstName(),
                resource.lastName(),
                resource.phoneNumber(),
                resource.socialMediaHandle(),
                resource.email(),
                resource.password()
        );
    }
}