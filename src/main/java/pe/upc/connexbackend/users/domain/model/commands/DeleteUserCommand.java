package pe.upc.connexbackend.users.domain.model.commands;

public record DeleteUserCommand(
        Integer id
) {
    public DeleteUserCommand {
        if (id == null) {
            throw new IllegalArgumentException("id is required");
        }
    }
}
