package pe.upc.connexbackend.users.domain.model.commands;

// Define un comando inmutable para eliminar una entidad de Influencer
public record DeleteInfluencerCommand(Integer influencerId) {
    
    // Constructor validado que lanza una excepción si el ID del influencer es nulo
    public DeleteInfluencerCommand {
        if (influencerId == null) {
            throw new IllegalArgumentException("Influencer ID is required");
        }
    }
}
