package pe.upc.connexbackend.profiles.domain.model.commands;

public record DeleteProfileCommand(
        Integer profileId
) {
    public DeleteProfileCommand {
        if (profileId == null) {
            throw new IllegalArgumentException("Profile ID is required");
        }
    }
}
