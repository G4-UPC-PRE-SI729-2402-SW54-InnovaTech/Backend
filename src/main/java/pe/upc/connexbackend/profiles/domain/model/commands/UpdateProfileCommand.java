package pe.upc.connexbackend.profiles.domain.model.commands;

import io.swagger.models.auth.In;

public record UpdateProfileCommand(
        Integer profileId,
        Integer userId,
        String bio,
        String brandName,
        String profilePictureUrl,
        String city,
        String country
) {
    public UpdateProfileCommand {
        if (profileId == null) {
            throw new IllegalArgumentException("Profile ID is required");
        }
        if (userId == null) {
            throw new IllegalArgumentException("User ID is required");
        }
        if (bio == null || bio.isBlank()) {
            throw new IllegalArgumentException("Bio is required");
        }
        if (brandName == null || brandName.isBlank()) {
            throw new IllegalArgumentException("Brand name is required");
        }
        if (profilePictureUrl == null || profilePictureUrl.isBlank()) {
            throw new IllegalArgumentException("Profile picture URL is required");
        }
        if (city == null || city.isBlank()) {
            throw new IllegalArgumentException("City is required");
        }
        if (country == null || country.isBlank()) {
            throw new IllegalArgumentException("Country is required");
        }
    }
}
