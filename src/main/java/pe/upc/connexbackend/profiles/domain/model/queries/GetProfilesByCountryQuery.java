package pe.upc.connexbackend.profiles.domain.model.queries;

public record GetProfilesByCountryQuery(String country) {
    public GetProfilesByCountryQuery {
        if (country == null) {
            throw new IllegalArgumentException("Country is required");
        }
    }
}
