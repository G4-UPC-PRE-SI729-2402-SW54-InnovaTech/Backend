package pe.upc.connexbackend.campaigns.domain.services;

import pe.upc.connexbackend.campaigns.domain.model.aggregates.Campaign;
import pe.upc.connexbackend.campaigns.domain.model.commands.AddRegistrationToCampaignCommand;
import pe.upc.connexbackend.campaigns.domain.model.commands.CreateCampaignCommand;
import pe.upc.connexbackend.campaigns.domain.model.commands.DeleteCampaignCommand;
import pe.upc.connexbackend.campaigns.domain.model.commands.UpdateCampaignCommand;

import java.util.Optional;

public interface CampaignCommandService {
    Optional<Campaign> handle(CreateCampaignCommand command);
    Optional<Campaign> handle(UpdateCampaignCommand command);
    void handle(DeleteCampaignCommand command);
    Optional<Campaign> handle(AddRegistrationToCampaignCommand command);
}
