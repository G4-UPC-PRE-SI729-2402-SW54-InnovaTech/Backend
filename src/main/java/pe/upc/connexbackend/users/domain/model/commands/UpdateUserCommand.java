package pe.upc.connexbackend.users.domain.model.commands;

import pe.upc.connexbackend.users.domain.model.valueobjects.UserType;

public record UpdateUserCommand(Integer id, String email, String passwordHash, UserType userType) {
    public UpdateUserCommand {
        if (id == null) {
            throw new IllegalArgumentException("id is required");
        }
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("email is required");
        }
        if (passwordHash == null || passwordHash.isBlank()) {
            throw new IllegalArgumentException("passwordHash is required");
        }
        if (userType == null) {
            throw new IllegalArgumentException("userType is required");
        }
    }
}
