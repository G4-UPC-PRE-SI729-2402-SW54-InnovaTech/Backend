package pe.upc.connexbackend.profiles.interfaces.rest.transform;

import pe.upc.connexbackend.profiles.domain.model.commands.CreateProfileCommand;
import pe.upc.connexbackend.profiles.interfaces.rest.resources.CreateProfileResource;

public class CreateProfileCommandFromResourceAssembler {
    public static CreateProfileCommand toCommandFromResource(CreateProfileResource Resource) {
        return new CreateProfileCommand(
                Resource.userId(),
                Resource.bio(),
                Resource.brandName(),
                Resource.profilePictureUrl(),
                Resource.city(),
                Resource.country()
        );
    }
}
