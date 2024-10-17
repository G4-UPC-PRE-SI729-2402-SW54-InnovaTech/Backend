package pe.upc.connexbackend.users.domain.model.queries;

public record GetUserByIdQuery (
        Integer id
) {
    public GetUserByIdQuery {
        if (id == null) {
            throw new IllegalArgumentException("id is required");
        }
    }
}
