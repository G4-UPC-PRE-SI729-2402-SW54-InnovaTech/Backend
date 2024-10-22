package pe.upc.connexbackend.users.interfaces.rest.resources;

public record CreateCompanyResource(
        String name,
        String industry,
        String phoneNumber,
        String website,
        String email,
        String password
) {
}
