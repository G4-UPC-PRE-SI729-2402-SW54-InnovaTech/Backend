package pe.upc.connexbackend.profiles.domain.model.queries;

public record GetProfileByIdQuery(Integer userId) {
    public GetProfileByIdQuery {
        if (userId == null) {
            throw new IllegalArgumentException("User ID is required");
        }
    }
}
