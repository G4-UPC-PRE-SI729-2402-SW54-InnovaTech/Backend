package pe.upc.connexbackend.users.interfaces.rest.resources;

public record CompanyResource(
        Integer id,
        String email,
        String password,
        String name,
        String industry,
        String phoneNumber,
        String website
) {
}
