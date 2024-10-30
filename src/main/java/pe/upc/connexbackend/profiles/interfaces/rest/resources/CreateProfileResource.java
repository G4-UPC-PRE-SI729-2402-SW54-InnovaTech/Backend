package pe.upc.connexbackend.profiles.interfaces.rest.resources;

public record CreateProfileResource(
        Integer userId,
        String bio,
        String brandName,
        String profilePictureUrl,
        String city,
        String country
) {
}
