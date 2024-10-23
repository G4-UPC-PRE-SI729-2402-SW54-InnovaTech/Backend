package pe.upc.connexbackend.users.interfaces.rest.resources;

public record UpdateUserResource(
        String email,
        String passwordHash
){
}
