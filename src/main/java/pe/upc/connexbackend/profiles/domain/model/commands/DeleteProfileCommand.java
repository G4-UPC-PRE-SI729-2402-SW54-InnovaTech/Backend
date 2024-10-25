package pe.upc.connexbackend.profiles.domain.model.commands;

public record DeleteProfileCommand(
        Integer userId
) {
    public DeleteProfileCommand {
        if (userId == null) {
            throw new IllegalArgumentException("User ID is required");
        }
    }
}
