package pe.upc.connexbackend.profiles.interfaces.rest.transform;

import pe.upc.connexbackend.profiles.domain.model.aggregates.Profile;
import pe.upc.connexbackend.profiles.interfaces.rest.resources.ProfileResource;

public class ProfileResourceFromEntityAssembler {
    public static ProfileResource toResourceFromEntity(Profile profile) {
        return new ProfileResource(
                profile.getUser().getId(),
                profile.getBio(),
                profile.getBrandName(),
                profile.getProfilePictureUrl(),
                profile.getLocation().city(),
                profile.getLocation().country()
        );
    }
}
