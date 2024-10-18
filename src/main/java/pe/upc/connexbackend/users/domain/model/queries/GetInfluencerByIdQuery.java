package pe.upc.connexbackend.users.domain.model.queries;

public record GetInfluencerByIdQuery(Integer influencerId) {
    public GetInfluencerByIdQuery {
        if (influencerId == null) {
            throw new IllegalArgumentException("influencerId is required");
        }
    }
}
