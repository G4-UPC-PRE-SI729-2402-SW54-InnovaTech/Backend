package pe.upc.connexbackend.users.domain.model.commands;

public record DeleteInfluencerCommand(Integer influencerId) {
    public DeleteInfluencerCommand {
        if (influencerId == null) {
            throw new IllegalArgumentException("Influencer ID is required");
        }
    }
}
