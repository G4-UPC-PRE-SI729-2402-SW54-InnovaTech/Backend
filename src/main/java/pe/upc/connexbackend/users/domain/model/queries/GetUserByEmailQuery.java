package pe.upc.connexbackend.users.domain.model.queries;

public record GetUserByEmailQuery(
        String email
) {
    public GetUserByEmailQuery {
        if (email == null) {
            throw new IllegalArgumentException("email is required");
        }
    }
}
