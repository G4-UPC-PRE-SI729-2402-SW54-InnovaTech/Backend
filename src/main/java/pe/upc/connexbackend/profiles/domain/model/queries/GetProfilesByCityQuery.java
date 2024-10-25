package pe.upc.connexbackend.profiles.domain.model.queries;

public record GetProfilesByCityQuery(String city) {
    public GetProfilesByCityQuery {
        if (city == null) {
            throw new IllegalArgumentException("City is required");
        }
    }
}
