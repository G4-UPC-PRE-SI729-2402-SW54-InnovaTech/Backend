package pe.upc.connexbackend.campaigns.domain.model.queries;

public record GetRegistrationsByCampaignIdQuery(Integer campaignId) {
    public GetRegistrationsByCampaignIdQuery {
        if (campaignId == null || campaignId <= 0) {
            throw new IllegalArgumentException("Campaign id cannot be null or empty");
        }
    }
}
