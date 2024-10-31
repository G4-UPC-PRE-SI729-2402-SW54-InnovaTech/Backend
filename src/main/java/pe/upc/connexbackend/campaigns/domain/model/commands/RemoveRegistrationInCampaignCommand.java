package pe.upc.connexbackend.campaigns.domain.model.commands;

public record RemoveRegistrationInCampaignCommand (
        Integer campaignId,
        Integer userId
){
}
