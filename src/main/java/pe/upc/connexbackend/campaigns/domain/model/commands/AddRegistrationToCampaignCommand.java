package pe.upc.connexbackend.campaigns.domain.model.commands;

public record AddRegistrationToCampaignCommand(
        Integer campaignId,
        Integer userId
) {
    public AddRegistrationToCampaignCommand {
        if (campaignId == null || campaignId <= 0) {
            throw new IllegalArgumentException("Campaign id cannot be null or empty");
        }
        if (userId == null || userId <= 0) {
            throw new IllegalArgumentException("User id cannot be null or empty");
        }
    }
}
