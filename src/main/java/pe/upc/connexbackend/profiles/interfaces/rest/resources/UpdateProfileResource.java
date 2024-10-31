package pe.upc.connexbackend.profiles.interfaces.rest.resources;

public record UpdateProfileResource(
        String bio,
        String brandName,
        String profilePictureUrl,
        String city,
        String country
) {
}
