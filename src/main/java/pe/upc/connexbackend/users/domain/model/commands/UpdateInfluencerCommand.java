package pe.upc.connexbackend.users.domain.model.commands;

public record UpdateInfluencerCommand(
        Integer influencerId,
        String firstName,
        String lastName,
        String phoneNumber,
        String socialMediaHandle
) {
    public UpdateInfluencerCommand {
        if (influencerId == null) {
            throw new IllegalArgumentException("Influencer ID is required");
        }
        if (firstName == null || firstName.isBlank()) {
            throw new IllegalArgumentException("First name is required");
        }
        if (lastName == null || lastName.isBlank()) {
            throw new IllegalArgumentException("Last name is required");
        }
        if (phoneNumber == null || phoneNumber.isBlank()) {
            throw new IllegalArgumentException("Phone number is required");
        }
        if (socialMediaHandle == null || socialMediaHandle.isBlank()) {
            throw new IllegalArgumentException("Social media handle is required");
        }
    }
}
