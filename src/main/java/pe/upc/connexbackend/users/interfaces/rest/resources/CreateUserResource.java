package pe.upc.connexbackend.users.interfaces.rest.resources;

public record CreateUserResource(
        String email,
        String password,
        String userType
) {
}
