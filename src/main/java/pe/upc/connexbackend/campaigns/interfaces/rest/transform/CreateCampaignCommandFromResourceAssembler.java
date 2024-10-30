package pe.upc.connexbackend.campaigns.interfaces.rest.transform;

import pe.upc.connexbackend.campaigns.domain.model.commands.CreateCampaignCommand;
import pe.upc.connexbackend.campaigns.interfaces.rest.resources.CreateCampaignResource;

public class CreateCampaignCommandFromResourceAssembler {
    public static CreateCampaignCommand toCommandFromResource(CreateCampaignResource resource) {
        return new CreateCampaignCommand(
                resource.title(),
                resource.description(),
                resource.status(),
                resource.creatorId(),
                resource.startDate(),
                resource.endDate()

        );
    }
}
