package pe.upc.connexbackend.campaigns.interfaces.rest.transform;


import pe.upc.connexbackend.campaigns.domain.model.aggregates.Campaign;
import pe.upc.connexbackend.campaigns.interfaces.rest.resources.CampaignResource;

public class CampaignResourceFromEntityAssembler {
    public static CampaignResource toResourceFromEntity(Campaign entity) {
        return new CampaignResource(
                entity.getId(),
                entity.getTitle(),
                entity.getDescription(),
                entity.getCreatorId(),
                entity.getStatus(),
                entity.getStartDate(),
                entity.getEndDate()
        );
    }
}
