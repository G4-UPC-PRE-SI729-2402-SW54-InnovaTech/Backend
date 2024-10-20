package pe.upc.connexbackend.users.interfaces.rest.resources;

public record InfluencerResource(
        Integer id,
        String email,
        String password,
        String status,
        String firstName,
        String lastName,
        String phoneNumber,
        String socialMediaHandle
) {
}
