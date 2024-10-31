package pe.upc.connexbackend.campaigns.domain.model.commands;

public record DeleteCampaignCommand(Integer campaignId) {
    public DeleteCampaignCommand {
        if (campaignId == null) {
            throw new IllegalArgumentException("Campaign ID is required");
        }
    }
}