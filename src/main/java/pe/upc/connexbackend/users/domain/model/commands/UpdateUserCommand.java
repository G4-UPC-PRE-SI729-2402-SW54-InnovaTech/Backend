package pe.upc.connexbackend.users.domain.model.commands;

public record UpdateUserCommand(
        Integer id,
        String name,
        String email,
        String password,
        String role
) {
    public UpdateUserCommand {
        if (id == null || name == null || email == null || password == null || role == null) {
            throw new IllegalArgumentException("All fields are required");
        }
    }
}
