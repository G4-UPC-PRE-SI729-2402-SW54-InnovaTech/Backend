package pe.upc.connexbackend.users.domain.model.queries;

// Define un registro inmutable para consultar una entidad de Influencer por su ID
public record GetInfluencerByIdQuery(Integer influencerId) {
    
    // Constructor validado que lanza una excepción si el ID del influencer es nulo
    public GetInfluencerByIdQuery {
        if (influencerId == null) {
            throw new IllegalArgumentException("influencerId is required");
        }
    }
}
