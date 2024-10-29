package pe.upc.connexbackend.users.domain.model.queries;

// Define un registro inmutable para consultar una entidad de User por su ID
public record GetUserByIdQuery(
        Integer id // ID del usuario a consultar
) {
    // Constructor validado que lanza una excepción si el ID es nulo
    public GetUserByIdQuery {
        if (id == null) {
            throw new IllegalArgumentException("id is required");
        }
    }
}
