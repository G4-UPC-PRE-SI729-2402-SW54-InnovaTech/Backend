package pe.upc.connexbackend.users.domain.model.commands;

import pe.upc.connexbackend.users.domain.model.valueobjects.UserType;

public record CreateUserCommand(String email, String passwordHash, UserType userType){
    public CreateUserCommand {
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
